package com.example.chartthing.Controllers;

import com.example.chartthing.Models.Chart;
import com.example.chartthing.Models.Data.ChartDao;
import com.example.chartthing.Models.Data.UserDao;
import com.example.chartthing.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ChartDao chartDao;

    public ChartController chartController;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("title", "Sign up");
        return "user/signup";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, @RequestParam String verify){
        if(user.getPassword().equals(verify) && !errors.hasErrors()){
            model.addAttribute("title", "Welcome!");
            model.addAttribute("message", "Welcome, " + user.getUsername() + "!");
            userDao.save(user);
//            chartController.setUser(user.getUsername());
            return "user/index";
        } else if(!user.getPassword().equals(verify) && !errors.hasErrors()){
            model.addAttribute(user);
            model.addAttribute("message", "Passwords do not match.");
            return "user/signup";
        } else {
            model.addAttribute(user);
            return "user/signup";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute(new User());
        model.addAttribute("title", "Login");
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, @RequestParam Map<String,String> requestParams){
        for(User user : userDao.findAll()){
            System.out.println(requestParams.get("username"));
            if(requestParams.get("username").equals(user.getUsername())){
                if(requestParams.get("password").equals(user.getPassword())){
                    model.addAttribute("user", user.getUsername());
//                    chartController.setUser(user.getUsername());
                    return "redirect:/";
                } else {
                    model.addAttribute("passwordError", "Incorrect password");
                    model.addAttribute("title", "Login");
                    return "user/login";
                }
            }
        }
        model.addAttribute("userError", "User not found");
        model.addAttribute("title", "Login");
        return "user/login";
    }

    @RequestMapping(value = "profile/{id}", method = RequestMethod.GET)
    public String profile(@PathVariable("id") int id, Model model){
        if(userDao.findById(id).get() != null){
            User user = userDao.findById(id).get();
            ArrayList<Chart> charts = new ArrayList<>();

            for(Chart chart : chartDao.findAll()){
                if(chart.getUserId() == id){
                    charts.add(chart);
                }
            }

            model.addAttribute("charts", charts);
            model.addAttribute("message", "Welcome to " + user.getUsername() + "'s profile!");
            return "user/profile";
        }
        return "redirect:/";
    }


}