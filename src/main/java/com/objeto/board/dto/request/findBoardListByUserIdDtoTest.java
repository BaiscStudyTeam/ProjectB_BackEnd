package com.objeto.board.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class findBoardListByUserIdDtoTest {

    @NotEmpty
    private final String userId;

}
