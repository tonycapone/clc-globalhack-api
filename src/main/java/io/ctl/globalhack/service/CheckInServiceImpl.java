package io.ctl.globalhack.service;

import io.ctl.globalhack.model.Location;
import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.client.History;
import io.ctl.globalhack.model.service.ShelterService;
import io.ctl.globalhack.repository.ClientRepository;
import io.ctl.globalhack.repository.LocationRepository;
import io.ctl.globalhack.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by aimeemudd on 10/22/16.
 */
@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ClientRepository clientRepository;


    @Override
    public void checkIn(Client client, String id) {
        ShelterService shelter = (ShelterService) serviceRepository.findOne(id);
        int avail =  shelter.getAvailableBeds();
        int used = shelter.getUsedBeds();
        shelter.setUsedBeds(used + 1);
        shelter.setAvailableBeds(avail -1);
        serviceRepository.save(shelter);

        History history = new History();
        history.setActivity("Sleep");
        history.setLocationId(id);
        history.setDate(new Date());

        client.getHistory().add(history);
        clientRepository.save(client);



    }
}
