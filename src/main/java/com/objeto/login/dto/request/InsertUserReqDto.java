package com.objeto.login.dto.request;

import com.objeto.login.dto.LoginDto;
import com.objeto.security.PatternUtils;
import com.objeto.security.encrypt.EncryptUtils;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InsertUserReqDto {

    @NotEmpty
    @Pattern(regexp = PatternUtils.emailPattern)
    private String email;

    @NotEmpty
    @Pattern(regexp = PatternUtils.nickNamePattern)
    private String nickName;

    @NotEmpty
    @Pattern(regexp = PatternUtils.passwordPattern)
    private String password;

    @Builder
    public InsertUserReqDto(String email, String nickName, String password) {
        this.email = email;
        this.nickName = nickName;
        this.password = password;
    }

    public String getUserUUID() {
        return EncryptUtils.randomIdGenerator();
    }

    public LoginDto convert() {
        return LoginDto.builder()
                .userId(getUserUUID())
                .nickName(this.nickName)
                .email(this.email)
                .userPassword(this.password).build();
    }

}
