package com.example.cs4blogmanagement.service.validate;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class Validate {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public Validate(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    public boolean validateEmail(String email){
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
