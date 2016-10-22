package io.ctl.globalhack.controller;

import io.ctl.globalhack.model.Credentials;
import io.ctl.globalhack.model.ProviderUser;
import io.ctl.globalhack.model.User;
import io.ctl.globalhack.repository.ProviderUserRepository;
import io.ctl.globalhack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aimeemudd on 10/22/16.
 */
@RestController()
public class Login {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProviderUserRepository providerUserRepository;

    @RequestMapping(name = "/provider/login", method = RequestMethod.POST)
    public ProviderUser loginProvider(Credentials creds) {
        return providerUserRepository.findByUsername(creds.getUsername());
    }

    @RequestMapping(name = "/user/login", method = RequestMethod.POST)
    public User loginUser(Credentials creds) {
        return userRepository.findByUsername(creds.getUsername());
    }
}
