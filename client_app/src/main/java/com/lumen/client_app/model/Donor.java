package com.lumen.client_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Donor {
    String firstName, lastName, bloodGroup, mail, address, password, city;
    Date lastDonated;
    boolean willing;
}
