package com.service.disroauthservice.command;

import com.service.disroauthservice.core.events.LoginHandlerEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class LoginHandlerAggregate {

    @AggregateIdentifier
    private String email;
    private String password;

    public LoginHandlerAggregate() {
    }

    @CommandHandler
    public LoginHandlerAggregate(LoginHandlerCommand loginHandlerCommand) {
        if (loginHandlerCommand.getEmail().isBlank() || loginHandlerCommand.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        LoginHandlerEvent loginHandlerEvent = new LoginHandlerEvent();
        BeanUtils.copyProperties(loginHandlerCommand, loginHandlerEvent);
        AggregateLifecycle.apply(loginHandlerEvent);
    }

    @EventSourcingHandler
    public void createUserActive(LoginHandlerEvent loginHandlerEvent) {
        this.email = loginHandlerEvent.getEmail();
        this.password = loginHandlerEvent.getPassword();
    }
}
