package com.service.disroauthservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class LoginHandlerCommand {
    @TargetAggregateIdentifier
    private final String email;
    private final String password;
}
