package com.objeto.signup.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpDto {

    private String email;

    @Builder
    public SignUpDto(String email) {
        this.email = email;
    }
}
