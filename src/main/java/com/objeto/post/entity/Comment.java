package com.objeto.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Entity(name="comment")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Comment {

    /**
     * registe user id
     */
    @Id
    private String commentId;

    /**
     * post id
     */
    private String postId;

    /**
     * comment User Id
     */
    private String commentUserId;

    /**
     * comment Content
     */
    private String commentContent;

    /**
     * comment Register date
     */
    private Timestamp regDt;
}
