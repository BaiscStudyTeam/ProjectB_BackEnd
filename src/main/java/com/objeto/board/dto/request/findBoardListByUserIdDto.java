package com.objeto.board.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class findBoardListByUserIdDto {

    @NotEmpty
    private String userId;

    @Builder
    public findBoardListByUserIdDto(String userId) {
        this.userId = userId;
    }

}
