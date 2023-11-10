package com.service.disroauthservice.command;

import com.service.disroauthservice.core.events.CreateUserEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class CreateUserAggregate {

    @AggregateIdentifier
    private String userId;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private Date dob;

    public CreateUserAggregate() {
    }

    @CommandHandler
    public CreateUserAggregate(CreateUserCommand createUserCommand) {
        if (createUserCommand.getUserName().isBlank() || createUserCommand.getUserName() == null) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (createUserCommand.getEmail().isBlank() || createUserCommand.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if (createUserCommand.getPhone().isBlank() || createUserCommand.getPhone() == null) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }

        if (createUserCommand.getPassword().isBlank() || createUserCommand.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        CreateUserEvent createUserEvent = new CreateUserEvent();
        BeanUtils.copyProperties(createUserCommand, createUserEvent);
        AggregateLifecycle.apply(createUserEvent);
    }

    @EventSourcingHandler
    public void createUserActive(CreateUserEvent createUserEvent) {
        this.userId = createUserEvent.getUserId();
        this.email = createUserEvent.getEmail();
        this.userName = createUserEvent.getUserName();
        this.dob = createUserEvent.getDob();
        this.phone = createUserEvent.getPhone();
        this.password = createUserEvent.getPassword();
    }
}
