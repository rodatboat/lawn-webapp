package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.services.PropertyService;
import com.swe.lawnwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
//    private User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal;

    @Autowired
    private UserService userService;

    @GetMapping({"/user/watchlist", "/user"})
    public String goUser(Model model, Principal user){

        if(user == null){
            return "login";
        }

        model.addAttribute("user", userService.loadUserByUsername(user.getName()));

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
