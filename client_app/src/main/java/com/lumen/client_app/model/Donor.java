package com.lumen.client_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Donor {
    String firstName, lastName, bloodGroup, mail, address, password, dob;
    Date birthDate;
}
