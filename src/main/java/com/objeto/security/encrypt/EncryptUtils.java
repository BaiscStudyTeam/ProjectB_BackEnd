package com.objeto.security.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

public class EncryptUtils {

    public static void EncryptUtils() {
    }

    public static String randomIdGenerator() {
        return UUID.randomUUID().toString().substring(0, 30);
    }

    /**
     * Single Use of spring security PasswordEncoder
     * @param charseq password to encode
     * @return password encoded
     */
    public static String executeBCryptPasswordEncoder(String charseq) {
        // 버그픽스된 최신 BCrypt 알고리즘과 max 수치의  로그라운드 횟수로 Encoder 생성
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(
                BCryptPasswordEncoder.BCryptVersion.$2Y);
        return encoder.encode(charseq);
    }

}
