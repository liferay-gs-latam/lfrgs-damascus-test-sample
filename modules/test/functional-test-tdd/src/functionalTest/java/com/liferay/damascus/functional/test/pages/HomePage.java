package com.liferay.damascus.functional.test.pages;

import org.openqa.selenium.By;

import com.liferay.damascus.functional.test.constants.liferay.ILiferayConstants;
import com.liferay.damascus.functional.test.utils.CommonMethods;
import com.liferay.gs.testFramework.core.SeleniumReadPropertyKeys;

public class HomePage implements ILiferayConstants{

	public void login() {
		clickOnTheLoginButton();
		fillUserNameOnLoginForm();
		fillPasswordOnLoginForm();
		clickOnSignInLoginButton();
	}

	public void clickOnTheLoginButton() {
		_commonMethods.clickOnTheElement(_loginBtnLocator);
	}

	public void fillUserNameOnLoginForm() {
		_commonMethods.input(_usernameFieldLocator, SeleniumReadPropertyKeys.getDefaultUsername());
	}

	public void fillPasswordOnLoginForm() {
		_commonMethods.input(_passwordFieldLocator, SeleniumReadPropertyKeys.getDefaultPassword());
	}

	public void clickOnSignInLoginButton() {
		_commonMethods.clickOnTheElement(_signInBtnLocator);
	}
	
	public void addNewToDoList() {
	
		_commonMethods.goToSpecificURLPage_onTheSameTab(TODO_ADMIN_CONTROL_PANEL);
		
		clickOnAddButtonInToDoPortlet();
		fillTitleOnToDoForm();
		setToDoBooleanStatOnToDoForm();
		fillToDoDoubleOnToDoForm();
		fillToDoTextOnToDoForm();
		clickOnSubmitToDoForm();
	}
	
	public void clickOnAddButtonInToDoPortlet() {
		
		_commonMethods.clickOnTheElement(_addBtnLocator);		
	}
	
	public void fillTitleOnToDoForm() {
		_commonMethods.input(_titleFieldLocator, "Testing...");
	}
	
	public void setToDoBooleanStatOnToDoForm() {
		_commonMethods.clickOnTheElement(_statCheckBoxLocator);
	}
	
	public void fillToDoDoubleOnToDoForm() {
		_commonMethods.input(_toDoDoubleLocator, "2.2");
	}
	
	public void fillToDoTextOnToDoForm() {
		_commonMethods.input(_toDoTextLocator, "TODO TESTING");
	}

	public void clickOnSubmitToDoForm() {
		_commonMethods.clickOnTheElement(_submitBtnLocator);
	}

	//LOGIN PORTLET
	private static final By _loginBtnLocator = By.xpath("//*[contains(@id,'" + LOGIN_PORTLET + "')]//*[contains(@class,'sign-in')]");
	private static final By _usernameFieldLocator = By.xpath("//*[@id='" + LOGIN_PORTLET_USERNAME + "']");
	private static final By _passwordFieldLocator = By.xpath("//*[@id='" + LOGIN_PORTLET_PASSWORD + "']");
	private static final By _signInBtnLocator = By.xpath("//*[contains(@id,'" + LOGIN_PORTLET_SIGNIN + "')]//*[@class='lfr-btn-label']");

	//TO DO PORTLET
	private static final By _addBtnLocator = By.xpath("//*[@class='btn btn-primary nav-btn nav-btn-monospaced']");
	private static final By _titleFieldLocator = By.xpath("//*[@id='" + TODO_ADMIN_CONTROL_PANEL_TITLE +"']");
	private static final By _statCheckBoxLocator = By.xpath("//*[@id='" + TODO_ADMIN_CONTROL_PANEL_STAT +"']");
	private static final By _toDoDoubleLocator = By.xpath("//*[@id='" + TODO_ADMIN_CONTROL_PANEL_DOUBLE +"']");
	private static final By _toDoTextLocator = By.xpath("//*[@id='" + TODO_ADMIN_CONTROL_PANEL_TEXT +"']");
	private static final By _submitBtnLocator = By.xpath("//*[contains(@id,'" + TODO_ADMIN_CONTROL_PANEL_SUBMIT_BTN +"') and @type='submit']");
	
	CommonMethods _commonMethods = new CommonMethods();
}
