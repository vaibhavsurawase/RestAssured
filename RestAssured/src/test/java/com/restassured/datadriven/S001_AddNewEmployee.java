package com.restassured.datadriven;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class S001_AddNewEmployee {
	@Test
	void postNewEmployee()
	{
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RequestSpecification req = RestAssured.given();
		
		JSONObject jdata=new JSONObject();
		jdata.put("employee_name", "Vaibhav");
		jdata.put("employee_salary", 162700);
		jdata.put("employee_age", 27);
		jdata.put("profile_image", " ");
		
		req.header("Content-Type","application/json");
		req.body(jdata.toJSONString());
		Response response = req.request(Method.POST,"/create");
		
		String resbody = response.getBody().asString();
		Assert.assertTrue(resbody.contains("Vaibhav"));
		Assert.assertTrue(resbody.contains("162700"));
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}

}


