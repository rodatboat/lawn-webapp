package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.SecurityQuestion;
import com.swe.lawnwebapp.repositories.SecurityQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Methods for the security question entity.
 */
@Service
public class SecurityQuestionService {

    @Autowired
    private SecurityQuestionRepository securityQuestionRepository;

    public List<SecurityQuestion> getSecurityQuestions(){
        return securityQuestionRepository.findAll();
    }

    public Optional<SecurityQuestion> findById(int id){
        return securityQuestionRepository.findById(id);
    }

    public void save(SecurityQuestion securityQuestion){
        securityQuestionRepository.save(securityQuestion);
    }

    public void delete(int id){
        securityQuestionRepository.deleteById(id);
    }
}
