package com.objeto.login.service;

import com.objeto.jwt.JwtTokenProvider;
import com.objeto.login.dto.LoginDto;
import com.objeto.login.dto.request.RemoveUserReqDto;
import com.objeto.login.dto.request.UpdateUserReqDto;
import com.objeto.login.dto.response.FindUserResDto;
import com.objeto.login.entity.MyUserDetails;
import com.objeto.login.entity.User;
import com.objeto.login.repository.UserRepository;
import com.objeto.security.encrypt.EncryptUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public FindUserResDto validateLogin(HttpServletResponse response, LoginDto dto) {
        // check emali duplication
        User member = userRepository.findUserByEmail(dto.getEmail());
        if (Objects.isNull(member)) throw new BadCredentialsException("Jwt Authentication Failed : User not Exist");
        // check password is correct
        BCryptPasswordEncoder ec = new BCryptPasswordEncoder();

        if(!ec.matches(dto.getUserPassword(), member.getPassword())) {
            throw new BadCredentialsException("Jwt Authentication Failed : Password doesn't match");
        }

        // set jwtToken for login User
        Cookie cookie = new Cookie("authentication", jwtTokenProvider.createToken(member.getUserId()));
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        // return user info to responesEntity body
        return FindUserResDto.builder().email(member.getEmail()).nickname(member.getNickname()).build();
    }

    @Transactional
    public User updateUser(UpdateUserReqDto dto) {
        // JwtToken을 통해 파싱된 User 정보를 Security ContextHolder에서 꺼냄
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails user = (MyUserDetails) authentication.getPrincipal();
        User beforeUser = userRepository.findUserByUserId(user.getUserId());

        // Nickname 혹은 패스워드가 존재한다면 업데이트 하지 않음
        String nickname = "".equals(dto.getNickname()) ? beforeUser.getNickname() : dto.getNickname();
        String password = "".equals(dto.getPassword()) ? beforeUser.getPassword() : EncryptUtils.executeBCryptPasswordEncoder(dto.getPassword());

        // Update
        User afterUser = User.builder()
                .userId(beforeUser.getUserId())
                .email(beforeUser.getEmail())
                .password(password.trim())
                .nickname(nickname.trim())
                .regDt(new Timestamp(System.currentTimeMillis()))
                .build();
        return userRepository.save(afterUser);
    }

    @Transactional
    public void removeUser(RemoveUserReqDto reqDto) {
        userRepository.removeByEmail(reqDto.getEmail());
    }

    @Transactional
    public void logoutUser(HttpServletResponse response) {
        // remove jwtToken value
        Cookie cookie = new Cookie("authentication", "");
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }
}