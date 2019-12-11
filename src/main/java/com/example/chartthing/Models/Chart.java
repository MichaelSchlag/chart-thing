package com.example.chartthing.Models;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chart {

//    private ArrayList<ChartItem> chartItems;
    private ArrayList<Integer> chartItems;
    private String name;
    private String description;
    private String xname;
    private String yname;
    private int xmin;
    private int xmax;
    private int ymin;
    private int ymax;

    private int userId;

    @Id
    @GeneratedValue
    private int id;
//, ArrayList<Integer> chartItems
    public Chart(String name, String description, String xname, String yname, int xmin, int xmax, int ymin, int ymax) {
        this.name = name;
        this.description = description;
        this.xname = xname;
        this.yname = yname;
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
//        this.chartItems = chartItems;
    }

    public Chart() { }

    public ArrayList<Integer> getChartItems() {
        return chartItems;
    }

    public void setChartItems(ArrayList<Integer> chartItems) {
        this.chartItems = chartItems;
    }

    public void addChartItem(Integer item){
        chartItems.add(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getXname() {
        return xname;
    }

    public void setXname(String xname) {
        this.xname = xname;
    }

    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname;
    }

    public int getXmin() {
        return xmin;
    }

    public void setXmin(int xmin) {
        this.xmin = xmin;
    }

    public int getXmax() {
        return xmax;
    }

    public void setXmax(int xmax) {
        this.xmax = xmax;
    }

    public int getYmin() {
        return ymin;
    }

    public void setYmin(int ymin) {
        this.ymin = ymin;
    }

    public int getYmax() {
        return ymax;
    }

    public void setYmax(int ymax) {
        this.ymax = ymax;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
