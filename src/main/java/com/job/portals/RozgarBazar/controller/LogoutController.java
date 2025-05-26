package com.job.portals.RozgarBazar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout-success")
    public String logoutPage() {
        return "logout"; // Will look for logout.html in templates
    }
}
