package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.models.Register;
import com.swe.lawnwebapp.security.UserRole;
import com.swe.lawnwebapp.services.QuestionService;
import com.swe.lawnwebapp.services.RegisterService;
import com.swe.lawnwebapp.services.SecurityQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

/**
 * The register controller is responsible for handling the registering process for new users.
 */
@Controller
@AllArgsConstructor
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private QuestionService questionService;

    /**
     * Returns the register form.
     * @param model the html page being loaded, which information can get passed through.
     * @param user the user.
     * @return the view to be shown to the user.
     */
    @GetMapping("/register")
    public String goRegister(Model model, Principal user){

        model.addAttribute("securityQuestions", questionService.getQuestions());
        model.addAttribute("roles", UserRole.values());
        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());

        return "blog-single";
    }

    /**
     * The register add enpoint is where the register form is submitted to.
     * @param request the forms data filled out by the user.
     * @return the view to be shown to the user.
     */
    @PostMapping(value = "/register/add")
    public String register(Register request){


        if(registerService.register(request)){
            return "redirect:/login";
        }

        // Fails to register send to home.
        return "index";
    }
}
