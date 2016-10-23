package io.ctl.globalhack.model.family;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by Alex on 10/22/2016.
 */

@Data
public class Family {
    @Id
    int familyId;
    String[] familyMember;

}
