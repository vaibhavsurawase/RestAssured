package com.restassured.datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.restassured.XLUtils.XLUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class S003_AddNewEmp_fromExcel {

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
	String[][] getEmpData() throws EncryptedDocumentException, IOException
	{
		String path=System.getProperty("user.dir")+"/Test data/Test1.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Sheet2");
		int colcount = XLUtils.getCellCount(path,"Sheet2", 1);
		
		String [][] empdata=new String[rowcount][colcount];
		
		for (int i=1; i<=rowcount; i++)
		{
			for (int j=0; j<colcount; j++)
			{
				empdata [i-1][j]=XLUtils.getCellData(path, "Sheet2", rowcount, colcount);
			}
        }
		return (empdata);
	}

}	