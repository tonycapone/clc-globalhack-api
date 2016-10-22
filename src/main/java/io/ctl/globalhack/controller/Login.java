package io.ctl.globalhack.controller;

import io.ctl.globalhack.model.Credentials;
import io.ctl.globalhack.model.User;
import io.ctl.globalhack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aimeemudd on 10/22/16.
 */
@RestController()
public class Login {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(name ="/login", method= RequestMethod.POST)
    public User login (Credentials creds) {
        return userRepository.findById("user1");
    }

}
