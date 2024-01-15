package session3;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StatusLine_Validate {
  @Test(enabled = false)
  public void validateStatusCode() 
  {
	  RestAssured.baseURI="https://reqres.in/api/users/2";
	  RequestSpecification reqSpec = RestAssured.given();
	  Response res = reqSpec.get();
	  String stringBody = res.asPrettyString();
	  System.out.println(stringBody);
	  int code = res.getStatusCode();
	  
	  Assert.assertEquals(code, 200,"Status code is not match , TC failed");
	  //validate actual result and expected result  
  }
  @Test
  public void validateStatusLine()
  {
	  RestAssured.baseURI="https://reqres.in/api/users/2";
	  RequestSpecification reqSpec = RestAssured.given();
	  Response res = reqSpec.get();
	  String stringBody = res.asPrettyString();
	  System.out.println(stringBody);
	  String line = res.getStatusLine();
	  System.out.println(line);
	  Assert.assertEquals(line, "HTTP/1.1 200 OK","Status line is not match , TC failed");
	  
  }
  //BDD Style
  @Test
  public void validateStatusLineInBDDFormat()
  {
	  RestAssured.baseURI="https://reqres.in/api/users/2";
	  RestAssured.given().
	  when().get().
	  then().
	  statusCode(200).
	  statusLine("HTTP/1.1 200 OK").
	  log().all();
  }
  
  @Test
  public void validateErrorStatus() 
  {
	  RestAssured.baseURI="https://reqres.in/api/users/20";
	  RequestSpecification reqSpec = RestAssured.given();
	  Response res = reqSpec.get();
	  String stringBody = res.asPrettyString();
	  System.out.println(stringBody);
	  int code = res.getStatusCode();
	  
	  Assert.assertEquals(code, 404,"Status code is not match , TC failed");
	  //validate actual result and expected result  
  }
  //Negative Test case
  @Test
  public void validateErrorStatus1() 
  {
	  RestAssured.baseURI="https://reqres.in/api/users/20";
	  RequestSpecification reqSpec = RestAssured.given();
	  Response res = reqSpec.get();
	  String stringBody = res.asPrettyString();
	  System.out.println(stringBody);
	  int code = res.getStatusCode();
	  Assert.assertEquals(code, 200,"Status code is not match , TC failed");
	  //validate actual result and expected result  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
