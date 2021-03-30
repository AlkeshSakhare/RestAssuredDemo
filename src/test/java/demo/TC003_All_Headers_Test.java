package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_All_Headers_Test {

	@Test
	private void get_all_headers() {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/api/users?page=2");
		Headers headers = response.getHeaders();
		for (Header header : headers) {
			System.out.println(header.getName() + " \t : " + header.getValue());
		}
	}

}
