package com.example.service;

import com.example.mapper.GoodMapper;
import com.example.vo.GoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {

    @Autowired
    GoodMapper goodMapper;

    //@Cacheable(value = "valueTest")
    public List<GoodVo> select() {
        return goodMapper.select();
    }

    public GoodVo findById(int id) {
        return goodMapper.findById(id);
    }

    public int reduceInventory(int id) {
        //throw new RuntimeException("reduce failed");
        return goodMapper.reduceInventory(id);
    }

}
