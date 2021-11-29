package com.swe.lawnwebapp.repositories;

import com.swe.lawnwebapp.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Agent repository, holds agent entities.
 */
@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {
}
