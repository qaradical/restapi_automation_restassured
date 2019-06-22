package rest.api;

import org.junit.Test;
import static io.restassured.RestAssured.*;

public class DeleteCall {

	@Test
	public void deleteAPICall(){
		
	given().
		header("Content-type", "application/json").
	when().
		delete("http://jsonplaceholder.typicode.com/posts/1").
	then().
		statusCode(200).
		and().
		log().all();
	}
}