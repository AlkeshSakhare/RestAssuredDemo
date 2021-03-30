package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_Basic_Auth_Test {

	@Test
	private void verify_Basic_Auth_Test() {
		// TODO Auto-generated method stub

		/*
		 * https://jasonwatmore.com/post/2019/10/21/aspnet-core-3-basic-authentication-
		 * tutorial-with-example-api
		 * 
		 * https://github.com/cornflourblue/aspnet-core-3-basic-authentication-api
		 */
		RestAssured.baseURI = "http://localhost:4000";
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName("test");
		auth.setPassword("test");
		RestAssured.authentication = auth;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/users");
		System.out.println(response.getBody().prettyPrint());
	}
}
