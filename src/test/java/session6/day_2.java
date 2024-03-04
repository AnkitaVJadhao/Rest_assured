package session6;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import net.minidev.json.JSONObject;

public class day_2 
{
	@Test(enabled = false)
	public void postRequestUsingJsonObject() 
	  {
		
		JSONObject js=new JSONObject();
		js.put("Name","Ankita" );
		//Declare array
		String name[]= {"html","python","java","c++"};
		js.put("courses", name);
		RestAssured.given().baseUri("http://localhost:3000/student").
		contentType("application/json").body(js.toString()).
		when().post().
		then().statusCode(201).log().all();
		
	  }
	@Test(enabled = false)
	public void postRequestUsingHashmap()
	{
		//Hashmap:- no need of convert map into toString()
		HashMap map=new HashMap();
		map.put("Name","Chaitali");
		String name[]= {"SQL","RestAssured","Selenium","Java"};
		map.put("courses",name);
		RestAssured.given().baseUri("http://localhost:3000/student").
		contentType("application/json").body(map).
		when().post().
		then().statusCode(201).log().all();
	
	}
	@Test(enabled = false)
	public void postRequestPOJO()
	{
		postRequestUsingPOJO p1=new postRequestUsingPOJO();
		p1.setName("Karishma");
		String name1[]= {"SQL","RestAssured","Selenium"};
		p1.setCourses(name1);
		RestAssured.given().baseUri("http://localhost:3000/student").
		contentType("application/json").body(p1).
		when().post().
		then().statusCode(201).log().all();
	
	}
	@Test
	public void postRequestfile() throws IOException
	{
			//File f1=new File(".\\data.txt");
			//FileReader fr=new FileReader(f1);
			String text = FileUtils.readFileToString(new File("./data.json"), "UTF-8");
			System.out.println(text);
	}		
}
