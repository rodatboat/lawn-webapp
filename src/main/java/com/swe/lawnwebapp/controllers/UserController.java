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

/**
 * The user controller is responsible for handling the user entity.
 */
@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * The change password endpoint allows the user to change their password.
     * @param model the html page being loaded, which information can get passed through.
     * @param user the user.
     * @return the view to be shown to the user.
     */
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

    /**
     * The endpoint where the submission of the change password form is sent.
     * @param request the forms data filled out by the user.
     * @param user the user.
     * @return the view to be shown to the user.
     */
    @PostMapping(value = "/changePassword/change")
    public String changePassword(PassChangeRequest request, Principal user){

        if(user == null){
            return "redirect:/login";
        }

        userService.changePassword(((User) userService.loadUserByUsername(user.getName())), request);

        return "redirect:/logout";
    }
}
