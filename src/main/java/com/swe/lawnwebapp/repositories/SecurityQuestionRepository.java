package com.swe.lawnwebapp.repositories;

import com.swe.lawnwebapp.models.SecurityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion, Integer> {
}
