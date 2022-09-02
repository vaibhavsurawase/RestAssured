import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request 
{
	private static final int Content = 0;

	@Test
	void HeaderTest()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RequestSpecification httpReq = RestAssured.given();
		Response response = httpReq.request(Method.GET,"/3");
		
//		HeaderTest
		String Header_ContentType=response.header("Content-Type");
		System.out.println("Header_ContentType: "+Header_ContentType);
		Assert.assertEquals(Header_ContentType, "application/json; charset=utf-8");
		
		String Header_server=response.header("Server");
		System.out.println("Server: "+Header_server);
		Assert.assertEquals(Header_server, "cloudflare");
		
		
	}

}
