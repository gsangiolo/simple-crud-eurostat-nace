package com.luxoftInterview.demo;

import com.luxoftInterview.demo.model.Division;
import com.luxoftInterview.demo.service.DivisionService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.Assert.fail;


@SpringBootTest
@Testcontainers
class DemoApplicationTests {

	@Autowired
	DivisionService divisionService;

	@Container
	public static GenericContainer postgreSQLContainer = new GenericContainer(
			DockerImageName.parse("postgres:14.2-alpine")
	).withExposedPorts(4321);

	@BeforeEach
	public void setup() {
		String address = postgreSQLContainer.getHost();
		Integer port = postgreSQLContainer.getFirstMappedPort();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void csvDataLoads() {
		//Test that CSV file can be read into a testContainer
		try {
			divisionService.readDivisionsFromCSV("data/NACE_REV2_20220509_163211.csv");
		} catch (Exception e) {
			fail("Could not read items from the CSV file");
		}
	}


	@Test
	public Division createDivisionObject() {
		Division division = new Division("order123", "level456", "code789",
				"parent321", "someDescription", "This Item Includes some things",
				"This item also includes some other things", "rulings654",
				"This item excludes some things", "This item references ISIC Revision 4");
		assert division != null;
		return division;
	}

	@Test
	public void addDivisionObjectToDatabase() {
		Division division = createDivisionObject();
		try {
			divisionService.insertDivisionItem(division);
		} catch (Exception e) {
			fail("Error inserting item into the database!");
		}
	}

	@Test
	public void getDivisionfromDatabase() {
		addDivisionObjectToDatabase();
		Division division = divisionService.getDivisionById("order123");
		if (division == null) {
			fail("Could not retrieve the division from the database!");
		}
		System.out.println("Division successfully retrieved");
		division = divisionService.getDivisionById("not a real id");
		if (division != null) {
			fail("Mistakenly retrieved a nonexistent division!");
		}
		System.out.println("Successfully ignored a nonexistent id");
	}

}
