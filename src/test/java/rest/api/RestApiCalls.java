package rest.api;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class RestApiCalls {

	@Test
	public void getCall() {
		System.out.println("=================GET CALL=================");

		//Make Get Call
		Response response = given().when().get("http://jsonplaceholder.typicode.com/posts/1").then().log().all().extract()
				.response();

		//Verify Status Code
		Assert.assertEquals("Status Code is wrong!", HttpStatus.SC_OK,
				response.getStatusCode());

		//Verify Response
		JsonPath jsonPathEvaluator = response.jsonPath();
		int userId = jsonPathEvaluator.getInt("userId");
		Assert.assertEquals("Response is not correct", userId, 1);

	}

	@Test
	public void postCall() {
		System.out.println("=================POST CALL=================");

		//Make Post Call
		String payload ="{\n  \"userId\": 1,\n  \"id\": 1,\n  \"title\": \"delectus aut autem\",\n  \"completed\": false\n}";
		Response response = given().accept(ContentType.JSON).body(payload).when().post("http://jsonplaceholder.typicode.com/posts").then().log().all().extract()
				.response();

		//Verify Status Code
		Assert.assertEquals("Status Code is wrong!", HttpStatus.SC_CREATED,
				response.getStatusCode());
	}

	@Test
	public void putCall() {
		System.out.println("=================PUT CALL=================");

		//Make Put Call
		String payload ="{\n  \"userId\": 1,\n  \"id\": 1,\n  \"title\": \"delectus aut autem\",\n  \"completed\": false\n}";
		Response response = given().accept(ContentType.JSON).body(payload)
				.when().put("http://jsonplaceholder.typicode.com/posts/1")
				.then().log().all().extract().response();

		//Verify Status Code
		Assert.assertEquals("Status Code is wrong!", HttpStatus.SC_OK,
				response.getStatusCode());
	}

	@Test
	public void deleteCall() {
		System.out.println("=================DELETE CALL=================");

		//Make Delete Call
		Response response = given().accept(ContentType.JSON)
				.when().delete("http://jsonplaceholder.typicode.com/posts/1")
				.then().log().all().extract().response();

		//Verify Status Code
		Assert.assertEquals("Status Code is wrong!", HttpStatus.SC_OK,
				response.getStatusCode());
	}
}
