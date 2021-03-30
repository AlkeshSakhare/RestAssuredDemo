package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_Verify_All_ResponseBody_Param_Test {
	@Test
	private void get_ResponseBody_Param_Test() {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city/";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "Mumbai");
		System.out.println("ResponseBody: " + response.getBody().asString());
		System.out.println("ResponseBody: " + response.getBody().asPrettyString());
		JsonPath jsonPath = response.jsonPath();
		System.out.println("City: " + jsonPath.get("City"));
		System.out.println("Temperature: " + jsonPath.get("Temperature"));
		System.out.println("Humidity: " + jsonPath.get("Humidity"));
		/*
		 * VVV IMP if Response key contains space then put that key in single quote('')'
		 * 
		 * E.g "All Category" then Yeah you need to escape the path if they contains
		 * space. It's a bit more readable if you use single quotes:
		 * Then-->"'All Categories'.data"
		 * https://github.com/rest-assured/rest-assured/issues/531
		 */
		System.out.println("Weather Description: " + jsonPath.get("'Weather Description'"));
		System.out.println("Wind Speed: " + jsonPath.get("'Wind Speed'"));
		System.out.println("Wind Direction degree: " + jsonPath.get("'Wind Direction degree'"));
	}
}
