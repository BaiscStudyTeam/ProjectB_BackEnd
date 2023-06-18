package com.objeto.post.controller;

import com.objeto.post.entity.Thumbnail;
import com.objeto.post.service.MainPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/mainPost")
public class MainPostController {

    private final MainPostService mainPostService;


    /**
     * validate Login and give Jwt Token for user
     * @return post Thumbnail
     */
    @GetMapping("/findTopPostThumbnailList")
    public ResponseEntity<List<Thumbnail>> findUser() {
        return ResponseEntity.ok( mainPostService.findTopPostThumbnailList());
    }
}
