package com.swe.lawnwebapp.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SecurityQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String correct_answer;

    @ManyToOne
    @JoinColumn(name="userid", insertable=false, updatable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="questionid", insertable=false, updatable=false)
    private Question question;

    public SecurityQuestion(String correct_answer, User user, Question question) {
        this.correct_answer = correct_answer;
        this.user = user;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return correct_answer;
    }

    public void setAnswer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
