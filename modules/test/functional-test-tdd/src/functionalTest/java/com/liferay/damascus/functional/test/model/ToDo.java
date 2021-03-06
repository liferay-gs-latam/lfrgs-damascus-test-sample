package com.liferay.damascus.functional.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ToDo {

	String title;
	boolean stat;
	double todoDouble;
	String toDoText;
}
