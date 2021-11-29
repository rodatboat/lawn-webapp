package com.swe.lawnwebapp.repositories;

import com.swe.lawnwebapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Question repository, holds question entities.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
