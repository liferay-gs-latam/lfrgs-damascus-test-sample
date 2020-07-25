package com.liferay.damascus.services.test.tests;
import static org.hamcrest.CoreMatchers.is;

import org.junit.BeforeClass;
import org.junit.Test;

import com.liferay.damascus.service.test.client.ToDoClient;

import io.restassured.response.ValidatableResponse;

public class ToDoServiceLayerTest {

	static ToDoClient toDoclient;

	@BeforeClass
	public static void preCondition() {
		toDoclient = new ToDoClient();
	}

	@Test
	public void deleteToDoContentCreated_failed_404NotFound() {

		int primaryKey = 203;
		ValidatableResponse response = toDoclient.deleteToDo_primaryKeyDoesNotExist_404NotFound(primaryKey);

		response.body("error.message", is("No Todo exists with the primary key " + primaryKey));
	}

}
