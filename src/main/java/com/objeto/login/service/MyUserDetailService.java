package com.objeto.login.service;

import com.objeto.login.entity.MyUserDetails;
import com.objeto.login.entity.User;
import com.objeto.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserId(userId);

        // 인증 실패 시
        if(Objects.isNull(user)) new BadCredentialsException("JwtAuthToken validation Failed : UserDetail returns Empty User");

        // 인증 성공 시
        log.info("Success find member {}", user);
        MyUserDetails details = new MyUserDetails();
        details.setUserId(user.getUserId());
        details.setNickname(user.getNickname());
        details.setEmail(user.getEmail());
        return details;
    }
}
