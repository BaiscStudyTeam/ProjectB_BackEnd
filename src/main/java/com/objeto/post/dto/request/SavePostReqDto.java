package com.objeto.post.dto.request;

import com.objeto.post.dto.PostDto;
import com.objeto.post.entity.Post;
import com.objeto.post.entity.PostContent;
import com.objeto.security.encrypt.EncryptUtils;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class SavePostReqDto {

    @NotEmpty
    private String userId;

    @NotEmpty
    private String postTitle;

    @NotEmpty
    private String postType;

    private String postFile;

    private String content;

    private String contentSum;

    private String thumbnailImg;

    public Timestamp getRegDt() {
        return new Timestamp(System.currentTimeMillis());
    }

    @Builder
    public SavePostReqDto(String userId, String postTitle, String postType, String postFile, String content, String contentSum, String thumbnailImg) {
        this.userId = userId;
        this.postTitle = postTitle;
        this.postType = postType;
        this.postFile = postFile;
        this.content = content;
        this.contentSum = contentSum;
        this.thumbnailImg = thumbnailImg;
    }

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
