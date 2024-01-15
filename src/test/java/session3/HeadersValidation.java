package session3;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HeadersValidation {
	
  @Test
  public void validateHeader() {
	  RestAssured.baseURI="https://reqres.in/api/users/2";
	  RequestSpecification reqSpec = RestAssured.given();
	  Response res = reqSpec.get();
	  //String value = res.header("Content-Type");
	  String value = res.getHeader("Content-Type");
	  System.out.println(value);
	  Assert.assertEquals(value, "application/json; charset=utf-8","Value is not match ,TC failed");
  }
  
  @Test
  public void validateMultipleHeaders() {
	  RestAssured.baseURI="https://reqres.in/api/users/2";
	  RequestSpecification reqSpec = RestAssured.given();
	  Response res = reqSpec.get();
	  //Headers header = res.headers();
	   Headers headers = res.getHeaders();
	 // System.out.println(headers);
	  
	  for(Header ele:headers)
	  {
		  System.out.println(ele.getName()+":"+ele.getValue());
	  }
	  
	 Assert.assertEquals(headers.size(), 18,"Value is not match ,TC failed");
  }

  
  
}
