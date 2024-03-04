package session6;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class day_4 {
	
	@Test
	public void GetAllUser() {
		RestAssured.given().baseUri("https://reqres.in/api/users?page=1")
		.when().get()
		.then().statusCode(200)
		.body("page",Matchers.equalTo(1))
		.body("data[5].first_name",Matchers.equalTo("Tracey"))
		.body("support.url",Matchers.equalTo("https://reqres.in/#support-heading"));
	}

	}


