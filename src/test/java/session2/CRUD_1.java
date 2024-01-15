package session2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
//import static io.restassured.*;

public class CRUD_1 
{
  @Test
  public void getRequest()
  {
	  
	  RestAssured.baseURI="https://reqres.in/api/users/2";  //Property for the restAssured class
	  //baseURI="https://reqres.in/api/users/2"; :- Check line 6
	  RestAssured.given().when().get().then().statusCode(200);
	  //given().when().get().then().statusCode(200) :- check line 6
	  //BDD Style
	  //given:- 
	  //when:-
	  //then:-
	  
	  
	  
  }
}
