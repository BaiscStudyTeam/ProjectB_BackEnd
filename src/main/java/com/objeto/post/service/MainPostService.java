package com.objeto.post.service;

import com.objeto.post.entity.Thumbnail;
import com.objeto.post.repository.ThumbnailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainPostService {

    private final ThumbnailRepository thumbnailRepository;

    public List<Thumbnail> findTopPostThumbnailList() {
        return thumbnailRepository.findTop3ByOrderByRegDtDesc();
    }
}
