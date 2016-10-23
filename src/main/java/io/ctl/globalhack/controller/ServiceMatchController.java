package io.ctl.globalhack.controller;

import io.ctl.globalhack.model.Location;
import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.service.ShelterService;
import io.ctl.globalhack.repository.LocationRepository;
import io.ctl.globalhack.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by khomco on 10/22/16.
 */
@RestController
@RequestMapping("/services")
public class ServiceMatchController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public List<Location> findServiceMatch(@RequestBody Client client) {

        List<Location> locations = StreamSupport.stream(locationRepository.findAll().spliterator(), false)
                .flatMap(location -> location.getServices().stream().collect(Collectors.toMap(service -> location, service -> service)).entrySet().stream())
                .filter(locationServiceEntry -> locationServiceEntry.getValue() instanceof ShelterService)
                .filter(locationServiceEntry -> locationServiceEntry.getValue().isAvailable())
                .map(locationServiceEntry -> locationServiceEntry.getKey())



                .collect(Collectors.toList());

        return locations;
    }
}
