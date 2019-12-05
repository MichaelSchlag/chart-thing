package com.example.chartthing.Controllers;

import com.example.chartthing.Models.Chart;
import com.example.chartthing.Models.ChartItem;
import com.example.chartthing.Models.Data.ChartDao;
import com.example.chartthing.Models.Data.ChartItemDao;
import com.example.chartthing.Models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
@ControllerAdvice
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

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newChart(Model model){
        model.addAttribute("items", chartItemDao.findAll());
        model.addAttribute("title", "New Chart");
        return "Chart/new-chart";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String postNewChart(Model model, Errors errors, @ModelAttribute @Valid Chart newChart){

        if(errors.hasErrors()){
            model.addAttribute("items", chartItemDao.findAll());
            model.addAttribute("title", "New Chart");
            return "Chart/new-chart";
        }

        return "test-success";
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

//        secretDecoder(secret);

        model.addAttribute("items", chartItemDao.findAll());
        model.addAttribute("title", "New Chart");


        return "Chart/new-chart";
    }
//, method = RequestMethod.POST
    @RequestMapping(value = "delete")
    public String delete(Model model, @RequestParam("secretStringDel") String secretString, @RequestParam("del_id") String del_id_string){

        Integer del_id = Integer.parseInt(del_id_string);
        System.out.println(del_id);

        chartItemDao.deleteById(del_id);

        secretDecoder(secretString);

        model.addAttribute("items", chartItemDao.findAll());
        model.addAttribute("title", "New Chart");

        return "redirect:/new";
    }

    public void secretDecoder(String secret){
        System.out.println(secret);
        char[] letter = secret.toCharArray();
        int c = 0;
        while(c < secret.length()) {
            String c_id = "";
            String c_x = "";
            String c_y = "";
            while (letter[c] != ',') {
                c_id += letter[c];
                c++;
            }
            int id = Integer.parseInt(c_id);
            c++;
            while (letter[c] != ',') {
                c_x += letter[c];
                c++;
            }
            int x = Integer.parseInt(c_x);
            c++;
            while (letter[c] != '!') {
                c_y += letter[c];
                c++;
            }
            int y = Integer.parseInt(c_y);
            c++;
            if (chartItemDao.existsById(id)) {
                ChartItem temp_item = chartItemDao.findById(id).get();
                System.out.println(temp_item);
                temp_item.setX(x);
                temp_item.setY(y);
                chartItemDao.save(temp_item);
            }
        }
    }

}
