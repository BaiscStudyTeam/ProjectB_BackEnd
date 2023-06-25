package com.objeto.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Entity(name="post_content")
@Getter
@DynamicUpdate
@NoArgsConstructor
public class PostContent {

    /**
     * post id
     */
    @Id
    private String postId;

    private String postContent;

    @Builder
    public PostContent(String postId, String postContent) {
        this.postId = postId;
        this.postContent = postContent;
    }
}
