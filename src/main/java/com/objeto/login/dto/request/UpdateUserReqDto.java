package com.objeto.login.dto.request;

import com.objeto.login.dto.LoginDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserReqDto {

    private String nickname;

    private String password;

    @Builder
    public UpdateUserReqDto(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }



    public LoginDto convert(String userId) {
        return LoginDto.builder()
                .userId(userId)
                .userPassword(this.password)
                .nickName(this.nickname)
                .userPassword(this.password).build();
    }
}
