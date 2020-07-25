package com.liferay.damascus.functional.test.modal;

import com.github.javafaker.Faker;

public class ToDoDataFactory {

	private final Faker faker;

	public ToDoDataFactory() {
		faker = new Faker();
	}

	public ToDo createToDoList() {

		ToDo _toDo = ToDo.builder().
				title(faker.name().nameWithMiddle()).
				build();

		return _toDo;
	}
}
