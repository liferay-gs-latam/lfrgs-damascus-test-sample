package com.liferay.damascus.functional.test.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.liferay.damascus.functional.test.pages.HomePage;
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
		
		_homePage.login();
		_homePage.addNewToDoList();
		
		needToLogout=true;
	}

	boolean needToLogout=false;
	CommonMethods _commonMethods = new CommonMethods();
	HomePage _homePage = new HomePage();
}
