package com.example.entity;

import java.util.Date;

public class SeckillGood {
    private int id;
    private int goodId;
    private float secKillPrice;
    private int inventory;
    private Date startDate;
    private Date endDate;

    public SeckillGood() {
    }

    public SeckillGood(int id, int goodId, float secKillPrice, int inventory, Date startDate, Date endDate) {
        this.id = id;
        this.goodId = goodId;
        this.secKillPrice = secKillPrice;
        this.inventory = inventory;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public float getSecKillPrice() {
        return secKillPrice;
    }

    public void setSecKillPrice(float secKillPrice) {
        this.secKillPrice = secKillPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
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


}
