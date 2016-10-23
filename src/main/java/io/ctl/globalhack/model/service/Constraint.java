package io.ctl.globalhack.model.service;

import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.service.constraint.OccupancyConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by khomco on 10/22/16.
 */
@Component
public abstract class Constraint {

    @Autowired
    List<Constraint> availableConstraints;


    public abstract boolean accepts(Client client, OccupancyConstraint constraint);

    abstract protected boolean canHandle(OccupancyConstraint occupancyConstraint);

    public Constraint from(OccupancyConstraint occupancyConstraint) {
       return availableConstraints.stream().filter(constraint ->
               constraint.canHandle(occupancyConstraint)).
               findFirst().orElseThrow(() -> new RuntimeException("No matching handler for occupancy constraint " + occupancyConstraint));
    }
}
