package com.objeto.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="user")
@Getter
@Setter
public class User {

    @Id
    private String userId;

    private String userPassword;

    private java.sql.Timestamp regDt;
}
