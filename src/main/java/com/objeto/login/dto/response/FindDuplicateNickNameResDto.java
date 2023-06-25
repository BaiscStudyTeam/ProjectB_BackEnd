package com.objeto.login.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class FindDuplicateNickNameResDto {

    private String nickname;

    @Builder
    public FindDuplicateNickNameResDto(String nickname) {
        this.nickname = nickname;
    }
}
