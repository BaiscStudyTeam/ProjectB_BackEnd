package com.objeto.post.dto.request;

import com.objeto.post.entity.Comment;
import com.objeto.security.encrypt.EncryptUtils;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class SaveCommentReqDto {

    @NotEmpty
    private String postId;

    @NotEmpty
    private String commentContent;

    @NotNull
    private LocalDateTime regDt;

    public Comment toEntity() {
        return Comment.builder()
                .commentId(EncryptUtils.randomIdGenerator())
                .postId(this.postId)
                .commentContent(this.commentContent)
                .regDt(Timestamp.valueOf(this.regDt))
                .build();
    }


}
