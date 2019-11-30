package com.example.chartthing.Controllers;

import com.example.chartthing.Models.Chart;
import com.example.chartthing.Models.ChartItem;
import com.example.chartthing.Models.Data.ChartDao;
import com.example.chartthing.Models.Data.ChartItemDao;
import com.example.chartthing.Models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "")
public class ChartController {

    @Autowired
    private ChartDao chartDao;

    @Autowired
    private ChartItemDao chartItemDao;

    @RequestMapping(value="")
//    @ResponseBody
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "Chart/index";
    }

    @RequestMapping(value = "new")
    public String newChart(Model model){
        ArrayList<ChartItem> items = new ArrayList<ChartItem>();
        ChartItem item1 = new ChartItem(5, 5, "apple.jpg", 0);
        ChartItem item2 = new ChartItem(0, 0, "banana.jpg", 1);
        ChartItem item3 = new ChartItem(10, 0, "coconut.jpg", 2);
        ChartItem item4 = new ChartItem(0, 10, "strawberry.jpg", 3);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        List<Test> tests = new ArrayList<Test>();
        tests.add(new Test("test"));
        tests.add(new Test("testing"));
        tests.add(new Test("testing!!!"));
        model.addAttribute("tests", "tests");
        model.addAttribute("items", "items");
        model.addAttribute("title", "New Chart");
        System.out.println(items);
        return "Chart/new-chart";
    }

}
