package com.objeto.login.service;

import com.objeto.login.dto.LoginDto;
import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.dto.response.FindDuplicateNickNameResDto;
import com.objeto.login.entity.User;
import com.objeto.login.repository.UserRepository;
import com.objeto.security.encrypt.EncryptUtils;
import com.objeto.signup.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SignInService {

    private final UserRepository userRepository;

    private final StringRedisTemplate redisTemplate;

    private final JavaMailSender javaMailSender;

    @Transactional
    public User insertLoginUser(InsertUserReqDto dto) {
        // If user send email is not same as redis email authentication email, throw authentication error
        if(!dto.getEmail().equals(redisTemplate.opsForValue().get(dto.getEmailAuthCode()))) {
            throw new BadCredentialsException("email code not found");
        }
        return userRepository.save(dto.convert().toEntity());
    }

    public void sendVarificationEmail(SignUpDto reqDto) {
        String code = EncryptUtils.randomIdGenerator();
        this.saveVarificationCodeToRedis(code, reqDto.getEmail());
        this.sendVarificaiontEmail(reqDto.getEmail(), code);
    }

    private void sendVarificaiontEmail(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("objetonoreply@gmail.com");
        message.setTo(email);
        message.setSubject("OBJETO Blog SignUp Varification Mail");
        message.setText("Your varification code is : " + code);
        javaMailSender.send(message);
    }

    public void saveVarificationCodeToRedis(String email, String code) {
        System.out.println("varificationCode is : " + code);
        redisTemplate.opsForValue().append(email, code);
        redisTemplate.expire(code, 300, TimeUnit.SECONDS);
    }

    public boolean checkEmailCode(String code) {
        if(redisTemplate.hasKey(code)) return true;
        else return false;
    }


    public int findDuplicateEmail(LoginDto dto) {
        return userRepository.countByEmail(dto.getEmail());
    }

    public FindDuplicateNickNameResDto findDuplicateNickName(LoginDto dto) {
        int cnt =  userRepository.countByNickname(dto.getNickName());
        String nickname = dto.getNickName();
        if(cnt > 0) nickname = makeRandomNickname(nickname);

        return FindDuplicateNickNameResDto.builder().nickname(nickname).build();
    }

    private String makeRandomNickname(String nickname) {
        String changedNickName = nickname + getRandomNDigitNumber(7);
        while (true) {
            if(userRepository.countByNickname(changedNickName) == 0) break;
            else changedNickName = nickname + getRandomNDigitNumber(7);
        }
        return changedNickName;
    }

    public String getRandomNDigitNumber(int n){
        String bound = "1";
        for (int i = 0; i < n; i++) bound += "0";
        Random random = new Random();
        int random5Digit = random.nextInt(Integer.parseInt(bound));
        return String.valueOf(random5Digit);
    }
}
