package com.service.disroauthservice.rest;

import com.service.disroauthservice.command.CreateUserCommand;
import com.service.disroauthservice.command.LoginHandlerCommand;
import com.service.disroauthservice.core.data.UserEntity;
import com.service.disroauthservice.core.data.UserRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/auth-service")
public class AuthController {

    private final CommandGateway commandGateway;
    private final UserRepository userRepository;

    public AuthController(CommandGateway commandGateway, UserRepository userRepository) {
        this.commandGateway = commandGateway;
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<UserEntity> getuser(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        Optional<UserEntity> userOptional = Optional.ofNullable(userRepository.findByUserName(username));

        return userOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public String register(@RequestBody CreateUserCommand model) {
        CreateUserCommand command = CreateUserCommand.builder()
                .userId(UUID.randomUUID().toString())
                .userName(model.getUserName())
                .phone(model.getPhone())
                .email(model.getEmail())
                .password(model.getPassword())
                .dob(model.getDob())
                .build();

        String result;

        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginHandlerCommand model) {
        // Retrieve user from the database based on the provided email
        Optional<UserEntity> userOptional = Optional.ofNullable(userRepository.findByEmail(model.getEmail()));

        if (userOptional.isPresent()) {
            // If the user exists, check the password
            UserEntity user = userOptional.get();
            if (user.getPassword().equals(model.getPassword())) {
                // Passwords match, login successful
                return ResponseEntity.ok(user);
            } else {
                // Passwords do not match
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
            }
        } else {
            // User with the provided email not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}
