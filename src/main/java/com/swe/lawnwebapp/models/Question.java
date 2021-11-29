package com.swe.lawnwebapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Question entity.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;

    @OneToMany(mappedBy = "question")
    private List<SecurityQuestion> security_questions;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<SecurityQuestion> getSecurity_questions() {

        return security_questions;
    }

    public void setSecurity_questions(List<SecurityQuestion> security_questions) {
        this.security_questions = security_questions;
    }

    public void addSecurity_question(SecurityQuestion q){
        this.security_questions.add(q);
    }
}
