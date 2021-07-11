package com.example.controller;

import com.example.entity.Car;
import com.example.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.text.ParseException;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @GetMapping("/foo")
    public String getFoo() throws ParseException {
        return (String) strRedisTemplate.opsForValue().get("foo");
    }
}
