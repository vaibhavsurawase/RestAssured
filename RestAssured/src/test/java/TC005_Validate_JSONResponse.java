import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC005_Validate_JSONResponse {
	
	@Test
	void validate_Response()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification req = RestAssured.given();
		
		Response response = req.request(Method.GET,"/2");
		
		String resbody = response.getBody().asString();
		
		Assert.assertEquals(resbody.contains("Janet"), true);
//		Assert.assertTrue(resbody.contains("Janet"));
		
	}

}
