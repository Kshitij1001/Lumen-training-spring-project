package com.lumen.donorservice.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, String> {
    List<Donor> findByCity(String city);

    List<Donor> findByBloodGroup(String bloodGroup);

    List<Donor> findByBloodGroupAndLastDonatedBeforeAndWilling(String bloodGroup, Date sixMonthsBackDate, boolean willing);

}
