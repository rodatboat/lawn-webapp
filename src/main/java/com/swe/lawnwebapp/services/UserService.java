package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "User with username %s not found.";
    private final static String USER_ALREADY_EXISTS = "User with username %s already exists.";

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
    }

    public boolean registerUser(User user){
        boolean userAlreadyExists = userRepository.findByUsername(user.getUsername()).isPresent();

        if(userAlreadyExists){
            throw new IllegalStateException(String.format(USER_ALREADY_EXISTS, user.getUsername()));
        }

        try {
            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            userRepository.save(user);
            String response = String.format("User %s registered successfully!", user.getUsername());
        } catch (Exception e){
            return false;
        }

        return true;
    }

//    //Get All Users
//    public List<User> findAll(){
//        return userRepository.findAll();
//    }
//
//    //Get User By Id
//    public Optional<User> findById(int id) {
//        return userRepository.findById(id);
//    }
//
//    //Delete User
//    public void delete(int id) {
//        userRepository.deleteById(id);
//    }
//
//    //Update User
//    public void save(User user) {
//        userRepository.save(user);
//    }
}