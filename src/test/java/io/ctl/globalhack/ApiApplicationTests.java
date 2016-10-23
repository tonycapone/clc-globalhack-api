package io.ctl.globalhack;

import io.ctl.globalhack.model.client.Client;
import io.ctl.globalhack.model.client.Gender;
import io.ctl.globalhack.model.service.Constraint;
import io.ctl.globalhack.model.service.constraint.ConstraintFactory;
import io.ctl.globalhack.model.service.constraint.OccupancyConstraint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiApplicationTests {

	@Autowired
	private ConstraintFactory factory;

	@Test
	public void testConstraint(){

		OccupancyConstraint acceptsMen = OccupancyConstraint.ACCEPTS_MEN;
		Constraint constraint = factory.from(acceptsMen);

		Client client = new Client();
		client.setGender(Gender.MALE);

		assert(constraint.accepts(client, OccupancyConstraint.ACCEPTS_MEN));

	}

	@Test
	public void testConstraintGuy(){

		OccupancyConstraint acceptsMen = OccupancyConstraint.ACCEPTS_MEN;
		Constraint constraint = factory.from(acceptsMen);

		Client client = new Client();
		client.setGender(Gender.FEMALE);

		assert(!constraint.accepts(client, OccupancyConstraint.ACCEPTS_MEN));

	}

	@Test
	public void testConstraintGuyAgain(){

		OccupancyConstraint acceptsMen = OccupancyConstraint.ACCEPTS_MEN;
		Constraint constraint = factory.from(acceptsMen);

		Client client = new Client();
		client.setGender(Gender.FEMALE);

		assert(constraint.accepts(client, OccupancyConstraint.ACCEPT_MEN_AND_WOMEN));

	}

	@Test
	public void testNonYouthAgeConstraint(){

		OccupancyConstraint youth = OccupancyConstraint.REQUIRES_YOUTH;
		Constraint constraint = factory.from(youth);

		Client client = new Client();
		client.setGender(Gender.MALE);
		client.setDob(LocalDate.of(1985, 8, 12));

		assert(!constraint.accepts(client, OccupancyConstraint.REQUIRES_YOUTH));

	}

	@Test
	public void testYouthAgeConstraint(){

		OccupancyConstraint youth = OccupancyConstraint.REQUIRES_YOUTH;
		Constraint constraint = factory.from(youth);

		Client client = new Client();
		client.setGender(Gender.MALE);
		client.setDob(LocalDate.of(2006, 8, 12));

		assert(constraint.accepts(client, OccupancyConstraint.REQUIRES_YOUTH));

	}


}
