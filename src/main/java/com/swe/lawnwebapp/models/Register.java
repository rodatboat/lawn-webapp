package com.swe.lawnwebapp.models;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Register {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
