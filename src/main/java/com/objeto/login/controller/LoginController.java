package com.objeto.login.controller;

import com.objeto.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    // PULLREQUEST용 주석 추가
    @GetMapping("/insertUser")
    public ResponseEntity<Object> insertUser() {
        loginService.insertLoginUser();
        return ResponseEntity.ok().body("SUCCESS");
    }

    // PULLREQUEST용 주석 추가
    @GetMapping("/testSentry")
    public ResponseEntity<Object> testSentry() {
        if(true) throw new NullPointerException();
        return ResponseEntity.ok().body(null);
    }
}
