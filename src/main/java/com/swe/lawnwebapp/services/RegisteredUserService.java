package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.RegisteredUser;
import com.swe.lawnwebapp.repositories.RegisteredUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisteredUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MESSAGE = "User with email %s not found";

    @Autowired
    private final RegisteredUserRepository registeredUserRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return registeredUserRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MESSAGE, email)));
    }

    public String signUpUser(RegisteredUser appUser){
        boolean userExists = registeredUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if(userExists){
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        registeredUserRepository.save(appUser);

        // TODO: Send confirmation token
        return "registered user";
    }
}
