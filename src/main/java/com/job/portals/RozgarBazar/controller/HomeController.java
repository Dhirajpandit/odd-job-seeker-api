package com.job.portals.RozgarBazar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {
    @GetMapping("/desc")
    public String description(){
        return "Portal For Daily Weighs Workers";
    }
}
