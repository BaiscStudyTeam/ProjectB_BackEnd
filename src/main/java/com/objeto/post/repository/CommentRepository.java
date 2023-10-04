package com.objeto.post.repository;

import com.objeto.post.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, String> {

    Comment findCommentByCommentId(String commentId);

    List<Comment> findCommentByPostId(String commentId);

    int removeByCommentId(String commentId);
}
