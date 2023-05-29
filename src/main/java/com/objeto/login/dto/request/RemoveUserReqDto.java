package com.objeto.login.dto.request;

import com.objeto.security.PatternUtils;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RemoveUserReqDto {

    @NotEmpty
    @Pattern(regexp = PatternUtils.emailPattern)
    private String email;

    @Builder
    public RemoveUserReqDto(String email) {
        this.email = email;
    }

}
