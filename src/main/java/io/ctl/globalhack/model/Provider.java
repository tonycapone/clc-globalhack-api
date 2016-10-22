package io.ctl.globalhack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Provider {
    
    int id;
    String name;
    String address;
}
