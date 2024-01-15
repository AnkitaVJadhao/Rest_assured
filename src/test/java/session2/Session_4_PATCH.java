package session2;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Session_4_PATCH
{
  @Test
  public void patchRequest() 
  {
	  JSONObject data=new JSONObject();
	  data.put("name", "Ankita2");
	  RestAssured.baseURI="https://reqres.in/api/users/2";
	  RestAssured.given().header("Content-Type","Application/json").contentType(ContentType.JSON).
	  body(data.toJSONString()).when().patch().then().statusCode(200).log().all();
	  
  }
}
