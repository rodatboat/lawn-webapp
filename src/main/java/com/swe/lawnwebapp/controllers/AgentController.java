package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.services.AgentService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping({"/agents", "/agents-grid.html"})
    public String goAgents(Model model){

        model.addAttribute("agents", agentService.getAgents());
        return "agents-grid";
    }

    @GetMapping("/agents/{id}")
    public String goPropertyDetails(@PathVariable int id, Model model){

        agentService.findById(id).ifPresent(o -> {
            model.addAttribute("agent", o);
        });

        return "agent-single";
    }
}
