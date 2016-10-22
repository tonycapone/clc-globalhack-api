package io.ctl.globalhack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by khomco on 10/22/16.
 */
@Data
public class ProviderUser {
    @Id
    private String id;
    private String name;
    private String username;
    private Location location;
}
