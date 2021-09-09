package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.models.Image;
import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.services.ImageService;
import com.swe.lawnwebapp.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import io.github.cdimascio.dotenv.Dotenv;

@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ImageService imageService;

    @GetMapping({"/properties", "/property-grid.html"})
    public String goProperties(Model model){
        model.addAttribute("properties", propertyService.getProperties());

        return "property-grid";
    }

    @GetMapping("/properties/{id}")
    public String goPropertyDetails(@PathVariable int id, Model model){
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("mapApiKey");

        propertyService.findById(id).ifPresent(o -> {
            String url_address = o.address.replace(" ", "+");
            model.addAttribute("property", o);
            model.addAttribute("property_map_url", url_address);
            model.addAttribute("mapApiKey", apiKey);        });

        return "property-single";
    }
}
