package com.objeto.post.dto.request;

import com.objeto.post.dto.PostDto;
import com.objeto.security.encrypt.EncryptUtils;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class SavePostReqDto {

    @NotEmpty
    private final String userId;

    @NotEmpty
    private final String postTitle;

    @NotEmpty
    private final String postType;

    private final String postFile;

    private final String content;

    private final String contentSum;

    private final String thumbnailImg;

    private final LocalDateTime regDt;

    private final String zoneId;

    public PostDto toEntity() {
        return PostDto.builder()
                .postId(EncryptUtils.randomIdGenerator())
                .userId(this.userId)
                .postFile(this.postFile)
                .postTitle(this.postTitle)
                .postType(this.postType)
                .content(this.content)
                .contentSum(this.contentSum)
                .thumbnailImg(this.thumbnailImg)
                .build();
    }

}
