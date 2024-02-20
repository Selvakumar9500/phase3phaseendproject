package phaseendproject;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class Assignment001Post {
	
	
	
	Logger logger =  LogManager.getLogger(Assignment001Post.class);
	
	@Test(priority='1')
	public void assignment001post()
	{
		logger.info(" pahse End project - Assignment001- Post Request");
		
		File file = new File("resources/data.json");
		
		int id = RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/pet")
		.contentType(ContentType.JSON)
		.body(file)
		.when().post()
		.then().statusCode(200)
		.log().all()
		.body("name", Matchers.equalTo("goat")).extract().path("id");
		
		logger.debug(" The status code is checked");
		
		System.out.println(id);
		logger.info("Id has been captured and printed.");
	}
	
	@Test(priority='2',dependsOnMethods= {"assignment001post"})
	public void assignment001Get()
	{
		String url = "https://petstore.swagger.io/v2/pet/947";
		RestAssured.given()
		.baseUri(url)
		.when().get()
		.then().statusCode(200)
		.log().all()
		.body("status", Matchers.equalTo("available"))
		.body("id", Matchers.equalTo(947));
		
	}
	
	@Test(priority='3',dependsOnMethods= {"assignment001post"})
	public void assignment001Delete()
	{
		String url = "https://petstore.swagger.io/v2/pet/947";
		RestAssured.given()
		.baseUri(url)
		.when().delete()
		.then().statusCode(200)
		.log().all()
		.body("code", Matchers.equalTo(200))
		.body("message", Matchers.equalTo("947"));
		
	}
	
	
	
}

