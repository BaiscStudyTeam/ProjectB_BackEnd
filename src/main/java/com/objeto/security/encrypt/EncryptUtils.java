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
        // 버그픽스된 최신 BCrypt 알고리즘
        // max 수치의 로그라운드 ( 31) 로 생성시 암호화에 엄청난 시간이 걸리므로 로그라운드 수치는 기본 제공되는 default (10) 을 사용
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(
                BCryptPasswordEncoder.BCryptVersion.$2Y);
        return encoder.encode(charseq);
    }

}
