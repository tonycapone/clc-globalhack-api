package io.ctl.globalhack;

import io.ctl.globalhack.model.Provider;
import io.ctl.globalhack.repository.ProviderRepository;
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
	private ProviderRepository providerRepository;

	private String shelterName = "St. Patricks";

	private static Provider provider = new Provider();

	@Before
	public void setup(){

		provider.setName(shelterName);
		provider = providerRepository.save(provider);
	}

	@Test
	public void getShelter(){

		ResponseEntity<Provider> response = restTemplate.getForEntity("/providers/" + provider.getId(), Provider.class);

		Provider shelter = new Provider();
		shelterName = "St. Patricks";
		shelter.setName(shelterName);
		assertThat(response.getBody().getName(), is(shelter.getName()) );

	}

}
