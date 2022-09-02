import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.netty.handler.codec.http.HttpRequest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request 
{
	@Test
	void getDetails()
	{
//		Specify Base URI
		RestAssured.baseURI="https://reqres.in/api";
		
//		Request object 
	    RequestSpecification httpRequest = RestAssured.given();
		
//	    Request Payload Sending Along with Post Request
	    
	    JSONObject reqParam=new JSONObject();
	    
	    reqParam.put("email", "Vaibhav@abc");
	    reqParam.put("first_name", "Vaibhav1");
	    reqParam.put("last_name", "Surawsae");
	    reqParam.put("avatar", "https://reqres.in/img/faces/2-image.jpg");
	    
	    httpRequest.header("Content-Type", "application/json"); 
	    httpRequest.body(reqParam.toJSONString());
	    
//		Response object
		Response response= httpRequest.request(Method.POST,"/users");
		
//	    Print Response in console window
		String resBody = response.getBody().asString();
	    System.out.println("Response Body: "+resBody);
	    
//	    Status code Validation
	    int Statuscode = response.getStatusCode();
	    System.out.println("Statuscode: "+Statuscode);
	    Assert.assertEquals(Statuscode, 201);
	    
//	    last_name validation
	    String last_name1=response.jsonPath().get("last_name");
	    Assert.assertEquals(last_name1, "Surawsae");

	}


}
