package com.lumen.client_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @GetMapping({"/", ""})
    public ModelAndView patientPage() {
        ModelAndView mav = new ModelAndView("/WEB-INF/jsp/patients.jsp");
        System.out.println("patients page requested");
        return mav;
    }
}
