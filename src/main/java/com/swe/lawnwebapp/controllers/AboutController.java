package com.swe.lawnwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AboutController {
    @GetMapping({"/about", "/about.html"})
    public String goAbout(Model model, Principal user){

        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());

        return "about";
    }
}
