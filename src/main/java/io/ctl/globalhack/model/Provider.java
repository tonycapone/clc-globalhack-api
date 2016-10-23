package io.ctl.globalhack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khomco on 10/22/16.
 */
@Data
public class Provider {
    @Id
    private String id;
    private String name;

    @DBRef
    private List<Location> locations = new ArrayList<>();


    public void addLocation(Location location) {
        locations.add(location);
    }
}
