package com.objeto.login.controller;

import com.objeto.login.dto.request.RemoveUserReqDto;
import com.objeto.login.dto.request.UpdateUserReqDto;
import com.objeto.login.dto.response.FindDuplicateNickNameResDto;
import lombok.extern.slf4j.Slf4j;
import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.dto.request.LoginReqDto;
import com.objeto.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @GetMapping("/findUser")
    public String findUser(LoginReqDto reqDto) {
        String token = loginService.validateLogin(reqDto.convert());
        return "input this jwtToken in .http test file : " + token;
    }

    /**
     * find duplicate email by user input email
     * @param reqDto
     * @return int value, if exist, it returns exist count. if it is not duplicated, return 0
     */
    @GetMapping("/findDuplicateEmail")
    public ResponseEntity<Integer> findDuplicateEmail(LoginReqDto reqDto) {
        return ResponseEntity.ok(loginService.findDuplicateEmail(reqDto.convert()));
    }

    /**
     * find duplicate nickName by user input nickName
     * @param reqDto
     * @return if it is not duplcated, return success. if it is duplicated, return random 3 nickname value
     */
    @GetMapping("/findDuplicateNickName")
    public ResponseEntity<FindDuplicateNickNameResDto> findDuplicateNickName(LoginReqDto reqDto) {
        return ResponseEntity.ok(loginService.findDuplicateNickName(reqDto.convert()));
    }

    /**
     * insert new User's information
     * @param reqDto
     * @return http requet body OK
     */
    @PostMapping("/saveUser")
    public ResponseEntity<String> insertUser(@RequestBody InsertUserReqDto reqDto) {
        loginService.insertLoginUser(reqDto);
        return ResponseEntity.ok("your account has been created. go to address \\home.html");
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody UpdateUserReqDto reqDto) {
        loginService.updateUser(reqDto.convert());
        return ResponseEntity.ok("your account info updated.");
    }


    @DeleteMapping("/removeUser")
    public ResponseEntity<String> removeUser(@RequestBody RemoveUserReqDto reqDto) {
        return ResponseEntity.ok("your account info removed.");
    }

    /**
     * check login user's jwt token payload info
     * @return login user's email and nickname
     */
    @PostMapping("/checkUserInfo")
    public ResponseEntity<String> checkUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok("authenticated username : " + authentication.toString());
    }
}
