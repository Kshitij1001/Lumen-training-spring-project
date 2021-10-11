package com.lumen.client_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {

    @GetMapping("/patients")
    public String patientPage() {
        System.out.println("patients page requested");
        return "patients";
    }
}
