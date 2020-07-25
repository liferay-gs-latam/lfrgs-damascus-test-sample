package com.liferay.damascus.functional.test.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.liferay.damascus.functional.test.constants.ILiferayConstants;
import com.liferay.damascus.functional.test.modal.ToDo;
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
	
	public ArrayList<String> addNewToDoList(ToDo toDo) {
	
		_listElement = new ArrayList<String>();
		_commonMethods.goToSpecificURLPage_onTheSameTab(TODO_ADMIN_CONTROL_PANEL);
		
		clickOnAddButtonInToDoPortlet();
		fillTitleOnToDoForm(toDo.getTitle());
		setToDoBooleanStatOnToDoForm(toDo.isStat());
		fillToDoDoubleOnToDoForm(toDo.getTodoDouble());
		fillToDoTextOnToDoForm(toDo.getToDoText());
		clickOnSubmitToDoForm();
		
		_listElement.add(toDo.getTitle());
		return _listElement;
	}
	
	public void clickOnAddButtonInToDoPortlet() {
		
		_commonMethods.clickOnTheElement(_addBtnLocator);		
	}
	
	public void fillTitleOnToDoForm(String titleName) {
		_commonMethods.input(_titleFieldLocator, titleName);
	}
	
	public void setToDoBooleanStatOnToDoForm(boolean stat) {
		if (stat) {
			_commonMethods.clickOnTheElement(_statCheckBoxLocator);
		}
	}
	
	public void fillToDoDoubleOnToDoForm(double toDoDouble) {
		String toDoDoubleS = Double.toString(toDoDouble);
		_commonMethods.input(_toDoDoubleLocator, toDoDoubleS);
	}
	
	public void fillToDoTextOnToDoForm(String text) {
		_commonMethods.input(_toDoTextLocator, text);
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

	ArrayList<String> _listElement;
	CommonMethods _commonMethods = new CommonMethods();
}
