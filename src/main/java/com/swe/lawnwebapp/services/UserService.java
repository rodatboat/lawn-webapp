package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.PassChangeRequest;
import com.swe.lawnwebapp.models.SecurityQuestion;
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

    public boolean changePassword(User user, PassChangeRequest request){
        try{
            if(request.getNewPassword().equals(request.getConfirmNewPassword())){

            } else {
                throw new IllegalStateException("Error changing password, input is incorrect!");
            }

            boolean question1Correct = false;
            boolean question2Correct = false;
            boolean question3Correct = false;

            for(SecurityQuestion q : user.getSecurityQuestions()) {
                if (q.getAnswer().equals(request.getSecQuestion1Answer())){
                    question1Correct = true;
                } else if (q.getAnswer().equals(request.getSecQuestion2Answer())){
                    question2Correct = true;
                } else if (q.getAnswer().equals(request.getSecQuestion3Answer())){
                    question3Correct = true;
                } else {
                    throw new IllegalStateException("Change password failed, incorrect answer to security questions.");
                }
            }

            if(question1Correct && question2Correct && question3Correct){
                String encodedPassword = bCryptPasswordEncoder.encode(request.getNewPassword());
                user.setPassword(encodedPassword);

                userRepository.save(user);
            }

        } catch (Exception e){
            return false;
        }
        return true;
    }

    //Get All Users
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //Get User By Id
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    //Delete User
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    //Update User
    public void save(User user) {
        userRepository.save(user);
    }
}