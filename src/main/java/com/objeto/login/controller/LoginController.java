package com.objeto.login.controller;

import com.objeto.login.dto.request.RemoveUserReqDto;
import com.objeto.login.dto.request.UpdateUserReqDto;
import com.objeto.login.dto.response.FindUserResDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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
     * validate Login and give Jwt Token Cookie in Http Only
     * @param reqDto
     * @return jwt Token String value
     */
    @PostMapping("/findUser")
    public ResponseEntity<FindUserResDto> findUser(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid FindUserReqDto reqDto) {
        return ResponseEntity.ok(loginService.validateLogin(response, reqDto.convert()));
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody @Valid UpdateUserReqDto reqDto) {
        loginService.updateUser(reqDto);
        return ResponseEntity.ok(null);
    }


    @DeleteMapping("/removeUser")
    public ResponseEntity<String> removeUser(@RequestBody @Valid RemoveUserReqDto reqDto) {
        loginService.removeUser(reqDto);
        return ResponseEntity.ok(null);
    }

    /**
     * remove authentication cookie and process logout
     * @return sucess ok
     */
    @PostMapping("/logoutUser")
    public ResponseEntity<String> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        loginService.logoutUser(response);
        return ResponseEntity.ok(null);
    }


}
