package com.swe.lawnwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * The about controller is reponsible for the about endpoint, and displays the about page.
 */
@Controller
public class AboutController {

    /**
     * Loads the about page view for the user.
     * @param model the html page being loaded, which information can get passed through.
     * @param user The user.
     * @return the view to be shown to the user.
     */
    @GetMapping({"/about", "/about.html"})
    public String goAbout(Model model, Principal user){

        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());

        return "about";
    }
}
