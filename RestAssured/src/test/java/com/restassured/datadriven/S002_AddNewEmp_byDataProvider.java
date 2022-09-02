package com.restassured.datadriven;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class S002_AddNewEmp_byDataProvider {

	@Test(dataProvider="dataprovider")
	void dataDriven(String en,String salary,String age,String pic)
	{
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RequestSpecification req = RestAssured.given();
		
		JSONObject jdata=new JSONObject();
		jdata.put("employee_name", en);
		jdata.put("employee_salary", salary);
		jdata.put("employee_age", age);
		jdata.put("profile_image", pic);
		
		req.header("Content-Type","application/json");
		req.body(jdata.toJSONString());
		Response response = req.request(Method.POST,"/create");
		
		String resbody = response.getBody().asString();
		System.out.println(resbody);
	}
	@DataProvider(name="dataprovider")
	String[][] getEmpData()
	{
		String [][] empdata={ {"vaibhav","1500","27",""},
				  {"Ritesh","2500", "25",""},
				  {"Fulchand","3500","23",""} };
		return empdata;
		
     }
}