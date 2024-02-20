package phaseendproject;

import java.io.File;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class Assignment002 {
	
	
	@Test
	public void post_status_available()
	{
		File file = new File("resources/data.json");
		
		int id = RestAssured.given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.contentType(ContentType.JSON)
				.body(file)
				.when().post()
				.then().statusCode(200)
				.body("name", Matchers.equalTo("goat")).extract().path("id");
				
		System.out.println(id);
	}
	
	@Test(priority='2')
	public void put_status_available_Dev()
	{
		File file = new File("resources/data_dev.json");
		
		int id = RestAssured.given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.contentType(ContentType.JSON)
				.body(file)
				.when().put()
				.then().statusCode(200)
				.body("status", Matchers.equalTo("available_Dev")).extract().path("id");
				
		System.out.println(id);
	}
	
	@Test(priority='3')
	public void put_status_available_QA()
	{
		File file = new File("resources/data_QA.json");
		
		int id = RestAssured.given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.contentType(ContentType.JSON)
				.body(file)
				.when().put()
				.then().statusCode(200)
				.body("status", Matchers.equalTo("available_QA")).extract().path("id");
				
		System.out.println(id);
	}
	
	@Test(priority='4')
	public void put_status_available_Prod()
	{
		File file = new File("resources/data_PROD.json");
		
		int id = RestAssured.given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.contentType(ContentType.JSON)
				.body(file)
				.when().put()
				.then().statusCode(200)
				.body("status", Matchers.equalTo("available_Prod")).extract().path("id");
				
		System.out.println(id);
	}

}

