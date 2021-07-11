package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public String getUser(@PathVariable int id) {
        return userService.select(id) == null ? "no result" :  userService.select(id).toString();
    }

    @PostMapping
    public RestResponse saveUser(@RequestBody User user) {
        userService.save(user);
        return RestResponse.buildSuccess(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }
}
