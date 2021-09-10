package com.swe.lawnwebapp.models;

import lombok.*;

import javax.persistence.*;

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
    private String correct_answer;

    @ManyToOne
    @JoinColumn(name="securityquestionid", insertable=false, updatable=false)
    private SecurityQuestion security_questions;

    public Question(String question, String correct_answer, SecurityQuestion security_questions) {
        this.question = question;
        this.correct_answer = correct_answer;
        this.security_questions = security_questions;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public SecurityQuestion getSecurity_questions() {
        return security_questions;
    }

    public void setSecurity_questions(SecurityQuestion security_questions) {
        this.security_questions = security_questions;
    }
}
