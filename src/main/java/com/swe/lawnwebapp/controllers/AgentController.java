package com.swe.lawnwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgentController {

    @GetMapping({"/agents", "/agents-grid.html"})
    public String goAgents(){
        return "agents-grid";
    }
}
