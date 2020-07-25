package com.liferay.damascus.functional.test.tests;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.liferay.damascus.functional.test.modal.ToDoDataFactory;
import com.liferay.damascus.functional.test.modal.ToDo;
import com.liferay.damascus.functional.test.pages.HomePage;
import com.liferay.damascus.functional.test.pages.ToDoAdminPage;
import com.liferay.damascus.functional.test.utils.CommonMethods;

public class ToDoTest {

	@Before
	public void setUpAll() throws Exception {
		_commonMethods.setUpAll();
	}

	@After
	public void afterEachMethods() {
		if (needToLogout) {
			_commonMethods.logoutBruteForce();
		}
	}

	@Test
	public void validateTheListItemsAppearsToTheUserAfterItHasBeenCreated() {

		ToDo toDo = new ToDoDataFactory().createToDoList();
		
		_homePage.login();
		_listElement = _homePage.addNewToDoList(toDo);

		Assert.assertTrue(_toDoAdminPage.getFullListFromToDoList().contains(_listElement.get(0)));
		needToLogout = true;
	}

	boolean needToLogout = false;
	ArrayList<String> _listElement = new ArrayList<String>();

	CommonMethods _commonMethods = new CommonMethods();
	ToDoAdminPage _toDoAdminPage = new ToDoAdminPage();
	HomePage _homePage = new HomePage();
}
