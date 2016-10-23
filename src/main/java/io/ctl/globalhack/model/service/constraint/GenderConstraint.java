package io.ctl.globalhack.model.service.constraint;

import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.client.Gender;
import io.ctl.globalhack.model.service.Constraint;
import io.ctl.globalhack.model.service.OccupancyConstraint;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static io.ctl.globalhack.model.service.OccupancyConstraint.ACCEPTS_MEN;
import static io.ctl.globalhack.model.service.OccupancyConstraint.ACCEPTS_WOMEN;
import static io.ctl.globalhack.model.service.OccupancyConstraint.ACCEPT_MEN_AND_WOMEN;

/**
 * Created by khomco on 10/22/16.
 */
@Component
public class GenderConstraint extends Constraint {

    private List<OccupancyConstraint> acceptedConstraints =
            Arrays.asList(ACCEPTS_MEN, ACCEPTS_WOMEN, ACCEPT_MEN_AND_WOMEN);


    @Override
    public boolean accepts(Client client, OccupancyConstraint constraint) {
        if((Gender.MALE.equals(client.getGender()) && (ACCEPTS_MEN.equals(constraint) || ACCEPT_MEN_AND_WOMEN.equals(constraint))
        || (Gender.FEMALE.equals(client.getGender()) && (ACCEPTS_WOMEN.equals(constraint) || ACCEPT_MEN_AND_WOMEN.equals(constraint))))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected boolean canHandle(OccupancyConstraint occupancyConstraint) {
        return acceptedConstraints.contains(occupancyConstraint);
    }
}
