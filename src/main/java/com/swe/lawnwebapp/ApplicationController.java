package com.swe.lawnwebapp;

import com.swe.lawnwebapp.models.Agent;
import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.repositories.AgentRepository;
import com.swe.lawnwebapp.repositories.PropertyRepository;
import com.swe.lawnwebapp.services.PropertyService;
import com.swe.lawnwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
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

    @GetMapping({"/index", "/", "/index.html", "/home"})
    public String goHome(Model model, Principal user){

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

        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());
        model.addAttribute("latestproperties", latestProperties);
        model.addAttribute("properties", randProperties);
        model.addAttribute("agents", randAgents);

        return "index";
    }

    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/logout")
    public String goLogout(){
        return "redirect:index";
    }
}
