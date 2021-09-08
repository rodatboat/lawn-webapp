package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;
}
