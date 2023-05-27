package com.objeto.login.dto.request;

import com.objeto.login.dto.LoginDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginReqDto {

    private String userId;

    private String userPassword;

    public LoginReqDto(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public LoginDto convert() {
        return LoginDto.builder()
                .userId(this.userId)
                .userPassword(this.userPassword).build();
    }

}
