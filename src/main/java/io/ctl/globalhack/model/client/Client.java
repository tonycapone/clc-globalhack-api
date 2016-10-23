package io.ctl.globalhack.model.client;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by aimeemudd on 10/22/16.
 */
@Data
public class Client {
    @Id
    String id;
    String name;
    LocalDate dob;
    Gender gender;
    String race;
    String social;
    Boolean isVeteran;
    Boolean hasDisabilities;
    Boolean addictionHistory;
    Boolean hasChildren;
    Boolean isPregnant;
    Boolean employed;
    String phoneNumber;
    List<History> history;





}
