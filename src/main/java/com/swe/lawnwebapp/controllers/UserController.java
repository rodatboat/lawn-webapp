package com.swe.lawnwebapp.controllers;

import com.swe.lawnwebapp.models.PassChangeRequest;
import com.swe.lawnwebapp.models.Register;
import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.security.UserRole;
import com.swe.lawnwebapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/changePassword")
    public String goChangePassword(Model model, Principal user){

        if(user == null){
            return "redirect:/login";
        }

        User userInfo = (User) userService.loadUserByUsername(user.getName());

        model.addAttribute("user", userInfo);

        model.addAttribute("roles", UserRole.values());
        model.addAttribute("userName", user == null ? "anonymousUser" : user.getName());

        return "password-change";
    }

    @PostMapping(value = "/changePassword/change")
    public String changePassword(PassChangeRequest request, Principal user){

        if(user == null){
            return "redirect:/login";
        }

        userService.changePassword(((User) userService.loadUserByUsername(user.getName())), request);

        return "redirect:/logout";
    }
}
