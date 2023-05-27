package com.objeto.login.controller;

import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.dto.request.LoginReqDto;
import com.objeto.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/")
    public String login(LoginReqDto reqDto) {
        return loginService.validateLogin(reqDto.convert());
    }

    // PULLREQUEST용 주석 추가
    @GetMapping("/insertUser")
    public ResponseEntity<String> insertUser(InsertUserReqDto reqDto) {
        loginService.insertLoginUser(reqDto.convert());
        return ResponseEntity.ok().body("SUCCESS");
    }

    // PULLREQUEST용 주석 추가
    @GetMapping("/testSentry")
    public ResponseEntity<String> testSentry() {
        if(true) throw new NullPointerException();
        return ResponseEntity.ok().body(null);
    }
}
