package com.liferay.damascus.functional.test.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.liferay.damascus.functional.test.utils.CommonMethods;

public class ToDoAdminPage {

	public ArrayList<String> getFullListFromToDoList() {

		_listElement = _commonMethods.getFullList(_titleContentLocator);
		return _listElement;
	}

	private static final By _titleContentLocator = By
			.xpath("//*[contains(@class,' text-left lfr-title-column') and text()]");

	ArrayList<String> _listElement = new ArrayList<String>();
	CommonMethods _commonMethods = new CommonMethods();
}
