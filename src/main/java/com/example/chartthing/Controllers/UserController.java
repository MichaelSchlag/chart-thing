package com.example.chartthing.Controllers;

import com.example.chartthing.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new User());
        return "user/signup";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, @RequestParam String verify){
        if(user.getPassword().equals(verify) && !errors.hasErrors()){
            model.addAttribute("message", "Welcome, " + user.getUsername() + "!");
            return "user/index";
        } else if(!user.getPassword().equals(verify) && !errors.hasErrors()){
            model.addAttribute(user);
            model.addAttribute("message", "Passwords do not match.");
            return "user/add";
        } else {
//            model.addAttribute("username", user.getUsername());
//            model.addAttribute("email", user.getEmail());
            model.addAttribute(user);
//            model.addAttribute("message", "Passwords do not match.");
            return "user/add";
        }
    }


}