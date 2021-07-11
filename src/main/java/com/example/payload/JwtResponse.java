package com.example.payload;

import java.util.List;

public class JwtResponse {

    private String token;
    private String username;
    private Integer id;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JwtResponse(String token, String username, Integer id) {
        this.token = token;
        this.username = username;
        this.id = id;
    }
}
