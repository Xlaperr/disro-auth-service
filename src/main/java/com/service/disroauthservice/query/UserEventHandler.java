package com.service.disroauthservice.query;

import com.service.disroauthservice.core.data.UserEntity;
import com.service.disroauthservice.core.data.UserRepository;
import com.service.disroauthservice.core.events.CreateUserEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {
    private final UserRepository userRepository;

    public UserEventHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventHandler
    public void UserEventHandlerActive(CreateUserEvent event) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(event, userEntity);
        userRepository.save(userEntity);
    }
}
