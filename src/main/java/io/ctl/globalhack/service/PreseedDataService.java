package io.ctl.globalhack.service;

import io.ctl.globalhack.model.*;
import io.ctl.globalhack.model.service.JobTrainingService;
import io.ctl.globalhack.model.service.OccupancyConstraint;
import io.ctl.globalhack.model.service.ShelterService;
import io.ctl.globalhack.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by khomco on 10/22/16.
 */
@Component
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
    }

    private void createProviders() {
        ShelterService shelterService = new ShelterService();
        shelterService.setType("shelter");
        shelterService.setAvailableBeds(100);
        shelterService.setUsedBeds(48);
        shelterService.setConstraints(Arrays.asList(OccupancyConstraint.MEN));
        ShelterService service = serviceRepository.save(shelterService);

        ShelterService service1 = createShelterService(100, 100);
        Location location1 = createLocation(service1, "Poplar Bluff", "111 Bluff St.");

        JobTrainingService jobTrainingService = new JobTrainingService();
        Location twizzLocation = createLocation(jobTrainingService, "Twizzler Location", "Red String Ave");
        Provider provider = createProvider(location1, "Midtown Shabby");
        provider.addLocation(twizzLocation);

    }

    private Provider createProvider(Location location, String name) {
        Provider provider = new Provider();
        provider.setName(name);
        provider.addLocation(location);
        return providerRepository.save(provider);
    }

    private Location createLocation(Service service, String name, String address) {
        Location locationData = new Location();
        locationData.setName(name);
        locationData.setAddress(address);
        locationData.setServices(Arrays.asList(service));
        return locationRepository.save(locationData);
    }

    private ShelterService createShelterService(int availableBeds, int usedBeds) {
        ShelterService shelterService = new ShelterService();
        shelterService.setType("shelter");
        shelterService.setAvailableBeds(availableBeds);
        shelterService.setUsedBeds(usedBeds);
        shelterService.setConstraints(Arrays.asList(OccupancyConstraint.ACCEPTS_MEN));
        return serviceRepository.save(shelterService);
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
