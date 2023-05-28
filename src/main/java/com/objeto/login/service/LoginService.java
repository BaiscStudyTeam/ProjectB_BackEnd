package com.objeto.login.service;

import com.objeto.jwt.JwtTokenProvider;
import com.objeto.login.dto.LoginDto;
import com.objeto.login.entity.User;
import com.objeto.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public User insertLoginUser(LoginDto dto) {
        return userRepository.save(dto.toEntity());
    }

    @Transactional
    public String validateLogin(LoginDto dto) {
        // check emali duplication
        User member = userRepository.findUserByEmail(dto.getEmail());
        if (Objects.isNull(member)) throw new BadCredentialsException("Jwt Authentication Failed : User not Exist");
        // check password is correct
        if (!member.getPassword().equals(dto.getUserPassword())) throw new BadCredentialsException("Jwt Authentication Failed : Password doesn't match");
        // return jwtToken for login User
        return jwtTokenProvider.createToken(member.getEmail(), member.getNickname());
    }
}

