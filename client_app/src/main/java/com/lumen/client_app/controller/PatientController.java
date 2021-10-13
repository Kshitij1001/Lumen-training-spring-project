package com.lumen.client_app.controller;

import com.lumen.client_app.model.BloodGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping({"/", ""})
    public String patientPage() {
        System.out.println("patients page requested");
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

    @PostMapping(value = "/bloodGroup_donors", consumes = "application/json")
    @ResponseBody
    public String bloodGroupDonors(@RequestBody BloodGroup bloodGroup) {
        System.out.println("got view blood group donors request: " + bloodGroup.getBloodGroup());

        URI donorServiceURI = discoveryClient.getInstances("donor-service").get(0).getUri();

        String donors = (new RestTemplate()).postForObject(donorServiceURI + "/donor_service/get_bloodGroup", bloodGroup, String.class);

        return donors;
    }

    @PostMapping(value = "/eligible_bloodGroup_donors", consumes = "application/json")
    @ResponseBody
    public String eligibleBloodGroupDonors(@RequestBody BloodGroup bloodGroup) {
        System.out.println("got view eligible blood group donors request: " + bloodGroup.getBloodGroup());

        URI donorServiceURI = discoveryClient.getInstances("donor-service").get(0).getUri();

        String donors = (new RestTemplate()).postForObject(donorServiceURI + "/donor_service/get_eligible_bloodGroup", bloodGroup, String.class);

        return donors;
    }

}
