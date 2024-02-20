package phaseendproject;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Assignement005 {
	
	@Test
	public void assignment005_available()
	{
		String url = "https://petstore.swagger.io/v2/pet/findByStatus";
		RestAssured.given()
		.baseUri(url)
		.queryParam("status", "available")
		.when().get()
		.then().statusCode(200)
		.log().all();
			
	}
	
	@Test
	public void assignment005_pending()
	{
		String url = "https://petstore.swagger.io/v2/pet/findByStatus";
		RestAssured.given()
		.baseUri(url)
		.queryParam("status", "pending")
		.when().get()
		.then().statusCode(200)
		.log().all();
		
	}
	
	
	@Test
	public void assignment005_sold()
	{
		String url = "https://petstore.swagger.io/v2/pet/findByStatus";
		RestAssured.given()
		.baseUri(url)
		.queryParam("status", "sold")
		.when().get()
		.then().statusCode(200)
		.log().all();
		
		
	}

	
}