package com.objeto.post.controller;

import com.objeto.post.dto.request.DeleteCommentReqDto;
import com.objeto.post.dto.request.SaveCommentReqDto;
import com.objeto.post.dto.request.UpdateByCommentIdReqDto;
import com.objeto.post.entity.Comment;
import com.objeto.post.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/comment")
public class CommentController {

    private final CommentService commentService;


    /**
     * find comment by post Id
     * @param postId postId to find CommentList
     * @return comment list
     */
    @GetMapping("/findCommentByPostId")
    public ResponseEntity<List<Comment>> findPostByPostId(@RequestParam @Valid String postId) {
        return ResponseEntity.ok(commentService.findCommentByPostId(postId));
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid UpdateByCommentIdReqDto reqDto) {
        commentService.saveComment(reqDto.toEntity());
        return ResponseEntity.ok(null);
    }

    @PutMapping("/save")
    public ResponseEntity<String> savePost(@RequestBody @Valid SaveCommentReqDto reqDto) {
        commentService.saveComment(reqDto.toEntity());
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePost(@RequestBody @Valid DeleteCommentReqDto reqDto) {
        commentService.deleteComment(reqDto.getCommentId());
        return ResponseEntity.ok(null);
    }
}
