package com.service.disroauthservice.core.events;

import lombok.Data;

@Data
public class LoginHandlerEvent {
    private String email;
    private String password;
}
