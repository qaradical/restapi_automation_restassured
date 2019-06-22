package rest.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class PutCallAndResponseVerification {

	
	//given() can have - headers, parameters, body, contenttype, cookies, relaxedHTTPSValidation 
	//when() can have - HTTP methods get(),post(),put(),delete()
	//then() can have - response Assert, status code
	
	
	@Test
	public void putCall() throws IOException {
		
		FileInputStream fileInput = new FileInputStream(new File(
				"src/test/resources/UserDataUpdate.json"));

		//Make a post call and Store Response
		Response response = given().
			header("Content-type", "application/json").
			and().
			body(IOUtils.toString(fileInput, "UTF-8")).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			and().	
			log().all().
			extract().response();

		//Verify Response
		JsonPath jsonPath = new JsonPath(response.asString());
		System.out.println("Name is - " + jsonPath.get("name"));
		Assert.assertEquals("Radical", jsonPath.get("name"));
	}
}