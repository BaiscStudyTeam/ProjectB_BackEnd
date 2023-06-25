package com.objeto.signup.dto.request;

import com.objeto.security.PatternUtils;
import com.objeto.signup.dto.SignUpDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SendVarificationEmailReqDto {

    @NotEmpty
    @Pattern(regexp = PatternUtils.passwordPattern)
    private String email;

    @Builder
    public SendVarificationEmailReqDto(String email) {
        this.email = email;
    }

    public SignUpDto toEntity() {
        return SignUpDto.builder()
                .email(this.email)
                .build();
    }
}
