package com.swe.lawnwebapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SecurityQuestion {
    // TODO: OneToOne Relationship for Security Qeustion & Question

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String answer;

    @ManyToOne
    @JoinColumn(name="userid", insertable=false, updatable=false)
    private User user;

    @OneToMany(mappedBy = "security_questions")
    private List<Question> question;

    public SecurityQuestion(String answer, User user, List<Question> question) {
        this.answer = answer;
        this.user = user;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
