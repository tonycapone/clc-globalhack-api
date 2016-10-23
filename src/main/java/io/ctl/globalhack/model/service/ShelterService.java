package io.ctl.globalhack.model.service;

import io.ctl.globalhack.model.Service;
import lombok.Data;

import java.util.List;

/**
 * Created by khomco on 10/22/16.
 */
@Data
public class ShelterService extends Service {
    private String type = "shelter";
    private int availableBeds;
    private int usedBeds;
    private List<OccupancyConstraint> constraints;
}
