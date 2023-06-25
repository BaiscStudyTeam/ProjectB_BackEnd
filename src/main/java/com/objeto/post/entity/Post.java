package com.objeto.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Entity(name="post")
@Getter
@DynamicUpdate
@NoArgsConstructor
public class Post {

    /**
     * post id
     */
    @Id
    private String postId;
    /**
     * registe user id
     */
    private String userId;

    /**
     * post title url
     */
    private String postTitle;

    /**
     * post file url
     */
    private String postFile;

    /**
     * post file url
     */
    private String postType;

    /**
     * thumbnail Register date
     */
    private Timestamp regDt;

    /**
     * builder for immutable java Object
     */
    @Builder
    public Post(String postId, String userId, String postTitle, String postFile, String postType, Timestamp regDt) {
        this.postId = postId;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postFile = postFile;
        this.postType = postType;
        this.regDt = regDt;
    }
}
