package com.objeto.security.encrypt;

import java.util.UUID;

public class EncryptUtils {

    public static void EncryptUtils() {
    }

    public static String randomIdGenerator() {
        return UUID.randomUUID().toString().substring(0, 30);
    }

}
