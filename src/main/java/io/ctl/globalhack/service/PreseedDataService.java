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
        createClients();
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

    private void createClient(String name, Gender gender, String phone, String social, boolean bool1, boolean bool2, boolean bool3){
        Client client = new Client();
        History history = new History();
        history.setCheckIn(new Date());
        history.setLocationId("1234");
        history.setService("Shelter");
        client.setHistory(Arrays.asList(history));
        client.setAddictionHistory(true);
        client.setSocial(social);
        client.setHasChildren(bool2);
        client.setHasDisabilities(bool1);
        client.setIsPregnant(false);
        client.setIsVeteran(false);
        client.setPhoneNumber(phone);
        client.setEmployed(bool3);
        client.setName(name);
        client.setGender(gender);
        clientRepository.save(client);



    }
    private void createClients () {
        createClient("Norine Neher", Gender.FEMALE,"314-555-6666","12345641",true, true, false);
        createClient("Linnie Liming", Gender.FEMALE,"314-555-6661","12345642",true, true, true);
        createClient("Alejandra Arizmendi", Gender.FEMALE,"314-555-6662","12345643",false, true, false);
        createClient("Rossana Neher", Gender.FEMALE,"314-555-6663","12345644",true, true, false);
        createClient("Catalina Casady", Gender.FEMALE,"314-555-6664","12345645",false, true, true);
        createClient("Nadene Nestor", Gender.FEMALE,"314-555-6665","12345646",true, true, false);
        createClient("Assunta Aoki ", Gender.FEMALE,"314-555-6667","12345647",true, false, false);
        createClient("Arie Ash", Gender.MALE,"314-555-6668","12345648",false, true, false);
        createClient("Norbert Norton", Gender.MALE,"314-555-6669","12345649",true, true, false);
        createClient("Jaime Jardine", Gender.MALE,"314-555-6612","12345610",false, true, false);
        createClient("Thanh Trueblood", Gender.MALE,"314-555-6613","12345611",false, false, false);
        createClient("Dexter Desoto", Gender.MALE,"314-555-6614","12345612",false, true, false);
        createClient("Aron Akey", Gender.MALE,"314-555-6617","12345614",false, true, true);

    }
}
