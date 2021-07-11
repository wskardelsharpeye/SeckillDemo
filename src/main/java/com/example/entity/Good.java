package com.example.entity;

import java.math.BigDecimal;

public class Good {

    private int id;
    private String name;
    private String title;
    private String img;
    private String detail;
    private float price;
    private int inventory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Good() {
    }

    public Good(int id, String name, String title, String img, String detail, float price, int inventory) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.img = img;
        this.detail = detail;
        this.price = price;
        this.inventory = inventory;
    }
}
