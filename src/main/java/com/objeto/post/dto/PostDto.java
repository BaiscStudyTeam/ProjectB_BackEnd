package com.objeto.post.dto;

import com.objeto.post.entity.Post;
import com.objeto.post.entity.PostContent;
import com.objeto.post.entity.Thumbnail;
import com.objeto.security.encrypt.EncryptUtils;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.sql.Timestamp;

public class PostDto {

    private String postId;

    private String userId;

    private String postTitle;

    private String postType;

    private String postFile;

    private String content;

    private String contentSum;

    private String thumbnailImg;

    public Timestamp getRegDt() {
        return new Timestamp(System.currentTimeMillis());
    }

    @Builder
    public PostDto(String postId, String userId, String postTitle, String postType, String postFile, String content, String contentSum, String thumbnailImg) {
        this.postId = postId;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postType = postType;
        this.postFile = postFile;
        this.content = content;
        this.contentSum = contentSum;
        this.thumbnailImg = thumbnailImg;
    }


    public Post toPostEntity() {
        return Post.builder()
                .postId(this.postId)
                .userId(this.userId)
                .postFile(this.postFile)
                .postTitle(this.postTitle)
                .postType(this.postType)
                .regDt(this.getRegDt())
                .build();
    }

    public PostContent toPostContentEntity() {
        return PostContent.builder()
                .postId(this.postId)
                .postContent(this.content)
                .build();
    }

    public Thumbnail toThumbnailEntity() {
        return Thumbnail.builder()
                .postId(this.postId)
                .userId(this.userId)
                .title(this.postTitle)
                .contentSum(this.contentSum)
                .thumbnailImg(this.thumbnailImg)
                .regDt(this.getRegDt())
                .build();
    }
}
