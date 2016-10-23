package io.ctl.globalhack.controller;

import io.ctl.globalhack.model.Credentials;
import io.ctl.globalhack.model.User;
import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aimeemudd on 10/22/16.
 */
@RestController
@RequestMapping
public class CheckInController {

    @Autowired
    CheckInService checkInService;

    @RequestMapping(value = "{shelterId}/checkin", method = RequestMethod.POST)
    public void checkIn (@RequestBody Client client, @PathVariable String shelterId) {
        System.out.println(shelterId);
        checkInService.checkIn(client,shelterId);

    }
}
