package com.objeto.login.dto.request;

import com.objeto.login.dto.LoginDto;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class LoginReqDto {

    private String userId;

    private String userPassword;

    public LoginDto convert() {
        return LoginDto.builder()
                .userId(this.userId)
                .userPassword(this.userPassword).build();
    }

}
