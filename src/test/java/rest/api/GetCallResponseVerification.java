package rest.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.IOException;
import junit.framework.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class GetCallResponseVerification {

	//given() can have - headers, parameters, body, contenttype, cookies, relaxedHTTPSValidation 
	//when() can have - HTTP methods get(),post(),put(),delete()
	//then() can have - response Assert, status code

	@Test
	public void getCall() throws IOException {
		Response response = given().
			header("Content-type", "application/json").
		when().
			get("https://reqres.in/api/users").
		then().
			statusCode(200).
			and().
			log().all().
			and().
			extract().response();

		JsonPath jsonPath = new JsonPath(response.asString());

		//Verify value of Json Object
		Assert.assertEquals(4, jsonPath.get("total_pages"));
		
		//Verify value from Json Array
		Assert.assertEquals("george.bluth@reqres.in", jsonPath.get("data[0].email"));
		
		//Print values email of all users of Json Array
		System.out.println(jsonPath.get("data.email"));
	}
}