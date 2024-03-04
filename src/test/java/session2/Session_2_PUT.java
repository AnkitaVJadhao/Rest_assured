package session2;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;

public class Session_2_PUT {
  @Test
  public void putRequest()
  {
	  
	  JSONObject data=new JSONObject();
	  //Put updated Key and value of that key
	  data.put("name", "Ankita1");
	  data.put("job","Tester1");
	  
	  RestAssured.baseURI="https://reqres.in/api/users/2";//id=2
	  RestAssured.given().header("Content-Type","Application/json").
	  contentType(ContentType.JSON).body(data.toJSONString()).
	  when().put().
	  then().statusCode(200).log().all();
  }
}
//Application/json

