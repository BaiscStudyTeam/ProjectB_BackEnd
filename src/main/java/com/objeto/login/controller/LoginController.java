package com.objeto.login.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.dto.request.LoginReqDto;
import com.objeto.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    /**
     * validate Login and give Jwt Token for user
     * @param reqDto
     * @return jwt Token String value
     */
    @GetMapping("/")
    public String login(LoginReqDto reqDto, HttpServletResponse response) throws IOException {
        try {
            String token = loginService.validateLogin(reqDto.convert());
            return "input this jwtToken in .http test file : " + token;
        } catch(Exception e) {
            return e.getMessage() + " : your login has failed";
        }
    }

    /**
     * insert new User's information
     * @param reqDto
     * @return http requet body OK
     */
    @PostMapping("/insertUser")
    public ResponseEntity<String> insertUser(InsertUserReqDto reqDto) {
        loginService.insertLoginUser(reqDto.convert());
        return ResponseEntity.ok("your account has been created. go to address \\home.html");
    }


    /**
     * check login user's jwt token payload info
     * @return login user's email and nickname
     */
    @PostMapping("/checkUserInfo")
    public ResponseEntity<String> checkUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok("ok");
    }
}
