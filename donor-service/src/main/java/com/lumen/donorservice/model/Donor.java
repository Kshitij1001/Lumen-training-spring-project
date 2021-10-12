package com.lumen.donorservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "kshitij_project_donors")
public class Donor implements Serializable {

    @Id
    @Column(name = "mail")
    String mail;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "blood_group")
    String bloodGroup;

    @Column(name = "address")
    String address;

    @Column(name = "password")
    String password;

    @Column(name = "city")
    String city;

    @Column(name = "last_Donated")
    Date lastDonated;

    boolean willing;
}
