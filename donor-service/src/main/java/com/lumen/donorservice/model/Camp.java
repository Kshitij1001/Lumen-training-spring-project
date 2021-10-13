package com.lumen.donorservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "kshitij_project_camp")
public class Camp {
    @Id
    String campId;
    String accessCode, city;
    Date scheduledOn;
    boolean hasArranged;

    @OneToMany
    Set<Donor> registeredDonors;
}
