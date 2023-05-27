package com.objeto.login.service;

import com.objeto.jwt.JwtTokenProvider;
import com.objeto.login.dto.LoginDto;
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

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public User insertLoginUser(LoginDto dto) {
        return userRepository.save(dto.toEntity());
    }

    public String validateLogin(LoginDto dto) {
        User member = userRepository.findById(dto.getUserId()).orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!member.getUserPassword().equals(dto.getUserPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUserId(), member.getUserPassword());
    }
}

