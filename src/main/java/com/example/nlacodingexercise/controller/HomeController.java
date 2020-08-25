package com.example.nlacodingexercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping({"/", "/home"})
    public String sample(Model model) {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("title", "NLA Coding Exercise");
        model.addAllAttributes(input);
        return "index";
    }
}






