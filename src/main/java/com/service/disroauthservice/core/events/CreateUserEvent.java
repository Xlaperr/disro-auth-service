package com.service.disroauthservice.core.events;

import lombok.Data;

import java.util.Date;

@Data
public class CreateUserEvent {
    private String userId;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private Date dob;
}
