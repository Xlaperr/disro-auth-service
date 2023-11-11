package com.service.disroauthservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUserName(String userName);

    UserEntity findByEmail(String email);

}
