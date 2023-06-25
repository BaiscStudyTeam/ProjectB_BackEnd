package com.objeto.post.controller;

import com.objeto.post.dto.request.SavePostReqDto;
import com.objeto.post.entity.Post;
import com.objeto.post.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/post")
public class PostController {


    private final PostService postService;


    /**
     * validate Login and give Jwt Token for user
     * @return post Thumbnail
     */
    @GetMapping("/findPostByPostId")
    public ResponseEntity<Post> findPostByPostId(@RequestParam @NotEmpty String postId) {
        return ResponseEntity.ok( postService.findPostByPostId(postId));
    }

    /**
     * validate Login and give Jwt Token for user
     * @return post Thumbnail
     */
    @PutMapping("/savePost")
    public ResponseEntity<String> savePost(@RequestBody @Valid SavePostReqDto reqDto) {
        postService.savePost(reqDto.toEntity());
        return ResponseEntity.ok(null);
    }

    /**
     * validate Login and give Jwt Token for user
     * @return post Thumbnail
     */
    @DeleteMapping("/deletePost")
    public ResponseEntity<String> deletePost() {
        return ResponseEntity.ok(null);
    }
}
