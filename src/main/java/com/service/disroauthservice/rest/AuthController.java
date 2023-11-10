package com.service.disroauthservice.rest;

import com.service.disroauthservice.command.CreateUserCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/auth-service")
public class AuthController {

    private final CommandGateway commandGateway;

    public AuthController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
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
    public String login() {
        return "Login Success";
    }
}
