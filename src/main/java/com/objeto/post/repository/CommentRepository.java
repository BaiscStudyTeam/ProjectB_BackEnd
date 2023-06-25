package com.objeto.post.repository;

import com.objeto.post.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, String> {

    Comment findCommentByCommentId(String commentId);

    Comment findCommentByPostId(String commentId);

    int removeByCommentId(String commentId);
}
