package io.ctl.globalhack.model.service.constraint;

import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.service.Constraint;

import java.util.Arrays;
import java.util.List;

import static io.ctl.globalhack.model.service.constraint.OccupancyConstraint.ACCEPTS_FAMILY;

/**
 * Created by khomco on 10/23/16.
 */
public class FamilyConstraint extends Constraint {
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
    protected boolean canHandle(OccupancyConstraint occupancyConstraint) {
        return acceptedConstraints.contains(occupancyConstraint);
    }
}
