package io.ctl.globalhack.model.service.constraint;

import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.client.Gender;
import io.ctl.globalhack.model.service.Constraint;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static io.ctl.globalhack.model.service.constraint.OccupancyConstraint.*;

/**
 * Created by khomco on 10/23/16.
 */
@Component
public class PregnancyConstraint implements Constraint {
    private List<OccupancyConstraint> acceptedConstraints =
            Arrays.asList(REQUIRES_PREGNANCY_OR_FAMILY);

    @Override
    public boolean accepts(Client client, OccupancyConstraint constraint) {
        if ((Gender.FEMALE.equals(client.getGender()) && client.getHasChildren() || client.getIsPregnant() && REQUIRES_PREGNANCY_OR_FAMILY.equals(constraint))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canHandle(OccupancyConstraint occupancyConstraint) {
        return acceptedConstraints.contains(occupancyConstraint);
    }
}
