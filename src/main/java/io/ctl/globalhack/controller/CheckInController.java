package io.ctl.globalhack.controller;

import io.ctl.globalhack.model.Credentials;
import io.ctl.globalhack.model.User;
import io.ctl.globalhack.model.client.Client;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aimeemudd on 10/22/16.
 */
@RestController
@RequestMapping("/checkin")
public class CheckInController {

    @RequestMapping(value = "{locationId}/checkin", method = RequestMethod.POST)
    public void checkIn (@RequestBody Client client, @PathVariable String shelterId) {
        System.out.println(shelterId);

    }
}
