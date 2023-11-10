package com.service.disroauthservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Builder
@Data
public class CreateUserCommand {
    @TargetAggregateIdentifier
    private final String userId;
    private final String userName;
    private final String email;
    private final String password;
    private final String phone;
    private final Date dob;
}
