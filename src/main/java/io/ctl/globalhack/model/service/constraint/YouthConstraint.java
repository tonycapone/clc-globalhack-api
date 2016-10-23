package io.ctl.globalhack.model.service.constraint;

import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.service.Constraint;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static io.ctl.globalhack.model.service.constraint.OccupancyConstraint.REQUIRES_YOUTH;

@Component
public class YouthConstraint implements Constraint {

    private List<OccupancyConstraint> acceptedConstraints =
            Arrays.asList(REQUIRES_YOUTH);
    @Override
    public boolean accepts(Client client, OccupancyConstraint constraint) {
        if(getAge(client.getDob()) < 18){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canHandle(OccupancyConstraint occupancyConstraint) {
        return REQUIRES_YOUTH.equals(occupancyConstraint);
    }

    private int getAge(LocalDate birthday){
        LocalDate today = LocalDate.now();

        Period p = Period.between(birthday, today);
        return p.getYears();
    }
}
