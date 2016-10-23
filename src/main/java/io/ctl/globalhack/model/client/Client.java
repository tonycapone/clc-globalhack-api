package io.ctl.globalhack.model.client;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by aimeemudd on 10/22/16.
 */
@Data
public class Client {
    @Id
    String id;
    String firstName;
    String lastName;
    String middleName;
    Gender gender;
    String race;
    String social;
    Boolean isVeteran;
    Boolean hasDisabilities;
    Boolean addictionHistory;
    Boolean hasChildren;
    Boolean isPregnant;
    Boolean employed;





}
