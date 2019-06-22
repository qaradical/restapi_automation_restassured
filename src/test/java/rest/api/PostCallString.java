package rest.api;

import org.junit.Test;
import static io.restassured.RestAssured.*;

public class PostCallString {

	@Test
	public void postUsingString(){
		
		String payload = "{\n\t\"name\" : \"Radical\",\n\t\"job\" : \"QA\"\n}\n";
	
		given().
			header("Content-type", "application/json").
			and().
			body(payload).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201).
			and().	
			log().all();	
	}
}