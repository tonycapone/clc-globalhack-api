package io.ctl.globalhack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
public class Location {
    @Id
    private String id;
    private String name;
    private String address;
    public List<Service> services;
}

