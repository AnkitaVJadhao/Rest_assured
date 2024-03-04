package session6;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class day_1 
{
	@Test
	public void test1()
	{
		//uri:-https://reqres.in
		//2 :-
		Response resp = RestAssured.given().baseUri("https://reqres.in/api/users/2").
		when().get().
		then().statusCode(200).extract().response();
		System.out.println(resp.getBody().asPrettyString());
		Assert.assertEquals(resp.getStatusLine(),"HTTP/1.1 200 OK" );
		Assert.assertEquals(resp.getHeader("Content-Type"), "application/json; charset=utf-8");
	}
}
