package session2;

import org.testng.annotations.Test;

//import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class Query_Parameter {
  @Test
  public void QueryParameter()
  {
	 RestAssured.baseURI="https://reqres.in/api/users";
	 RestAssured.given().queryParam("page", "2").
	 when().get().
	 then().statusCode(200).
	 log().all();
  }
}
