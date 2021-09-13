package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.models.Register;
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

@Controller
@AllArgsConstructor
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/register")
    public String goRegister(Model model){

        model.addAttribute("securityQuestions", questionService.getQuestions());

        return "blog-single";
    }

    @PostMapping(value = "/register/add")
    public String register(Register request){


        if(registerService.register(request)){
            return "redirect:/login";
        }

        // Fails to register send to home.
        return "index";
    }
}
