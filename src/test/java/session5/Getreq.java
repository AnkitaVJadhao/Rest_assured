package session5;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Getreq 
{
	@Test
	public void test1()
	{
		RestAssured.given().baseUri("https://reqres.in/api/users")
		.when().get().
		then().body("data[1].first_name", Matchers.equalTo("Janet"));
	}
}
