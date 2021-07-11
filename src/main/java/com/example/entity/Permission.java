package com.example.entity;

import java.io.Serializable;

public class Permission implements Serializable {

    private Integer id;

    private String permission;

    public Permission() {
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Permission(Integer id, String permission) {
        this.id = id;
        this.permission = permission;
    }
}
