package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.models.Favorite;
import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.services.FavoriteService;
import com.swe.lawnwebapp.services.PropertyService;
import com.swe.lawnwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FavoriteController {
//    private User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private UserService userService;

    @GetMapping({"/user/watchlist", "/user"})
    public String goUser(Model model, Principal user){

        if(user == null){
            return "login";
        }

        User userInfo = (User) userService.loadUserByUsername(user.getName());
        List<Property> favoritesList = new ArrayList<Property>();

        for(Favorite fav : userInfo.getFavorites()){
            propertyService.findById(fav.getProperty_id()).ifPresent((o)-> favoritesList.add(o));
        }

        model.addAttribute("user", userInfo);
        model.addAttribute("favorites", favoritesList);


        return "blogs-grid";
    }
//
//    // th:href="@{/countries/findById/(id=${country.id})}"
//    @PostMapping("/user/watchlistAdd")
//    public String watchlistAdd(int id){
//        loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if(loggedInUser == null){
//            return "/login";
//        }
//
//        List<Property> watchlist = loggedInUser.getWatchlist();
//
//        try{
//            propertyService.findById(id).ifPresent((o) -> watchlist.add(o));
//            loggedInUser.setWatchlist(watchlist);
//            userService.save(loggedInUser);
//
//        } catch (Exception e){
//            throw new IllegalStateException("");
//        }
//
//        return "redirect:/user/watchlist";
//    }
//
//    @RequestMapping(value="/user/watchlistDelete", method = {RequestMethod.DELETE, RequestMethod.GET})
//    public String watchlistDelete(int id){
//        loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if(loggedInUser == null){
//            return "/login";
//        }
////        countryService.delete(id);
////        return "redirect:/countries";
//        return "redirect:/user/watchlist";
//    }
}
