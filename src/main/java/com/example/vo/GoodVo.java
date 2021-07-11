package com.example.vo;

import java.io.Serializable;
import java.util.Date;

public class GoodVo implements Serializable {

    private Integer id;
    private String img;
    private String detail;
    private int inventory;
    private Double originalPrice;
    private Double seckillPrice;
    private String name;
    private Date startDate;
    private Date endDate;

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public GoodVo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public GoodVo(Integer id, String img, String detail, Double originalPrice, Double seckillPrice, String name, Date startDate, Date endDate) {
        this.id = id;
        this.img = img;
        this.detail = detail;
        this.originalPrice = originalPrice;
        this.seckillPrice = seckillPrice;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
