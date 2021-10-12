package com.lumen.client_app.controller;

import com.lumen.client_app.model.Donor;
import com.lumen.client_app.model.DonorCredentials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/donors")
public class DonorController {

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
        System.out.println(donor);
        return "donor registered";
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public String login(@ModelAttribute("donorCred") DonorCredentials donorCred) {     //TODO
        System.out.println("donor wanna login");
        System.out.println(donorCred);
        return "Logged in";
    }

}
