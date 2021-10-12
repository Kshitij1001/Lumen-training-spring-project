package com.lumen.client_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/camps")
public class CampController {

    @GetMapping({"/", ""})
    public ModelAndView campPage() {
        ModelAndView mav = new ModelAndView("/WEB-INF/jsp/camps.jsp");
        System.out.println("camp page requested");
        return mav;
    }
}
