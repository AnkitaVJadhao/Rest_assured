package session4;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameters_Study {
  @Test
  public void f() 
  {
	  
	  RequestSpecification reqspec = RestAssured.given();
	  reqspec.baseUri("https://reqres.in/");
	  reqspec.basePath("api/users");   //Base URI +Base URI =URL
	  //
	  reqspec.queryParam("page", 1).queryParam("id", 2);
	  Response res = reqspec.get();
	  System.out.println(res.body().asPrettyString());
	  
  }
}
