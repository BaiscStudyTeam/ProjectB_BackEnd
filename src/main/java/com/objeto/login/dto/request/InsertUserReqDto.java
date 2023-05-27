package com.objeto.login.dto.request;

import com.objeto.login.dto.LoginDto;
import lombok.Getter;

@Getter
public class InsertUserReqDto {

    private String userId;

    private String userPassword;

    public LoginDto convert() {
        return LoginDto.builder()
                .userId(this.userId)
                .userPassword(this.userPassword).build();
    }

}
