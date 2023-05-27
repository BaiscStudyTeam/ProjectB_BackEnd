package com.objeto.login.dto;

import com.objeto.login.entity.User;
import com.objeto.security.encrypt.EncryptUtils;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class LoginDto {

    private String userId;

    private String userPassword;

    @Builder
    public LoginDto(String userId, String userPassword, String regDt) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public Timestamp getRegDt() {
        return new Timestamp(System.currentTimeMillis());
    }

    public String getUserIdCode() {
        return EncryptUtils.randomIdGenerator();
    }


    public User toEntity() {
        return User.builder()
                .userId(EncryptUtils.randomIdGenerator())
                .userPassword(this.userPassword)
                .regDt(this.getRegDt())
                .build();
    }
}
