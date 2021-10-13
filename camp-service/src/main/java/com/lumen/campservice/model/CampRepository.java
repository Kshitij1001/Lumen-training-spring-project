package com.lumen.campservice.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CampRepository extends JpaRepository<Camp, String> {
    Set<Camp> findByCity(String city);
}
