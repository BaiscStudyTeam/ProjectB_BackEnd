package com.objeto.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Entity(name="thumbnail")
@Getter
@DynamicUpdate
@NoArgsConstructor
public class Thumbnail {

    /**
     * thumbnail id that FK of post table's post_id
     */
    @Id
    private String postId;
    /**
     * thumbnail register user Id
     */
    private String userId;

    /**
     * thumbnail title
     */
    private String title;

    /**
     * thumbnail content summary
     */
    private String contentSum;

    /**
     * thumbnail img uri
     */
    private String thumbnailImg;

    /**
     * thumbnail Register date
     */
    private Timestamp regDt;

    /**
     * builder for immutable java Object
     *
     */
    @Builder
    public Thumbnail(String postId, String userId, String title, String contentSum, String thumbnailImg, Timestamp regDt) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.contentSum = contentSum;
        this.thumbnailImg = thumbnailImg;
        this.regDt = regDt;
    }
}
