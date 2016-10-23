package io.ctl.globalhack.service;

import io.ctl.globalhack.model.*;
import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.client.Gender;
import io.ctl.globalhack.model.client.History;
import io.ctl.globalhack.model.service.JobTrainingService;
import io.ctl.globalhack.model.service.ShelterService;
import io.ctl.globalhack.model.service.constraint.OccupancyConstraint;
import io.ctl.globalhack.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private ClientRepository clientRepository;
    int c = 0;
    Integer i = 0;
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
        createProvider(20,10,Arrays.asList(OccupancyConstraint.ACCEPTS_WOMEN),"Normandy Location","111 Normandy St.","St. Patrick's Center");
        createProvider(174,54,Arrays.asList(OccupancyConstraint.ACCEPTS_WOMEN, OccupancyConstraint.ACCEPTS_FAMILY),"St. Louis Location","1000 N. 19th St.","Gateway 180");
        createProvider(18,3,Arrays.asList(OccupancyConstraint.ACCEPTS_FAMILY,OccupancyConstraint.ACCEPTS_PREGRANT),"St. Louis Location","4223 S. Compton","Our Lady's Inn");
        createProvider(20,20,Arrays.asList(OccupancyConstraint.ACCEPTS_WOMEN),"St. Louis Location","123 Normandy St.","St. Patrick's Center");
        createProvider(74,59,Arrays.asList(OccupancyConstraint.ACCEPTS_WOMEN, OccupancyConstraint.ACCEPTS_MEN),"St. Louis Location","unlisted","Salvation Army Family Haven");
        createProvider(4,2,Arrays.asList(OccupancyConstraint.ACCEPTS_MEN),"St. Louis Location","unlisted","Chestnut Health Systems");
    }

    private void createProvider(int avail, int used,List<OccupancyConstraint> constraints,String locName, String address, String providerName){
        ShelterService service =createService(avail,used,constraints);
        Location location = createLocation(service,locName,address);
        createProvider(location,providerName);
        i++;
    }





    private Location createLocation(Service service, String name, String address) {

        Location locationData = new Location();
        locationData.setName(name);
        locationData.setAddress(address);
        locationData.setServices(Arrays.asList(service));
        Location location = locationRepository.save(locationData);
        return  location;
    }
    private ShelterService createService(int avail, int used,List<OccupancyConstraint> constraints){
        ShelterService shelterService = new ShelterService();
        shelterService.setType("shelter");
        shelterService.setAvailableBeds(avail);
        shelterService.setUsedBeds(used);
        shelterService.setConstraints(constraints);
        ShelterService service = serviceRepository.save(shelterService);
        return service;

    }

    private void createProvider(Location location, String providerName){
        Provider provider = new Provider();
        provider.setName(providerName);
        provider.setLocations(Arrays.asList(location));
        providerRepository.save(provider);
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

    private void createClient(String name, Gender gender, String phone, String social, boolean bool1, boolean bool2, boolean bool3){
        Client client = new Client();
        client.setHistory(createHistory());
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
        c++;



    }

    private List<History> createHistory() {
        List<History> events = new ArrayList<>();
        History event = new History();
        event.setCheckIn(new Date());
        event.setLocationId("1234");
        event.setService("Shelter");
        events.add(event);
        History event2 = new History();
        event2.setCheckIn(new Date());
        event2.setLocationId("1234");
        event2.setService("Shelter");
        events.add(event);
        return events;
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
