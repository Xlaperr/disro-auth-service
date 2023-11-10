package com.service.disroauthservice.model;

import lombok.Data;

@Data
public class ChangePasswordModel {
    private String Email;
    private String Password;
}
