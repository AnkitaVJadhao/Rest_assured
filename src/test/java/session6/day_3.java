package session6;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class day_3 
{


		@Test
		public void GetallUser() {
			RestAssured.given().baseUri("https://reqres.in/api/users?page=2")
			.when().get()
			.then().statusCode(200);
			
		}
		@Test
		public void SingleUser() {
			RestAssured.given().baseUri("https://reqres.in/api/users/2")
			.when().get()
			.then().statusCode(200);
			
		}
		@Test
		public void PostUser() {
			HashMap Data =new HashMap();
			Data.put("name","Amol");
			Data.put("job","Tester");
			RestAssured.given().baseUri("https://reqres.in/api/users").contentType("application/json")
			.body(Data)
			.when().post()
			.then().statusCode(201);
			
		}
		@Test
		public void PutUser() {
			HashMap Data =new HashMap();
			Data.put("name","Rajendra");
			Data.put("job","Tester");
			RestAssured.given().baseUri("https://reqres.in/api/users/2").contentType("application/json")
			.body(Data)
			.when().put()
			.then().statusCode(200).log().body();
			
		}
		@Test
		public void PatchUser() {
			HashMap Data =new HashMap();
			Data.put("job","Engineer");
			RestAssured.given().baseUri("https://reqres.in/api/users/2").contentType("application/json")
			.body(Data)
			.when().patch()
			.then().statusCode(200).log().body();
			
		}
		@Test
		public void DeleteUser() {
			RestAssured.given().baseUri("https://reqres.in/api/users/2")
			.when().delete()
			.then().statusCode(204).log().body();
			
		}
	}


