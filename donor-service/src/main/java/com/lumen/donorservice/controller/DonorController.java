package com.lumen.donorservice.controller;

import com.lumen.donorservice.model.Donor;
import com.lumen.donorservice.model.DonorCredentials;
import com.lumen.donorservice.model.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("donor_service")
public class DonorController {

    @Autowired
    DonorRepository donorRepository;

    @PostMapping(value = "register", consumes = {"application/json"})
    String register(@RequestBody Donor donor) {
        System.out.println("received donor: " + donor);
        try {
            donorRepository.save(donor);
            System.out.println("donor saved to database");
            return "success";
        } catch (Exception e) {
            System.out.println("Cannot save to database!!!!");
            e.printStackTrace();
            return "failure";
        }
    }

    @PostMapping(value = "login", consumes = {"application/json"})
    ResponseEntity<Donor> login(@RequestBody DonorCredentials donorCred) {
        System.out.println(donorCred);
        Optional<Donor> donor = donorRepository.findById(donorCred.getEmail());
        if (donor.isPresent()) {
            if (donor.get().getPassword().equals(donorCred.getPass()))
                return new ResponseEntity<>(donor.get(), HttpStatus.ACCEPTED);
            donor.get().setMail("wrong password");
            return new ResponseEntity<>(donor.get(), HttpStatus.OK);
        }
        Donor dummy = new Donor();
        dummy.setMail("wrong mail");
        return new ResponseEntity<>(dummy, HttpStatus.OK);
    }

}
