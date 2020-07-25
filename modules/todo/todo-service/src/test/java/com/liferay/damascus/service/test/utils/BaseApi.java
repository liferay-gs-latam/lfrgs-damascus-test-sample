package com.liferay.damascus.service.test.utils;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.port;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class BaseApi {

	public static void preCondition() {
		baseURI = "http://localhost";
		basePath = "/api/jsonws";
		port = 8080;
		
		RestAssured.requestSpecification = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.build();

		enableLoggingOfRequestAndResponseIfValidationFails();
	}
}