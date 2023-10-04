package com.objeto.post.service;

import com.objeto.post.entity.Comment;
import com.objeto.post.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> findCommentByPostId(String postId) {
        return commentRepository.findCommentByPostId(postId);
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(String commentId) {
        commentRepository.removeByCommentId(commentId);
    }
}
