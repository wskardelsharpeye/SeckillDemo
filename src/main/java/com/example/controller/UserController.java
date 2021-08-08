package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.PageInfo;
import com.example.utils.PagePlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("user/{id}")
    public String getUser(@PathVariable int id) {
        return userService.select(id) == null ? "no result" :  userService.select(id).toString();
    }

    @PostMapping("user")
    public RestResponse saveUser(@RequestBody User user) {
        userService.save(user);
        return RestResponse.buildSuccess(user);
    }

    @PutMapping("user")
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }

    @RequestMapping("users/page")
    @ResponseBody
    public RestResponse findUsers() {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(1, 5);
        // 引入 MyBatis 分页插件
        params.put("pageInfo", pageInfo);
        List<User> users = userService.findUsers(params);
        LOGGER.info("users size: " + users.size());
        return RestResponse.buildSuccess(users);
    }
}
