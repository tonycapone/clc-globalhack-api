package io.ctl.globalhack.controller;




import com.twilio.sdk.http.Request;
import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;
import io.ctl.globalhack.model.Credentials;
import io.ctl.globalhack.model.ProviderUser;
import io.ctl.globalhack.model.Service;
import io.ctl.globalhack.repository.ProviderUserRepository;
import io.ctl.globalhack.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by aimeemudd on 10/22/16.
 */
@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    ServiceRepository serviceRepository;

    @RequestMapping(value = "/provider", method = RequestMethod.POST)
    public String getBeds(String req) {

        String message="Unable to process your request";
        if (req.equals("shelter")) {
            message= serviceRepository.findOne("").getId();
        }

        // Create a TwiML response and add our friendly message.
       Message sms = new Message.Builder().body(new Body(message)).build();
       MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();
        return null;
    }

}
