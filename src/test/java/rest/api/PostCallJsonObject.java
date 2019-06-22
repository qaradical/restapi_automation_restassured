package rest.api;
import org.json.simple.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class PostCallJsonObject {
	
	@Test
	public void postUsingJsonObject(){

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "Radical");
		jsonObj.put("job", "QA");

		given().
			header("Content-type", "application/json").
			and().
			body(jsonObj.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201).
			and().	
			log().all();		
	}
}