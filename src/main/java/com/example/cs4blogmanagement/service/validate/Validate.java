package com.example.cs4blogmanagement.service.validate;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class Validate {
    private static Pattern pattern;
    private static Pattern pattern1;
    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String PHONE_REGEX = "^(03|05|07|08|09)+\\d{8}$";
    public Validate(){
        pattern = Pattern.compile(EMAIL_REGEX);
        pattern1 = Pattern.compile(PHONE_REGEX);
    }
    public boolean validateEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePhoneNumber(String phoneNumber){
        Matcher matcher = pattern1.matcher(phoneNumber);
        return matcher.matches();
    }
}
