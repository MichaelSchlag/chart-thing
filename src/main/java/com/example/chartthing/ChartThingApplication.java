package com.example.chartthing;

import com.example.chartthing.Controllers.ChartController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@ComponentScan({"com.example.chartthing", "controller"})
public class ChartThingApplication {

	public static void main(String[] args) {
		new File(ChartController.uploadDirectory).mkdir();
		run(ChartThingApplication.class, args);
	}

}
