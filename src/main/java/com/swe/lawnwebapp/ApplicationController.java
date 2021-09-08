package com.swe.lawnwebapp;

import com.swe.lawnwebapp.models.Agent;
import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.repositories.AgentRepository;
import com.swe.lawnwebapp.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
public class ApplicationController {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private AgentRepository agentRepository;

    @GetMapping({"/index", "/", "/index.html"})
    public String goHome(Model model){

        Random rand = new Random();

        List<Property> properties = propertyRepository.findAll();
        List<Agent> agents = agentRepository.findAll();

        List<Property> randProperties = new ArrayList<Property>();
        List<Property> latestProperties = new ArrayList<Property>();
        List<Agent> randAgents = new ArrayList<Agent>();

        for(int i = 0; i < 4; i++){
            Property randomProperty = properties.get(rand.nextInt(properties.size()));
            randProperties.add(randomProperty);

            if(i < 3){
                Agent randomAgent = agents.get(rand.nextInt(agents.size()));
                randAgents.add(randomAgent);
            }
        }

        for(int i = 1; i < 5; i++){
            int size = properties.size();
            size = size - i;
            Property recentProperty = properties.get(size);
            latestProperties.add(recentProperty);
        }

        model.addAttribute("latestproperties", latestProperties);
        model.addAttribute("properties", randProperties);
        model.addAttribute("agents", randAgents);

        return "index";
    }
}
