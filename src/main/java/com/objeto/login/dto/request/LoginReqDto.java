package com.objeto.login.dto.request;

import com.objeto.login.dto.LoginDto;
import com.objeto.security.PatternUtils;
import com.objeto.security.encrypt.EncryptUtils;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginReqDto {

    @NotEmpty
    @Pattern(regexp = PatternUtils.emailPattern)
    private String email;

    @NotEmpty
    @Pattern(regexp = PatternUtils.passwordPattern)
    private String password;

    @Builder
    public LoginReqDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginDto convert() {
        return LoginDto.builder()
                .email(this.email)
                .userPassword(this.password).build();
    }

}
