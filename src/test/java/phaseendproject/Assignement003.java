package phaseendproject;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class Assignement003 {
	
	
	@Test
	public void assignment003()
	{
		
		String url = "https://petstore.swagger.io/v2/user/user123";
		RestAssured.given()
		.baseUri(url)
		.when().get()
		.then().statusCode(200)
		.log().all()
		.body("username", Matchers.equalTo("user123"))
		.body("email", Matchers.equalTo("user@gmail.com"))
		.body("userStatus",Matchers.equalTo(0));
		
	}
}