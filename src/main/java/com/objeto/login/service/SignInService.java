package com.objeto.login.service;

import com.objeto.common.mail.MyjavaMailSender;
import com.objeto.login.dto.LoginDto;
import com.objeto.login.entity.User;
import com.objeto.login.repository.UserRepository;
import com.objeto.security.encrypt.EncryptUtils;
import com.objeto.signup.dto.SignUpDto;
import jakarta.mail.internet.AddressException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignInService {

    private final UserRepository userRepository;

    private final MyjavaMailSender myjavaMailSender;

    @Transactional
    public User insertLoginUser(LoginDto dto) {
        return userRepository.save(dto.toEntity());
    }

    public void sendVarificationEmail(SignUpDto reqDto) throws AddressException {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("objetonoreply@gmail.com");
        message.setTo(reqDto.getEmail());
        message.setSubject("OBJETO Blog SignUp Varification Mail");
        message.setText("your varifyCode is : " + EncryptUtils.randomIdGenerator());
        myjavaMailSender.getMailSenderImpl().send(message);
    }
}
