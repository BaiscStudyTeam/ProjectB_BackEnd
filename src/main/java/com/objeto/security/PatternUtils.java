package com.objeto.security;

public class PatternUtils {

    public static void PatternUtils () {

    }
    /**
     * RegExp Pattern for RFC2822 Email
     */
    public static final String emailPattern = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

    /**
     * RegExp Pattern for nickbame that 2~20 size
     * can add english, korean, number, white space
     * 2 to 20 characters in length
     */
    public static final String nickNamePattern = "\t/^[\\w\\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$/\n";

    /**
     * RegExp Pattern for standard password
     * At least 1 lowercase letter
     * At least 1 uppercase letter
     * At least 1 digit
     * At least 1 special character
     * 8 to 20 characters in length
     */
    public static final String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+-={}|;:'\\\",.<>/?]).{8,20}$";
}
