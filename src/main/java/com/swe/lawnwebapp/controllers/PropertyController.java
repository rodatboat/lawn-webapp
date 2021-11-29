package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.services.ImageService;
import com.swe.lawnwebapp.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import io.github.cdimascio.dotenv.Dotenv;

import java.security.Principal;

/**
 * The property controller handles specifics on properties.
 */
@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ImageService imageService;

    /**
     * The properties endpoint lists all the properties in the database with some basic information
     * @param model the html page being loaded, which information can get passed through.
     * @param user the user.
     * @return the view to be shown to the user.
     */
    @GetMapping({"/properties"})
    public String goProperties(Model model, Principal user){
        model.addAttribute("properties", propertyService.getProperties());
        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());

        return "property-grid";
    }

    /**
     * The property details endpoint gets a specific property, and shows a detailed view of that property.
     * @param id
     * @param model the html page being loaded, which information can get passed through.
     * @param user the user.
     * @return the view to be shown to the user.
     */
    @GetMapping("/properties/{id}")
    public String goPropertyDetails(@PathVariable int id, Model model, Principal user){
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("mapApiKey");

        propertyService.findById(id).ifPresent(o -> {
            String url_address = o.address.replace(" ", "+");
            model.addAttribute("property", o);
            model.addAttribute("property_map_url", url_address);
            model.addAttribute("mapApiKey", apiKey);        });
            model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());

        return "property-single";
    }
}
