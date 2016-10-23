package io.ctl.globalhack.service;

import io.ctl.globalhack.model.Location;
import io.ctl.globalhack.model.Provider;
import io.ctl.globalhack.model.ProviderUser;
import io.ctl.globalhack.model.User;
import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.client.Gender;
import io.ctl.globalhack.model.client.History;
import io.ctl.globalhack.model.service.OccupancyConstraint;
import io.ctl.globalhack.model.service.ShelterService;
import io.ctl.globalhack.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by khomco on 10/22/16.
 */
@Service
public class PreseedDataService implements InitializingBean {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProviderUserRepository providerUserRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ClientRepository clientRepository;

    private void createUser() {
        User user = new User();
        user.setName("Dorothy");
        user.setUsername("user");
        userRepository.save(user);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        createUser();
        createProviderUser();

        createProviders();
        createClient();
    }

    private void createProviders() {
        ShelterService shelterService = new ShelterService();
        shelterService.setType("shelter");
        shelterService.setAvailableBeds(100);
        shelterService.setUsedBeds(48);
        shelterService.setConstraints(Arrays.asList(OccupancyConstraint.ACCEPTS_MEN));
        ShelterService service = serviceRepository.save(shelterService);

        Location locationData = new Location();
        locationData.setName("Normandy Location");
        locationData.setAddress("111 Normandy St.");
        locationData.setServices(Arrays.asList(service));
        Location location = locationRepository.save(locationData);

        Provider provider = new Provider();
        provider.setName("St. Patrick's Center");
        provider.setLocations(Arrays.asList(location));
        providerRepository.save(provider);
    }

    private void createProviderUser() {
        ProviderUser providerUser = new ProviderUser();
        providerUser.setName("Sam");
        providerUser.setUsername("provider");

        providerUserRepository.save(providerUser);
    }

    private void createClient(){
        Client client = new Client();
        History history = new History();
        history.setDate(new Date());
        history.setLocationId("1234");
        history.setService("Shelter");
        client.setHistory(Arrays.asList(history));
        client.setAddictionHistory(true);
        client.setEmployed(false);
        client.setName("Lindsay Lohan");
        client.setGender(Gender.FEMALE);


        clientRepository.save(client);
    }
}
