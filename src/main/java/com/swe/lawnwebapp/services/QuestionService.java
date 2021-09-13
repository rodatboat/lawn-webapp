package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.Question;
import com.swe.lawnwebapp.models.SecurityQuestion;
import com.swe.lawnwebapp.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    public Optional<Question> findById(int id){
        return questionRepository.findById(id);
    }
}
