package com.lumen.client_app.controller;

import com.lumen.client_app.model.Donor;
import com.lumen.client_app.model.DonorCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Controller
@RequestMapping(value = "/donors")
public class DonorController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping({"/", ""})
    public String registerOrLogin(Model model) {
        System.out.println("donor registration/login page requested");
        model.addAttribute("donor", new Donor());
        model.addAttribute("donorCred", new DonorCredentials());
        return "donors";
    }

    @ResponseBody
    @PostMapping(value = "/register")
    public String register(@ModelAttribute("donor") Donor donor) {

        System.out.println("got donor registration request");
        donor.setWilling(true);                   //Willing to donate by default
        System.out.println(donor);

        URI donorServiceURI = discoveryClient.getInstances("donor-service").get(0).getUri();

        String response = (new RestTemplate()).postForObject(donorServiceURI + "/donor_service/register", donor, String.class);

        System.out.println("response: " + response);
        return response;
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute DonorCredentials donorCred, Model model) {     //TODO
        System.out.println("donor wanna login");
        System.out.println(donorCred);

        URI donorServiceURI = discoveryClient.getInstances("donor-service").get(0).getUri();

        Donor donorResponse = (new RestTemplate()).postForObject(donorServiceURI + "/donor_service/login", donorCred, Donor.class);
        System.out.println("response: " + donorResponse);

        model.addAttribute("responseDonor", donorResponse);

        assert donorResponse != null;
        if (donorResponse.getMail().startsWith("wrong "))
            return "donorError";
        return "donorView";
    }

}
