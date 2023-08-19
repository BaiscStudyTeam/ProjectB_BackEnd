package com.objeto.signup.controller;

import com.objeto.login.dto.LoginDto;
import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.dto.response.FindDuplicateNickNameResDto;
import com.objeto.login.service.SignInService;
import com.objeto.security.PatternUtils;
import com.objeto.signup.dto.request.SendVarificationEmailReqDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/signUp")
@Validated
public class SignUpController {

    private final SignInService signInService;

    /**
     * insert new User's information
     * @param reqDto
     * @return http requet body OK
     */
    @PostMapping("/saveUser")
    public ResponseEntity<String> insertUser(@RequestBody @Valid InsertUserReqDto reqDto) {
        signInService.insertLoginUser(reqDto);
        return ResponseEntity.ok(null);
    }

    /**
     * insert new User's information, but only for testing. ( varificationEmail must be checked while signUp )
     * @param reqDto
     * @return http requet body OK
     */
    @PostMapping("/sendVarificationEmail")
    public ResponseEntity<String> sendVarificationEmail(@RequestBody @Valid SendVarificationEmailReqDto reqDto) {
        return ResponseEntity.ok(signInService.sendVarificationEmail(reqDto.toEntity()));
    }

    /**
     * find duplicate email by user input email
     * @param email
     * @return int value, if exist, it returns exist count. if it is not duplicated, return 0
     */
    @GetMapping("/findDuplicateEmail")
    public ResponseEntity<Integer> findDuplicateEmail(@NotEmpty
                                                      @Pattern(regexp = PatternUtils.emailPattern)
                                                      @RequestParam String email) {
        return ResponseEntity.ok(signInService.findDuplicateEmail(LoginDto.builder().email(email).build()));
    }

    /**
     * find duplicate nickName by user input nickName
     * @param nickname
     * @return if it is not duplcated, return success. if it is duplicated, return random 3 nickname value
     */
    @GetMapping("/findDuplicateNickName")
    public ResponseEntity<FindDuplicateNickNameResDto> findDuplicateNickName(@NotEmpty
                                                                             @Pattern(regexp = PatternUtils.nickNamePattern)
                                                                             @RequestParam String nickname) {
        return ResponseEntity.ok(signInService.findDuplicateNickName(LoginDto.builder().nickName(nickname).build()));
    }

}
