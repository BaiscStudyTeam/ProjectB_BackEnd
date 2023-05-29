package com.objeto.signup.controller;

import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.service.SignInService;
import com.objeto.signup.dto.request.SendVarificationEmailReqDto;
import jakarta.mail.internet.AddressException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/signIn")
public class SignUpController {

    private final SignInService signInService;

    /**
     * insert new User's information
     * @param reqDto
     * @return http requet body OK
     */
    @PostMapping("/saveUser")
    public ResponseEntity<String> insertUser(@RequestBody InsertUserReqDto reqDto) {
        signInService.insertLoginUser(reqDto.convert());
        return ResponseEntity.ok("your account has been created. go to address \\home.html");
    }

    /**
     * insert new User's information
     * @param reqDto
     * @return http requet body OK
     */
    @PostMapping("/sendVarificationEmail")
    public ResponseEntity<String> sendVarificationEmail(@RequestBody SendVarificationEmailReqDto reqDto) throws AddressException {
        signInService.sendVarificationEmail(reqDto.toEntity());
        return ResponseEntity.ok("your account has been created. go to address \\home.html");
    }

}
