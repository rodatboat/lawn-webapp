package com.swe.lawnwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping({"/index", "/", "/index.html"})
    public String goHome(){
        return "index";
    }
}
