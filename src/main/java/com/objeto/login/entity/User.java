package com.objeto.login.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Entity(name="user")
@Getter
@DynamicUpdate
@NoArgsConstructor
public class User {

    @Id
    private String userId;
    /**
     * user's email. not allow duplication
     */
    private String email;

    /**
     * user's nickname. allow duplication
     */
    private String nickname;

    /**
     * user's password
     */
    private String password;

    /**
     * user Register date
     */
    private java.sql.Timestamp regDt;

    /**
     * builder for immutable java Object
     * @param email user's email
     * @param password user's password
     * @param regDt user's register date
     */
    @Builder
    public User(String userId, String email, String nickname, String password, Timestamp regDt) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.regDt = regDt;
    }

}
