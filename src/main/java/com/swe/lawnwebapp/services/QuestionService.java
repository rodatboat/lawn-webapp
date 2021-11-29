package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.Question;
import com.swe.lawnwebapp.models.SecurityQuestion;
import com.swe.lawnwebapp.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Methods for the question entity.
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    /**
     * Fetches all questions in the database.
     * @return list of questions.
     */
    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    /**
     * Fetches question by id.
     * @param id question id.
     * @return question if it exists in the database.
     */
    public Optional<Question> findById(int id){
        return questionRepository.findById(id);
    }
}
