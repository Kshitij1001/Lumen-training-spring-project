package com.lumen.client_app.controller;

import com.lumen.client_app.model.Camp;
import com.lumen.client_app.model.CampCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Controller
@RequestMapping("/camps")
public class CampController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping({"/", ""})
    public String campPage(Model model) {
        System.out.println("camp page requested");
        model.addAttribute("camp", new Camp());
        model.addAttribute("campCred", new CampCredentials());
        return "camps/regOrLogin";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute("camp") Camp camp, Model model) {

        System.out.println("got camp registration request");

        System.out.println(camp);

        URI campServiceURI = discoveryClient.getInstances("camp-service").get(0).getUri();

        String response = (new RestTemplate()).postForObject(campServiceURI + "/camp_service/register", camp, String.class);

        System.out.println("response: " + response);

        model.addAttribute("responseCamp", camp);
        model.addAttribute("status", response);

        return "camps/campError";       //Mostly not a serious error situation
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute CampCredentials campCred, Model model) {     //TODO
        System.out.println("camp wanna login");
        System.out.println(campCred);

        URI campServiceURI = discoveryClient.getInstances("camp-service").get(0).getUri();

        Camp campResponse = (new RestTemplate()).postForObject(campServiceURI + "/camp_service/login", campCred, Camp.class);
        System.out.println("response: " + campResponse);

        model.addAttribute("responseCamp", campResponse);

        assert campResponse != null;
        if (campResponse.getCampId().startsWith("wrong "))
            return "camps/campError";
        return "camps/campView";
    }

}
