package com.objeto.login.repository;

import com.objeto.login.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findUserByEmail(String email);

    User findUserByUserId(String userId);

    int countByEmail(String email);

    int countByNickname(String nickname);

    int removeByEmail(String email);
}
