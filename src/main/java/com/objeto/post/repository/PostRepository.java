package com.objeto.post.repository;

import com.objeto.login.entity.User;
import com.objeto.post.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, String> {

    Post findPostByPostId(String postId);

    List<Post> findPostByBoardId(String boardId);
}
