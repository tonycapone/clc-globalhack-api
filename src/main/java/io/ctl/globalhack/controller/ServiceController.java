package io.ctl.globalhack.controller;

import io.ctl.globalhack.model.Service;
import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aimeemudd on 10/22/16.
 */
@RestController
@RequestMapping
public class ServiceController {

    @Autowired
    ProviderService providerService;


    @RequestMapping(value = "{shelterId}/checkin", method = RequestMethod.POST)
    public void checkIn (@RequestBody Client client, @PathVariable String shelterId) {
        System.out.println(shelterId);
        providerService.checkIn(client,shelterId);

    }

    @RequestMapping(value = "{clientId}/register", method = RequestMethod.POST)
    public void addService (@RequestBody Service service, @PathVariable String clientId) {


    }
}
