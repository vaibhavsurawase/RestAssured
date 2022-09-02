import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DEMO_007_Basic_Autherization {
     
	@Test
	void Autherization_Test()
	{
		RestAssured.baseURI="----------------";

//		Basic Autherization
	    PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
	    auth.setUserName("");
	    auth.setPassword("");
	    RestAssured.authentication=auth;
	   
		RequestSpecification req=RestAssured.given();
		Response response = req.request(Method.GET,"/abc");
	
		System.out.println(response.body().asString());
		
	}
	

}
