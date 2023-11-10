package com.service.disroauthservice.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 163149755533128899L;
    @Id
    @Column(unique = true)
    private String userId;

    @Column(unique = true)
    private String userName;
    private String password;
    private String phone;
    private String email;
    private Date dob;
}
