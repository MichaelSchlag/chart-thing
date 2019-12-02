package com.example.chartthing.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ChartItem {

    @Id
    @GeneratedValue
    private int id;

    private int x;
    private int y;
    //private Image image;
    private String path;


    public ChartItem(){

    }

    public ChartItem(int x, int y, String path, int id){
        this.x = x;
        this.y = y;
        this.path = path;
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

   // public void setId(int id) {
//        this.id = id;
//    }
}
