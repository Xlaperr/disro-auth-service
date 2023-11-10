package com.service.disroauthservice.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
public class AuthController {
    @PostMapping("/register")
    public String Register() {
        return "Register Successful";
    }

    @PutMapping("/change-password")
    public String ChangePassword() {
        return "Password changed";
    }
}
