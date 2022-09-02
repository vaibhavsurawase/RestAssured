import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DEMO_004_PrintALLHeaders {
	
	@Test
	void getAllDetails()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification req = RestAssured.given();
		
		Response response = req.request(Method.GET,"/");

//		System.out.println("getBody: "+response.getBody().asString());
		
		System.out.println("******************All Headers********************");
		for(Header header:response.headers())
		{
			System.out.println(header.getName()+"---->"+header.getValue());
		}
	
	}

}
