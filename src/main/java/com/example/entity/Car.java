package com.example.entity;

import java.io.Serializable;

public class Car implements Serializable {

    private String id;
    private String brand;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car() {
    }

    public Car(String id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
