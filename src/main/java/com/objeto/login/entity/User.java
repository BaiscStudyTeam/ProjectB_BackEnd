package com.objeto.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name="user")
@Getter
public class User {

    @Id
    private String userId;

    private String userPassword;

    private java.sql.Timestamp regDt;

    @Builder
    public User(String userId, String userPassword, Timestamp regDt) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.regDt = regDt;
    }

    public User() {

    }
}
