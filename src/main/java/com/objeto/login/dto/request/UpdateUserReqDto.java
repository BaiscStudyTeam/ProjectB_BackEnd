package com.objeto.login.dto.request;

import com.objeto.login.dto.LoginDto;
import com.objeto.security.PatternUtils;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserReqDto {

    @NotEmpty
    private String userId;

    private String nickName;

    private String password;

    @Builder
    public UpdateUserReqDto(String userId, String nickName, String password) {
        this.userId = userId;
        this.nickName = nickName;
        this.password = password;
    }



    public LoginDto convert() {
        return LoginDto.builder()
                .userId(this.userId)
                .nickName(this.nickName)
                .userPassword(this.password).build();
    }
}
