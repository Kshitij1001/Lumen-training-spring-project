package com.lumen.client_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CampController {

    @GetMapping("/camps")
    public String campPage() {
        System.out.println("camp page requested");
        return "camps";
    }
}
