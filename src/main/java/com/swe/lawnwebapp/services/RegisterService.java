package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.Register;
import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final String INVALID_USERNAME_INVALID = "Username %s is invalid.";
    private final String INVALID_PASSWORD_INVALID = "Password %s is invalid.";

    @Autowired
    private UserService userService;

    public boolean register(Register request) {
        boolean usernameIsValid = validateUsername(request.getUsername());
        boolean passwordIsValid = validatePassword(request.getPassword());

        if(!usernameIsValid){
            throw new IllegalStateException(String.format(INVALID_USERNAME_INVALID, request.getUsername()));
        }

        if(!passwordIsValid){
            throw new IllegalStateException(String.format(INVALID_PASSWORD_INVALID, request.getPassword()));
        }

        return userService.registerUser(
                new User(
                        request.getUsername(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }

    public boolean validateUsername(String username){
        boolean containsSpecialCharacters = false;
        boolean containsMoreThanSixChars = false;
        boolean containsNumbers = false;

        if(username.length() >= 6){
            containsMoreThanSixChars = true;
        }

        for(char c : username.toCharArray()){
            if(((int) c >= 91 && (int) c <= 96) ||
                    ((int) c >= 58 && (int) c <= 64) ||
                    ((int) c >= 33 && (int) c <= 47)){
                containsSpecialCharacters = true;
            } else if((int) c >= 48 && (int) c <= 57){
                containsNumbers = true;
            }
        }

        return containsNumbers && containsMoreThanSixChars && containsSpecialCharacters;
    }

    public boolean validatePassword(String password){
        boolean containsSpecialCharacters = false;
        boolean containsMoreThanSixChars = false;
        boolean containsNumbers = false;
        boolean containsCaps = false;

        if(password.length() >= 6){
            containsMoreThanSixChars = true;
        }

        for(char c : password.toCharArray()){
            if(((int) c >= 91 && (int) c <= 96) ||
                    ((int) c >= 58 && (int) c <= 64) ||
                    ((int) c >= 33 && (int) c <= 47)){
                containsSpecialCharacters = true;
            } else if((int) c >= 48 && (int) c <= 57){
                containsNumbers = true;
            } else if((int) c >= 65 && (int) c <= 90){
                containsCaps = true;
            }
        }

        return containsNumbers && containsMoreThanSixChars && containsSpecialCharacters && containsCaps;
    }

}
