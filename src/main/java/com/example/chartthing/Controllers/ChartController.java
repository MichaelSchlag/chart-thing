package com.example.chartthing.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "")
public class ChartController {

    @RequestMapping(value="")
//    @ResponseBody
    public String home() { return "Chart/index"; }

    @RequestMapping(value = "new")
    public String newChart(){
        return "Chart/new-chart";
    }

}
