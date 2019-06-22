package rest.api;

import org.junit.Test;
import static io.restassured.RestAssured.*;

public class PostCallJavaObject {

	@Test
	public void postUsingJavaObject() {

		InputToPostCallJavaObject inputJavaObject = new InputToPostCallJavaObject(
				"Radical", "QA");

		given().
			header("Content-type", "application/json").
			and().
			body(inputJavaObject).
		when()
			.post("https://reqres.in/api/users").
		then().
			statusCode(201).
			and().
			log().all();
	}
}
