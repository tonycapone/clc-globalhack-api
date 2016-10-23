package io.ctl.globalhack.model.client;

import io.ctl.globalhack.model.Service;
import lombok.Data;

import java.util.Date;

/**
 * Created by aimeemudd on 10/22/16.
 */
@Data
public class History {

    String locationId;
    String service;
    Date checkIn;
    Date checkOut;
    int rating;
    String feedback;
    Service services;

}
