package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.models.PassChangeRequest;
import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.services.AgentService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

/**
 * The agent controller is responsible for handling the agent endpoint.
 */
@Controller
public class AgentController {

    @Autowired
    private AgentService agentService;

    /**
     * Returns a listing of all the agents in the database.
     * @param model the html page being loaded, which information can get passed through.
     * @param user the user.
     * @return  the view to be shown to the user.
     */
    @GetMapping({"/agents", "/agents-grid.html"})
    public String goAgents(Model model, Principal user){

        model.addAttribute("agents", agentService.getAgents());
        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());

        return "agents-grid";
    }

    /**
     * Shows a more detailed page for a specific agent, where it shows a list of their properties.
     * @param id the ID of the agent.
     * @param model the html page being loaded, which information can get passed through.
     * @param user the user.
     * @return the view to be shown to the user.
     */
    @GetMapping("/agents/{id}")
    public String goPropertyDetails(@PathVariable int id, Model model, Principal user){

        agentService.findById(id).ifPresent(o -> {
            model.addAttribute("agent", o);
        });

        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());

        return "agent-single";
    }

    /**
     * The create property add endpoint adds a property to the database.
     * @param model the html page being loaded, which information can get passed through.
     * @param user the user.
     * @return the view to be shown to the user.
     */
    @GetMapping("/agents/createProperty")
    public String goPropertyDetails(Model model, Principal user){

        if(user == null){
            return "redirect:/login";
        }

        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());

        return "add-property";
    }

    /**
     * The add property add endpoint adds a property to a specific agent.
     * @param request
     * @param model the html page being loaded, which information can get passed through.
     * @param user the user.
     * @return the view to be shown to the user.
     */
    @PostMapping(value = "/agents/addProperty")
    public String addProperty(Property request, Model model, Principal user){

        if(user == null){
            return "redirect:/login";
        }

        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());

        return "redirect:/properties";
    }
}
