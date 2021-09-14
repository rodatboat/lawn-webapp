package com.swe.lawnwebapp.models;

import com.swe.lawnwebapp.repositories.UserRepository;
import com.swe.lawnwebapp.services.UserService;
import com.swe.lawnwebapp.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EqualsAndHashCode
@ToString
public class PassChangeRequest {
    private String username;

    private String newPassword;
    private String confirmNewPassword;

    private String secQuestion1Answer;
    private String secQuestion2Answer;
    private String secQuestion3Answer;

    public PassChangeRequest(String username, String newPassword, String confirmNewPassword, String secQuestion1Answer, String secQuestion2Answer, String secQuestion3Answer) {
        this.username = username;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
        this.secQuestion1Answer = secQuestion1Answer;
        this.secQuestion2Answer = secQuestion2Answer;
        this.secQuestion3Answer = secQuestion3Answer;
    }

    public String getUsername() {
        return username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public String getSecQuestion1Answer() {
        return secQuestion1Answer;
    }

    public String getSecQuestion2Answer() {
        return secQuestion2Answer;
    }

    public String getSecQuestion3Answer() {
        return secQuestion3Answer;
    }
}
