package com.service.disroauthservice.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-service")
public class UserController {
    @PostMapping("/login")
    public String Login() {
        return "Login Success";
    }
}
