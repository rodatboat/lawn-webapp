package com.swe.lawnwebapp.models;

import com.swe.lawnwebapp.repositories.UserRepository;
import com.swe.lawnwebapp.services.UserService;
import com.swe.lawnwebapp.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EqualsAndHashCode
@AllArgsConstructor
public class PassChangeRequest {
    private String username;

    private String newPassword;
    private String confirmNewPassword;

    private String secQuestion1Answer;
    private String secQuestion2Answer;
    private String secQuestion3Answer;

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    public PassChangeRequest(String username, String newPassword, String confirmNewPassword, String secQuestion1Answer, String secQuestion2Answer, String secQuestion3Answer) {
        this.username = username;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
        this.secQuestion1Answer = secQuestion1Answer;
        this.secQuestion2Answer = secQuestion2Answer;
        this.secQuestion3Answer = secQuestion3Answer;
    }

    public void confirmPasswordChangeRequest(){
        boolean userAlreadyExists = userRepository.findByUsername(this.username).isPresent();
        if(userAlreadyExists && (this.newPassword.equals(this.confirmNewPassword))){
            User currUser = (User) userService.loadUserByUsername(this.username);
            userService.changePassword(currUser, this);
        } else {
            throw new IllegalStateException("Error changing password, input is incorrect!");
        }
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
