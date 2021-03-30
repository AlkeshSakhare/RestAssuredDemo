package demo;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.ExcelUtility;

public class TC006_DDT_AddEmployee_Test {

	@Test(dataProvider = "Employee")
	private void addEmployee(String name, String job) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject param = new JSONObject();
		param.put("name", name);
		param.put("job", job);
		httpRequest.body(param.toJSONString());
		httpRequest.header("Content-Type", "application/json");
		Response response = httpRequest.request(Method.POST, "/api/users");
		System.out.println(response.getBody().asString());
	}

	@DataProvider(name = "Employee")
	private Object[][] getData() {
		// TODO Auto-generated method stub
		Object data[][] = null;
		try {
			data = ExcelUtility.getTestData("Sheet1");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
