package com.lumen.client_app.controller;

import com.lumen.client_app.model.Donor;
import com.lumen.client_app.model.DonorCredentials;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/donors", method = RequestMethod.GET)
public class DonorController {

    Map<String, Object> model = new HashMap<>();

    @GetMapping({"/", ""})
    public ModelAndView registerOrLogin() {
        model.put("donor", new Donor());
        model.put("donorCred", new DonorCredentials());
        System.out.println("donors page requested");
        return new ModelAndView("/WEB-INF/jsp/donors.jsp", model);
    }

    @PostMapping(value = "/register")
    public String registerDonor(@Validated @ModelAttribute("Donor") Donor donor) {
        try {
            donor.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(donor.getDob()));
        } catch (ParseException e) {
            System.out.println("Wrong date format");
        }
        System.out.println(donor);
        return "donor registered";
    }


    @PostMapping(value = "/login")
    public String loginDonor(@Validated @ModelAttribute("DonorCredentials") DonorCredentials donorCred) {
        System.out.println(donorCred);
        return "user logged in";
    }
}
