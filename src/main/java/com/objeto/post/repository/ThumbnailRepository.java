package com.objeto.post.repository;

import com.objeto.post.entity.Thumbnail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ThumbnailRepository extends CrudRepository<Thumbnail, String> {

    @Override
    Optional<Thumbnail> findById(String s);
    @Override
    List<Thumbnail> findAll();
    default List<Thumbnail> findTop50() {
        return findAll().subList(0,50);
    }

    List<Thumbnail> findTop3ByOrderByRegDtDesc();
}
