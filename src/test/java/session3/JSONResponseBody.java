package session3;

import javax.xml.crypto.Data;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JSONResponseBody {
  @Test
  public void validateResponse() {
	  RestAssured.baseURI="https://reqres.in/api/users?page=2";
	  RequestSpecification reqSpec=RestAssured.given();
	  Response res = reqSpec.get();
	  ResponseBody resBody = res.getBody();
	  
	  String resBodyString = resBody.asPrettyString();
	  resBodyString.contains("George");
	  Assert.assertTrue(resBodyString.contains("George"));
	  System.out.println(resBodyString);
	  
	  
	 //Covert string into JSON as we can not travels from string ,validation 
	  JsonPath jsonViewpath = resBody.jsonPath();
	  Object dataLastName = jsonViewpath.get("data[4].last_name");
	  Object totalUsers = jsonViewpath.get("total");
	  System.out.println(totalUsers);
	  System.out.println(dataLastName);
	  Assert.assertEquals(dataLastName, "Morris","LastName is not match ,TC failed");
	  Assert.assertEquals(totalUsers, 12,"Users is not match ,TC failed");
	  
	  
  }
}
