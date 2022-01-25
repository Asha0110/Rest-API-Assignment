package com.Reqres.InApi.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_Get_Request {

	@Test
	public void test_getAllUsers() {

		// specify base URI
		RestAssured.baseURI = "https://reqres.in";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET, "/api/users?/page=2");

		// print response in console window
		String responseBody = response.getBody().asString();
		//System.out.println("Response body is: " + responseBody);
		response.prettyPrint();

		// status code validation
		int statuscode = response.getStatusCode();
		System.out.println("status code is: " + statuscode);
		Assert.assertEquals(statuscode, 200);

	}

}
