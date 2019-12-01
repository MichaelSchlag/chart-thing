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
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "")
public class ChartController {

    @Autowired
    private ChartDao chartDao;

    @Autowired
    private ChartItemDao chartItemDao;

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/images";

    @RequestMapping(value="")
//    @ResponseBody
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "Chart/index";
    }

    @RequestMapping(value = "new")
    public String newChart(Model model){
        model.addAttribute("items", chartItemDao.findAll());
        model.addAttribute("title", "New Chart");
        return "Chart/new-chart";
    }

    @RequestMapping(value = "upload")
    public String upload(Model model,@RequestParam("file") MultipartFile[] files) {
        StringBuilder fileNames = new StringBuilder();
        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename()+" ");
            try {
                Files.write(fileNameAndPath, file.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ChartItem newChartItem = new ChartItem(0, 0, "" + files[0].getOriginalFilename());
        System.out.println(newChartItem);
        chartItemDao.save(newChartItem);

        model.addAttribute("items", chartItemDao.findAll());
        model.addAttribute("title", "New Chart");


        return "Chart/new-chart";
    }

}
