
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request
{
	@Test
	void getDetails()
	{
//		Specify Base URI
		RestAssured.baseURI="https://reqres.in/api/user";
		
//		Request object 
		RequestSpecification httpRequest=RestAssured.given();
		
//		Response object
		Response response=httpRequest.request(Method.GET,"/2");
		
//		Print Response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
//	    Status code Validation
		int Statuscode = response.getStatusCode();
		System.out.print("Status Code: "+Statuscode);
		Assert.assertEquals(Statuscode, 200);
		
//      Status Line Validation
		String Statusline = response.getStatusLine();
		System.out.print("Status Line: "+Statusline);
		Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");
	
		
	}

}


