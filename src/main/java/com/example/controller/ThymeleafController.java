package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
        @RequestMapping("api2/tmp1")
        public String tmp1(Model model) {
            model.addAttribute("name","heeeell");
            return "hello";
        }
}
