package io.ctl.globalhack.model.service.constraint;

import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.service.Constraint;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static io.ctl.globalhack.model.service.constraint.OccupancyConstraint.ACCEPTS_FAMILY;

/**
 * Created by khomco on 10/23/16.
 */
@Component
public class FamilyConstraint implements Constraint {
    private List<OccupancyConstraint> acceptedConstraints =
            Arrays.asList(ACCEPTS_FAMILY);

    @Override
    public boolean accepts(Client client, OccupancyConstraint constraint) {
        if(!ACCEPTS_FAMILY.equals(constraint)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean canHandle(OccupancyConstraint occupancyConstraint) {
        return acceptedConstraints.contains(occupancyConstraint);
    }
}
