import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DEMO_001_GET {
	@Test
	void getEmployee()
	{
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RequestSpecification req = RestAssured.given();
		Response response = req.request(Method.GET,"/employees");
		
		System.out.println(response.getBody().asString());

	}
}
