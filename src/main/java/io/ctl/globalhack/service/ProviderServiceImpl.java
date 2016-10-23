package io.ctl.globalhack.service;
import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.client.History;
import io.ctl.globalhack.model.service.ShelterService;
import io.ctl.globalhack.repository.ClientRepository;
import io.ctl.globalhack.repository.ServiceRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by aimeemudd on 10/22/16.
 */
@Service
@Log4j
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ClientRepository clientRepository;


    @Override
    public void checkIn(Client client, String id) {
        changeBedCount(id);
        if(client.getSocial()!=null) {
            client = clientRepository.findBySocial(client.getSocial());
        } else {
            client = clientRepository.findByName(client.getName());
        }
        History history = new History();
        history.setService("Shelter");
        history.setLocationId(id);
        history.setCheckIn(new Date());
        client.getHistory().add(history);
        clientRepository.save(client);



    }

    @Override
    public void registerService(String id, io.ctl.globalhack.model.Service service) {

    }

    private void changeBedCount(String id) {
        ShelterService shelter = (ShelterService) serviceRepository.findOne(id);
        int avail =  shelter.getAvailableBeds();
        int used = shelter.getUsedBeds();
        shelter.setUsedBeds(used + 1);
        shelter.setAvailableBeds(avail -1);
        serviceRepository.save(shelter);
    }
}
