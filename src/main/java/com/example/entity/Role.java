package com.example.entity;

import java.io.Serializable;

public class Role implements Serializable {

    private Integer id;

    private String role;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role() {
    }
}
