package com.example.entity;

import java.util.Date;

public class Order {
    private int id;
    private int userId;
    private int goodId;
    private String goodName;
    private String goodCount;
    private float goodPrice;
    private int orderChannel;
    private int status;
    private int deliveryAddrId;
    private int inventory;
    private Date startDate;
    private Date endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(String goodCount) {
        this.goodCount = goodCount;
    }

    public float getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(float goodPrice) {
        this.goodPrice = goodPrice;
    }

    public int getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(int orderChannel) {
        this.orderChannel = orderChannel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeliveryAddrId() {
        return deliveryAddrId;
    }

    public void setDeliveryAddrId(int deliveryAddrId) {
        this.deliveryAddrId = deliveryAddrId;
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

    public Order(int id, int userId, int goodId, String goodName, String goodCount, float goodPrice, int orderChannel, int status, int deliveryAddrId, int inventory, Date startDate, Date endDate) {
        this.id = id;
        this.userId = userId;
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodCount = goodCount;
        this.goodPrice = goodPrice;
        this.orderChannel = orderChannel;
        this.status = status;
        this.deliveryAddrId = deliveryAddrId;
        this.inventory = inventory;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Order() {
    }
}
