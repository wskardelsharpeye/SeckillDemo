package com.example.controller;

import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/role/")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("{id}")
    public String getUser(@PathVariable int id) {
        return roleService.select(id).toString();
    }
}
