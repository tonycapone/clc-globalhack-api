package io.ctl.globalhack.service;

import io.ctl.globalhack.model.Location;
import io.ctl.globalhack.model.Provider;
import io.ctl.globalhack.model.ProviderUser;
import io.ctl.globalhack.model.User;
import io.ctl.globalhack.model.service.OccupancyConstraint;
import io.ctl.globalhack.model.service.ShelterService;
import io.ctl.globalhack.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
}
