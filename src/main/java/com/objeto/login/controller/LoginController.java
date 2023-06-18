package com.objeto.login.controller;

import com.objeto.login.dto.request.RemoveUserReqDto;
import com.objeto.login.dto.request.UpdateUserReqDto;
import com.objeto.login.entity.User;
import lombok.extern.slf4j.Slf4j;
import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.dto.request.FindUserReqDto;
import com.objeto.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/login")
public class LoginController {

    private final LoginService loginService;

    /**
     * validate Login and give Jwt Token for user
     * @param reqDto
     * @return jwt Token String value
     */
    @PostMapping("/findUser")
    public String findUser(@RequestBody FindUserReqDto reqDto) {
        String token = loginService.validateLogin(reqDto.convert());
        return "input this jwtToken in .http test file : " + token;
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody UpdateUserReqDto reqDto) {
        loginService.updateUser(reqDto);
        return ResponseEntity.ok("your account info updated.");
    }


    @DeleteMapping("/removeUser")
    public ResponseEntity<String> removeUser(@RequestBody RemoveUserReqDto reqDto) {
        return ResponseEntity.ok("your account info removed.");
    }

}
