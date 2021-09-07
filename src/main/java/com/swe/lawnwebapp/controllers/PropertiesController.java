package com.swe.lawnwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PropertiesController {

    @GetMapping({"/properties", "/property-grid.html"})
    public String goBlog(){
        return "property-grid";
    }
}
