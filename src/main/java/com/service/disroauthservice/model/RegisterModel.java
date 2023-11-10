package com.service.disroauthservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterModel {
    private String Username;
    private String Email;
    private String Password;
    private String Phone;
    private Date DOB;
}
