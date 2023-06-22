package com.objeto.post.controller;

import com.objeto.post.dto.request.DeleteCommentReqDto;
import com.objeto.post.dto.request.FindPostByPostIsdReqDto;
import com.objeto.post.dto.request.SaveCommentReqDto;
import com.objeto.post.dto.request.UpdateByCommentIdReqDto;
import com.objeto.post.entity.Comment;
import com.objeto.post.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/comment")
public class CommentController {

    private final CommentService commentService;


    @GetMapping("/findByPostId")
    public ResponseEntity<Comment> findPostByPostId(@RequestParam @Valid FindPostByPostIsdReqDto reqDto) {
        return ResponseEntity.ok(commentService.findPostByPostId(reqDto.getPostId()));
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
