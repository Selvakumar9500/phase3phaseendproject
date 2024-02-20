package phaseendproject;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Assignement004 {

@Test
public void assignment004()
{
	
	String url = "https://petstore.swagger.io/v2/user/login";
	RestAssured.given()
	.baseUri(url)
	.auth().preemptive().basic("user123", "user@123")
	.when().get()
	.then().statusCode(200)
	.log().all()
	.body("message", Matchers.anything());
	
}
}
