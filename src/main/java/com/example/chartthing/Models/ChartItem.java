package com.example.chartthing.Models;

public class ChartItem {

    private int x;
    private int y;
    //private Image image;
    private String path;

    public ChartItem(){

    }

    public ChartItem(int x, int y, String path){
        this.x = x;
        this.y = y;
        this.path = path;
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
}
