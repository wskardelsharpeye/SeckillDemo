package com.example.controller;

import com.example.auth.CustomUserDetails;
import com.example.service.GoodService;
import com.example.service.SeckillService;
import com.example.vo.GoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring5.context.webflux.SpringWebFluxContext;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private SeckillService seckillService;


    @GetMapping("/seckillgoods")
    public ModelAndView getSeckillGoods(ModelAndView mv) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<GoodVo> list = new ArrayList<GoodVo>();
        list = goodService.select();
        mv.setViewName("list");
        mv.addObject("list",list);
        return mv;
    }

    @GetMapping("/seckillgoodsdetail/{id}")
    public ModelAndView getSeckillGoodsDetail(@PathVariable("id") int id, ModelAndView mv) {
        GoodVo good = goodService.findById(id);
        mv.setViewName("detail");
        mv.addObject("good",good);
        return mv;
    }

    @GetMapping("/doSeckill/{id}")
    @ResponseBody
    public RestResponse doSeckill(@PathVariable("id") int id) {
        return seckillService.doSeckill(id);
    }

    @GetMapping(value = "/currentUser")
    @ResponseBody
    public RestResponse currentUser(Model model) {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
        return RestResponse.buildSuccess(user.getUsername());
    }

}