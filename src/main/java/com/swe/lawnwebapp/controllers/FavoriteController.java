package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.models.Favorite;
import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.services.FavoriteService;
import com.swe.lawnwebapp.services.PropertyService;
import com.swe.lawnwebapp.services.UserService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * The favorites controller is responsible for everything to do with interaction with the favorite listings.
 */
@Controller
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private UserService userService;

    /**
     * Displays a user's favorites list if they are logged in and authenticated.
     * @param model the html page being loaded, which information can get passed through.
     * @param user the user.
     * @return the view to be shown to the user.
     */
    @GetMapping({"/user/watchlist"})
    public String goWatchlist(Model model, Principal user){

        if(user == null){
            return "register";
        }

        User userInfo = (User) userService.loadUserByUsername(user.getName());
        List<Pair<Favorite, Property>> favoritesList = new ArrayList<>();

        for(Favorite fav : userInfo.getFavorites()){
            propertyService.findById(fav.getProperty_id()).ifPresent((prop)-> favoritesList.add(new Pair(fav, prop)));
        }

        // public Pair(K key, V value)
        model.addAttribute("user", userInfo);
        model.addAttribute("favorites", favoritesList);
        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());


        return "blogs-grid";
    }

    /**
     * WatchlistAdd endpoint is responsible for adding a favorite listing to a user's favorite's list.
     * @param id ID of the property to be favorited.
     * @param user The user.
     * @return  The view to be shown to the user.
     */
    @GetMapping("/user/watchlistAdd")
    public String watchlistAdd(int id, Principal user){

        if(user == null){
            return "register";
        }


        User userInfo = (User) userService.loadUserByUsername(user.getName());
        favoriteService.save(new Favorite(id, userInfo));

        return "redirect:/user/watchlist";
    }

    /**
     * WatchlistDelete endpoint is responsible for removing a favorite listing to a user's favorite's list.
     * @param id ID of the property to be favorited.
     * @param user The user.
     * @return The view to be shown to the user.
     */
    @RequestMapping(value="/user/watchlistDelete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String watchlistDelete(int id, Principal user){

        if(user == null){
            return "register";
        }

        favoriteService.delete(id);

        return "redirect:/user/watchlist";
    }
}
