package session2;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Session_1_POST {
  @Test
  public void postRequest() 
  {
	  //Provide test data to Post request
	  //Create object of Json 
	  //using put() and key and value
	  JSONObject data=new JSONObject();
	  //Put Key and value of that key
	  data.put("name", "Ankita");
	  data.put("job","Tester");
	  RestAssured.baseURI="https://reqres.in/api/users";
	  RestAssured.given().header("Content-Type","Application/json").
	  contentType(ContentType.JSON).body(data.toJSONString()).
	  when().post().
	  then().statusCode(201).log().all();
  }
}
