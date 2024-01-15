package session2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Session_3_DELETE {
  @Test
  public void deleteRequest()
  {
	  RestAssured.baseURI="https://reqres.in/api/users/2";
	  RestAssured.given().when().delete().then().statusCode(204).log().all();
  }
}
