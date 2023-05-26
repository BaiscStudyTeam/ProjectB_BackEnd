package com.objeto.login.service;

import com.objeto.login.entity.User;
import com.objeto.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    @Transactional
    public User insertLoginUser() {
        // Sentry Performance info set;
        User user = new User();
        user.setUserId(UUID.randomUUID().toString().substring(0,30));
        user.setUserPassword("1234");
        user.setRegDt(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }
}

