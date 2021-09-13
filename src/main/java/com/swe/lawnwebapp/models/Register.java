package com.swe.lawnwebapp.models;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Register {
    private String username;
    private String password;
    private String passwordConfirm;

    private int securityQuestion1;
    private int securityQuestion2;
    private int securityQuestion3;

    private String securityQuestion1Answer;
    private String securityQuestion2Answer;
    private String securityQuestion3Answer;

    public Register(String username, String password, int securityQuestion1, int securityQuestion2, int securityQuestion3, String securityQuestion1Answer, String securityQuestion2Answer, String securityQuestion3Answer) {
        this.username = username;
        this.password = password;
        this.securityQuestion1 = securityQuestion1;
        this.securityQuestion2 = securityQuestion2;
        this.securityQuestion3 = securityQuestion3;
        this.securityQuestion1Answer = securityQuestion1Answer;
        this.securityQuestion2Answer = securityQuestion2Answer;
        this.securityQuestion3Answer = securityQuestion3Answer;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public int getSecurityQuestion1() {
        return securityQuestion1;
    }

    public int getSecurityQuestion2() {
        return securityQuestion2;
    }

    public int getSecurityQuestion3() {
        return securityQuestion3;
    }

    public String getSecurityQuestion1Answer() {
        return securityQuestion1Answer;
    }

    public String getSecurityQuestion2Answer() {
        return securityQuestion2Answer;
    }

    public String getSecurityQuestion3Answer() {
        return securityQuestion3Answer;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
