package io.ctl.globalhack;

import io.ctl.globalhack.model.Shelter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiApplicationTests {


	@Autowired
	private TestRestTemplate restTemplate;
	private String shelterName;

	@Before
	public void setup(){

		Shelter shelter = new Shelter();
		shelter.setName(shelterName);
	}

	@Test
	public void getShelter(){
		int id = 1234;
		ResponseEntity<Shelter> response = restTemplate.getForEntity("/shelter/" + id, Shelter.class);

		Shelter shelter = new Shelter();
		shelterName = "St. Patricks";
		shelter.setName(shelterName);
		assertThat(response.getBody(), is(shelter));

	}

}
