import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DEMO_006_ExtractValueOfALLJSONPath {

	@Test
	void getValueOfALLNodes()
	{
		RestAssured.baseURI="https://reqres.in/api/user";
		RequestSpecification req = RestAssured.given();
		Response response = req.request(Method.GET,"/2");
		
//		System.out.println("Response Body: "+response.body().asString());
		
		JsonPath jsonpath = response.jsonPath();
		
		System.out.println(jsonpath.get("id"));
		System.out.println(jsonpath.get("name"));
		System.out.println(jsonpath.get("year"));
		System.out.println(jsonpath.get("color"));
		System.out.println(jsonpath.get("pantone_value"));
		System.out.println(jsonpath.get("support"));
		System.out.println(jsonpath.get("text"));
	}
}
