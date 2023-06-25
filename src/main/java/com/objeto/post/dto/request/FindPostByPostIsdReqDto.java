package com.objeto.post.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FindPostByPostIsdReqDto {

    @NotEmpty
    private String postId;
}
