package com.objeto.post.service;

import com.objeto.post.entity.Comment;
import com.objeto.post.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment findPostByPostId(String postId) {
        return commentRepository.findCommentByPostId(postId);
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(String commentId) {
        commentRepository.removeByCommentId(commentId);
    }
}
