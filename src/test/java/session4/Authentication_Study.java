package session4;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authentication_Study {
  @Test
  public void basicAuth() 
  {
	  RequestSpecification reqspec = RestAssured.given();
	  reqspec.baseUri("https://httpbin.org/");
	  reqspec.basePath("basic-auth/ankita123/123");
	  Response res = reqspec.auth().basic("ankita123", "123").get();
	  System.out.println(res.getStatusCode());
	  Assert.assertEquals(res.getStatusCode(), 200,"You are not Authenticated User");
	  
  }
  
  @Test
  public void digestAuth()
  {
	  RequestSpecification reqspec = RestAssured.given();
	  reqspec.baseUri("https://httpbin.org/");
	  reqspec.basePath("digest-auth/undefined/ankita123/123");
	  Response res = reqspec.auth().digest("ankita123", "123").get();
	  System.out.println(res.getStatusCode());
	  Assert.assertEquals(res.getStatusCode(), 200,"You are not Authenticated User");
	  
	  
  }
  @Test
  public void basicAuth1() 
  {
	  RequestSpecification reqspec = RestAssured.given();
	  reqspec.baseUri("https://postman-echo.com");
	  reqspec.basePath("/basic-auth");
	  Response res = reqspec.auth().basic("postman", "password").get();
	  System.out.println(res.getStatusCode());
	  Assert.assertEquals(res.getStatusCode(), 200,"You are not Authenticated User");
	  
  }
  @Test
  public void token() 
  {
	  RequestSpecification reqspec = RestAssured.given();
	  reqspec.baseUri("https://httpbin.org");
	  reqspec.basePath("/bearer");
	  
//	  JSONObject data=new JSONObject();
//	  data.put("name","NewUser");
//	  data.put("gender", "female");
//	  data.put("email", "anki1234@gmail.com");
//	  data.put("status", true);
	  String authtoken="Bearer 123456789";
	  
	 //reqspec.header("Authorization",authtoken).contentType(ContentType.JSON).body(data.toJSONString());
	 
	 
	 reqspec.header("Authorization",authtoken).contentType(ContentType.JSON);
	 Response res = reqspec.get();
	 System.out.println(res.statusCode());
	 res.prettyPrint();
  }
  
  //API token :- 
  
}
