package io.ctl.globalhack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by aimeemudd on 10/22/16.
 */
@Data
public class User {

    String name;

    String username;

    @Id
    String id;

}
