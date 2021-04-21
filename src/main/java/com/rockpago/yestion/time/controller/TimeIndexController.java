package com.rockpago.yestion.time.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeIndexController {

    @GetMapping("/timehome")
    public String inputHome() {
        return "/index";
    }


}
