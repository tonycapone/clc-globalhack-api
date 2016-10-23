package io.ctl.globalhack.controller;

import io.ctl.globalhack.model.Credentials;
import io.ctl.globalhack.model.ProviderUser;
import io.ctl.globalhack.model.User;
import io.ctl.globalhack.repository.ProviderUserRepository;
import io.ctl.globalhack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aimeemudd on 10/22/16.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProviderUserRepository providerUserRepository;

    @RequestMapping(value = "/provider", method = RequestMethod.POST)
    public ProviderUser loginProvider(@RequestBody Credentials creds) {
        return providerUserRepository.findByUsername(creds.getUsername());
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User loginUser(@RequestBody Credentials creds) {
        System.out.println(creds);
        User user = userRepository.findByUsername(creds.getUsername());
        System.out.println(user);
        return user;
    }
}
