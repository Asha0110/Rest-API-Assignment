package com.Reqres.InApi.TestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_Post_Request {

	@Test
	public void createNewUsers() {

		// specify request
		RestAssured.baseURI = "https://reqres.in";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request payload sending along with post request
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", "morpheus");
		requestParam.put("job", "leader");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParam.toJSONString());

		// Response object
		Response response = httpRequest.request(Method.POST, "/api/users");

		// print response in console window
		response.prettyPrint();
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);

		// status code validation
		int statuscode = response.getStatusCode();
		System.out.println("status code is: " + statuscode);
		Assert.assertEquals(statuscode, 201);

	}

}
