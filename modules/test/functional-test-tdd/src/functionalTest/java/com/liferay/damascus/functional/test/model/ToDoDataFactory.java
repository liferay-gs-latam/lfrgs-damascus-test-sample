package com.liferay.damascus.functional.test.model;

import com.github.javafaker.Faker;

public class ToDoDataFactory {

	private final Faker faker;

	public ToDoDataFactory() {
		faker = new Faker();
	}

	public ToDo createToDoList() {

		ToDo _toDo = ToDo.builder().
				title(faker.name().nameWithMiddle()).
				stat(true).
				todoDouble(faker.number().randomDouble(2, 1, 3)).
				toDoText(faker.harryPotter().spell()).
				build();

		return _toDo;
	}
}
