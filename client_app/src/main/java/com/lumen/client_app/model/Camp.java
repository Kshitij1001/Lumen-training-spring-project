package com.lumen.client_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Camp {
    String campId, accessCode, city;
    Date scheduledOn;
    boolean hasArranged;
    Set<Donor> registeredDonors;
}
