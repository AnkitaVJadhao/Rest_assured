package session5;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostReq {

	@Test
	public void test() throws IOException 
	{
		//Convert Json into string
		File file =new File("C:\\Users\\Ankita\\eclipse-workspace\\Restassured_Study\\utils\\post.txt");
		String pbody = FileUtils.readFileToString(file,"UTF-8");
		
	RestAssured.given().baseUri("https://reqres.in/api/users")
	.contentType(ContentType.JSON).body(pbody).when().post().then().statusCode(201).log().all();
	}

}
