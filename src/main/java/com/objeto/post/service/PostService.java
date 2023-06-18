package com.objeto.post.service;

import com.objeto.post.dto.PostDto;
import com.objeto.post.entity.Post;
import com.objeto.post.repository.PostContentRepository;
import com.objeto.post.repository.PostRepository;
import com.objeto.post.repository.ThumbnailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final PostContentRepository postContentRepository;

    private final ThumbnailRepository thumbnailRepository;
    public Post findPostByPostId(String postId) {
        return postRepository.findPostByPostId(postId);
    }

    @Transactional
    public void savePost(PostDto reqDto) {
        // 1. post를 저장해야한다.
        postRepository.save(reqDto.toPostEntity());
        // 2 post Content를 저장해야한다.
        postContentRepository.save(reqDto.toPostContentEntity());
        // 3 post Thumbnail을 저장해야한다
        thumbnailRepository.save(reqDto.toThumbnailEntity());
    }
}
