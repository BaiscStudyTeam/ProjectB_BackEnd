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
    @Pattern(regexp = PatternUtils.nickNamePattern)
    private String nickname;

    @NotEmpty
    @Pattern(regexp = PatternUtils.passwordPattern)
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
