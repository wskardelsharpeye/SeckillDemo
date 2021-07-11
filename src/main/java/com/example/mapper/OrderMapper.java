package com.example.mapper;

import com.example.entity.SeckillOrder;
import com.example.vo.GoodVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    public void createOrder(SeckillOrder order);
}