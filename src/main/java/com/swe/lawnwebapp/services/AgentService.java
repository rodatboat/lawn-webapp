package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.Agent;
import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.repositories.AgentRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

/**
 * Methods for the agents entity.
 */
@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    /**
     * Returns all agents in the database.
     * @return List of agents.
     */
    public List<Agent> getAgents(){
        return agentRepository.findAll();
    }

    /**
     * Returns a specific agent, based on the id provided.
     * @param id agent id.
     * @return the agent.
     */
    public Optional<Agent> findById(int id){
        return agentRepository.findById(id);
    }
}
