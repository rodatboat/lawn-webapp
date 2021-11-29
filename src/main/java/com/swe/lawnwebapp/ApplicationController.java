package com.swe.lawnwebapp;

import com.swe.lawnwebapp.models.Agent;
import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.repositories.AgentRepository;
import com.swe.lawnwebapp.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The application controller handles the login, logout, and home endpoints.
 */
@Controller
public class ApplicationController {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private AgentRepository agentRepository;

    /**
     * The home endpoint which returns the home page of the web application
     * @param model the html page being loaded, which information can get passed through.
     * @param user the user.
     * @return the view to be shown to the user.
     */
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

    /**
     * The login endpoint.
     * @return returns the login page.
     */
    @GetMapping("/login")
    public String goLogin(){
        return "register";
    }

    /**
     * The logout endpoint.
     * @return logs out the user, returns home page.
     */
    @GetMapping("/logout")
    public String goLogout(){
        return "redirect:index";
    }
}
