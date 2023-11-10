package com.service.disroauthservice.event;

import lombok.Data;

@Data
public class LoginHandlerEvent {
    private String email;
    private String password;
}
