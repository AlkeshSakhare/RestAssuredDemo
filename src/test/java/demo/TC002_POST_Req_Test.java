package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Req_Test {

	@Test
	private void register_customer() {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", "Amar");
		requestParam.put("job", "Shayar");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST, "/api/users");
		System.out.println(response.getBody().asString());
		System.out.println("CODE: " + response.statusCode());
		System.out.println("Status Line: " + response.getStatusLine());
	}
}
