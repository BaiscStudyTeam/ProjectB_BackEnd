package com.objeto.login.service;

import com.objeto.jwt.JwtTokenProvider;
import com.objeto.login.dto.LoginDto;
import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.dto.response.FindDuplicateNickNameResDto;
import com.objeto.login.entity.User;
import com.objeto.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public User insertLoginUser(InsertUserReqDto dto) {
        if(!validateEmailAuth(dto.getEmailAuthCode())) throw new BadCredentialsException("");
        return userRepository.save(dto.convert().toEntity());
    }

    private boolean validateEmailAuth(String emailAuthCode) {
        return true;
    }

    @Transactional
    public String validateLogin(LoginDto dto) {
        // check emali duplication
        User member = userRepository.findUserByEmail(dto.getEmail());
        if (Objects.isNull(member)) throw new BadCredentialsException("Jwt Authentication Failed : User not Exist");
        // check password is correct
        BCryptPasswordEncoder ec = new BCryptPasswordEncoder();

        if(!ec.matches(dto.getUserPassword(), member.getPassword())) {
            throw new BadCredentialsException("Jwt Authentication Failed : Password doesn't match");
        }
        // return jwtToken for login User
        return jwtTokenProvider.createToken(member.getEmail(), member.getNickname());
    }

    @Transactional
    public User updateUser(LoginDto dto) {
        return userRepository.save(dto.toSaveEntity());
    }

    public int findDuplicateEmail(LoginDto dto) {
        return userRepository.countByEmail(dto.getEmail());
    }

    public FindDuplicateNickNameResDto findDuplicateNickName(LoginDto dto) {
        int cnt =  userRepository.countByNickname(dto.getNickName());
        String nickname = "";
        if(cnt > 0) nickname = makeRandomNickname(nickname);

        return FindDuplicateNickNameResDto.builder().nickname(nickname).build();
    }

    private String makeRandomNickname(String nickname) {
        nickname += getRandomNDigitNumber(5);
        while (true) {
            if(userRepository.countByNickname(nickname) == 0) break;
            else nickname += getRandomNDigitNumber(1);
        }
        return nickname;
    }

    public String getRandomNDigitNumber(int n){
        String bound = "1";
        for (int i = 0; i < n; i++) bound += "0";
        Random random = new Random();
        int random5Digit = random.nextInt(Integer.parseInt(bound));
        return String.valueOf(random5Digit);
    }
}

