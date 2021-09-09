package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.Register;
import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final String INVALID_USERNAME_INVALID = "Username %s is invalid.";
//    private final String INVALID_PASSWORD_INVALID = "Password %s is invalid.";
    // TODO: Password validation

    @Autowired
    private UserService userService;

    public boolean register(Register request) {
        boolean usernameIsValid = validateUsername(request.getUsername());

        if(!usernameIsValid){
            throw new IllegalStateException(String.format(INVALID_USERNAME_INVALID, request.getUsername()));
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
            if((int) c >= 33 && (int) c <= 64){
                containsSpecialCharacters = true;
            } else if((int) c >= 65 && (int) c <= 122){
                containsNumbers = true;
            }
        }

        return containsNumbers && containsMoreThanSixChars && containsSpecialCharacters;
    }

}
