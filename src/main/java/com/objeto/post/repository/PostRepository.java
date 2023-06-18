package com.objeto.post.repository;

import com.objeto.login.entity.User;
import com.objeto.post.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, String> {

    Post findPostByPostId(String postId);
}
