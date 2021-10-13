package com.lumen.client_app.controller;

import com.lumen.client_app.model.Donor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping({"/", ""})
    public String patientPage(Model model) {
        System.out.println("patients page requested");
        model.addAttribute("bloodGroup", "NA");
        model.addAttribute("campId", "NA");
        model.addAttribute("eligible", new Eligible());
        List<Donor> donors = new ArrayList<>();
        model.addAttribute("donorList", donors);

        return "view/viewDetails";
    }

    @PostMapping("/all_donors")
    @ResponseBody
    public String allDonors() {
        System.out.println("got view all donors request");

        URI donorServiceURI = discoveryClient.getInstances("donor-service").get(0).getUri();

        String donors = (new RestTemplate()).postForObject(donorServiceURI + "/donor_service/get_all", "ping", String.class);

        return donors;
    }

    @Data
    @ToString
    @AllArgsConstructor
    static class Eligible {
        String bloodGroup;

        Eligible() {
            bloodGroup = "NA";
        }
    }

}
