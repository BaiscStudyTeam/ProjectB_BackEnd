package com.objeto.login.dto;

import com.objeto.login.entity.User;
import com.objeto.security.encrypt.EncryptUtils;
import lombok.*;

import java.sql.Timestamp;

@Getter
public class LoginDto {

    private String userId;

    private String email;

    private String nickName;

    private String userPassword;

    public Timestamp getRegDt() {
        return new Timestamp(System.currentTimeMillis());
    }

    public String getUserIdCode() {
        return EncryptUtils.randomIdGenerator();
    }

    @Builder
    public LoginDto(String userId, String email, String nickName, String userPassword) {
        this.userId = userId;
        this.email = email;
        this.nickName = nickName;
        this.userPassword = userPassword;
    }


    public User toEntity() {
        return User.builder()
                .userId(EncryptUtils.randomIdGenerator())
                .email(this.email)
                .nickname(this.nickName)
                .password(EncryptUtils.executeBCryptPasswordEncoder(this.userPassword))
                .regDt(this.getRegDt())
                .build();
    }
}
