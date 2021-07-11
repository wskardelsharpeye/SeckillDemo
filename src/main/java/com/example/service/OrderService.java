package com.example.service;

import com.example.entity.SeckillOrder;
import com.example.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    private OrderMapper orderMapper;

    public void createOrder(SeckillOrder order) {
        orderMapper.createOrder(order);
    }

}
