package com.example.service;

import com.example.controller.RestResponse;
import com.example.entity.SeckillOrder;
import com.example.vo.GoodVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeckillService {

    private GoodService goodService;

    private OrderService orderService;

    public SeckillService(GoodService goodService, OrderService orderService) {
        this.goodService = goodService;
        this.orderService = orderService;
    }

    @Transactional
    public RestResponse doSeckill(int id) {
               GoodVo goodVo = goodService.findById(id);
                if(goodVo.getInventory() > 0) {
                    SeckillOrder order = new SeckillOrder();
                    order.setGoodId(100);
                    order.setUserId(100);
                    orderService.createOrder(order);
                    goodService.reduceInventory(id);
                    return RestResponse.buildSuccess(id);
                } else {
                    return RestResponse.buildInternalErr("not enough inventory");
                }
    }
}
