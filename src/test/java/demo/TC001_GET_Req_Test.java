package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Req_Test {

	@Test
	private void get_Weather() {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city/";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "Mumbai");
		System.out.println("BODY: " + response.getBody().asString());
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Status Line: " + response.getStatusLine());
		System.out.println("Temperature: " + response.jsonPath().get("Temperature"));

	}

}
