package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.models.Register;
import com.swe.lawnwebapp.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(value = "register")
    public String register(@RequestBody Register request){
        if(registerService.register(request)){
            // TODO: Send to profile page.
            return "index";
        }

        // Fails to register send to home.
        return "index";
    }
}
