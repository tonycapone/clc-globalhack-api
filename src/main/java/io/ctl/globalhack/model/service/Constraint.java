package io.ctl.globalhack.model.service;

import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.service.constraint.OccupancyConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by khomco on 10/22/16.
 */

public interface Constraint {

    boolean accepts(Client client, OccupancyConstraint constraint);
    boolean canHandle(OccupancyConstraint occupancyConstraint);

}
