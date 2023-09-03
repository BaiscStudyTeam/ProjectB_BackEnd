package com.objeto.login.dto.response;

import lombok.*;

@Getter
@Setter
public class FindUserResDto {

    /* 사용자 이메일 */
    @Getter
    private String email;

    /*사용자 닉네임*/
    @Getter
    private String nickname;

    @Builder
    public FindUserResDto(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
