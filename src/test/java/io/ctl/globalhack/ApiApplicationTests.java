package io.ctl.globalhack;

import io.ctl.globalhack.model.Location;
import io.ctl.globalhack.repository.LocationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiApplicationTests {


	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private LocationRepository locationRepository;

	private String shelterName = "St. Patricks";

	private static Location location = new Location();

	@Before
	public void setup(){

		location.setName(shelterName);
		location = locationRepository.save(location);
	}

	@Test
	public void getShelter(){

		ResponseEntity<Location> response = restTemplate.getForEntity("/providers/" + location.getId(), Location.class);

		Location shelter = new Location();
		shelterName = "St. Patricks";
		shelter.setName(shelterName);
		assertThat(response.getBody().getName(), is(shelter.getName()) );

	}

}
