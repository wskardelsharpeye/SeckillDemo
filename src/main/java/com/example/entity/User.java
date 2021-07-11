package com.example.entity;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    private Integer id;

    private String username;

    private String password;

    private Set<Role> roles;

    private Set<Permission> permissions;

    public User() {
    }

    public User(Integer id, String username, String password, Set<Role> roles, Set<Permission> permissions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
