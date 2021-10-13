package com.lumen.campservice.controller;

import com.lumen.campservice.model.Camp;
import com.lumen.campservice.model.CampCredentials;
import com.lumen.campservice.model.CampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("camp_service")
public class CampController {

    @Autowired
    CampRepository campRepository;

    @PostMapping(value = "register", consumes = {"application/json"})
    String register(@RequestBody Camp camp) {
        System.out.println("received camp: " + camp);
        try {
            if (campRepository.existsById(camp.getCampId())) {
                System.out.println("Donor already exists");
                return "already registered";
            }
            campRepository.save(camp);
            System.out.println("camp saved to database");
            return "success";
        } catch (Exception e) {
            System.out.println("Cannot save to database!!!!");
            e.printStackTrace();
            return "failure";
        }
    }

    @PostMapping(value = "login", consumes = {"application/json"})
    ResponseEntity<Camp> login(@RequestBody CampCredentials campCred) {
        System.out.println("received credentials: " + campCred);
        Optional<Camp> opCamp = campRepository.findById(campCred.getCampId());
        if (opCamp.isPresent()) {
            if (opCamp.get().getAccessCode().equals(campCred.getAccessCode()))
                return new ResponseEntity<>(opCamp.get(), HttpStatus.ACCEPTED);
            opCamp.get().setCampId("wrong accessCode");
            return new ResponseEntity<>(opCamp.get(), HttpStatus.OK);
        }
        Camp dummy = new Camp();
        dummy.setCampId("wrong campId");
        return new ResponseEntity<>(dummy, HttpStatus.OK);
    }

}
