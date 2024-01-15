package session1;

import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicHTTPRequest
{
	
	@Test
	public void Test01(){
		Response response = RestAssured.get("https://reqres.in/api/users/2");  
		//https://reqres.in :- Base URI
		//api/user:- Resource 
		//2 :- Path parameter
		//? :- query parameters
		System.out.println(response.asPrettyString());
		System.out.println("=========================");
		System.out.println(response.asString());
		System.out.println("======================");
		System.out.println(response.getStatusCode());
		System.out.println("=========================");
		
		
		
	}
}
