package com.objeto.login.service;

import com.objeto.common.constants.CommonConstants;
import com.objeto.common.mail.MyjavaMailSender;
import com.objeto.login.dto.LoginDto;
import com.objeto.login.entity.User;
import com.objeto.login.repository.UserRepository;
import com.objeto.security.encrypt.EncryptUtils;
import com.objeto.signup.dto.SignUpDto;
import jakarta.mail.Session;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SignInService {

    private final UserRepository userRepository;

    private final MyjavaMailSender myjavaMailSender;

    private final StringRedisTemplate redisTemplate;

    @Transactional
    public User insertLoginUser(LoginDto dto) {
        return userRepository.save(dto.toEntity());
    }

    public void sendVarificationEmail(SignUpDto reqDto) throws AddressException {
        String code = EncryptUtils.randomIdGenerator();
        this.saveVarificationCodeToRedis(code);
        this.sendVarificaiontEmail(reqDto.getEmail(), code);
    }

    private void sendVarificaiontEmail(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("objetonoreply@gmail.com");
        message.setTo(email);
        message.setSubject("OBJETO Blog SignUp Varification Mail");
        message.setText("Click here to complete email Varification : " + CommonConstants.serverDomain + "/signUp/checkEmailCode/" + code);
        myjavaMailSender.getMailSenderImpl().send(message);
    }

    public void saveVarificationCodeToRedis(String code) {
        System.out.println("varificationCode is : " + code);
        redisTemplate.opsForValue().append(code, "true");
        redisTemplate.expire(code, 300, TimeUnit.SECONDS);
    }

    public boolean checkEmailCode(String code) {
        if(redisTemplate.hasKey(code)) return true;
        else return false;
    }
}
