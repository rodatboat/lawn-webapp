package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping({"/properties", "/property-grid.html"})
    public String goProperties(Model model){
        model.addAttribute("properties", propertyService.getProperties());

        return "property-grid";
    }
}
