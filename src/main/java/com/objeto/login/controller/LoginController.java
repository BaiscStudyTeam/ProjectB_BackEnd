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
        String token = loginService.validateLogin(reqDto.convert());
        return "<form action='/login/checkUserInfo' method='post'><input type='hidden' name='token' value='" + token + "'>" +
                "<input type='hidden' name='X-AUTH-TOKEN' value='" + token + "'>" +
                "<input type='submit' value='Login'></form>";

    }

    /**
     * insert new User's information
     * @param reqDto
     * @return http requet body OK
     */
    @PostMapping("/insertUser")
    public ResponseEntity<String> insertUser(InsertUserReqDto reqDto) {
        loginService.insertLoginUser(reqDto.convert());
        return ResponseEntity.ok("ok");
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
