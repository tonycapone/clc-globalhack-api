package io.ctl.globalhack.model.service.constraint;

import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.service.Constraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by khomco on 10/22/16.
 */
@Component("factory")
@Qualifier("factory")
public class ConstraintFactory {

    @Autowired
    List<Constraint> availableConstraints;

    public Constraint from(OccupancyConstraint occupancyConstraint) {
       return availableConstraints.stream().filter(constraint ->
               constraint.canHandle(occupancyConstraint)).
               findFirst().orElseThrow(() -> new RuntimeException("No matching handler for occupancy constraint " + occupancyConstraint));
    }
}
