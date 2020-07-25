package com.liferay.damascus.functional.test.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.FunctionalTest;
import com.liferay.gs.testFramework.core.SeleniumReadPropertyKeys;
import com.liferay.gs.testFramework.utils.SeleniumWaitMethods;

public class CommonMethods extends FunctionalTest {

	public void clickOnTheElement(By locator) {

		SeleniumWaitMethods.findElementWithWaitDriver(getWebDriver(), locator,
				ExpectedConditions::visibilityOfElementLocated, ExpectedConditions::elementToBeClickable);
		getWebDriver().findElement(locator).click();
	}

	public void input(By locator, String text) {

		SeleniumWaitMethods.findElementWithWaitDriver(getWebDriver(), locator,
				ExpectedConditions::visibilityOfElementLocated, ExpectedConditions::elementToBeClickable);
		getWebDriver().findElement(locator).clear();
		getWebDriver().findElement(locator).sendKeys(text);
	}

	public String getTextFromPage(By locator) {

		SeleniumWaitMethods.findElementWithWaitDriver(getWebDriver(), locator,
				ExpectedConditions::visibilityOfElementLocated, ExpectedConditions::elementToBeClickable);

		String getText = getWebDriver().findElement(locator).getText().trim();
		return getText;
	}

	public void getTimeOutImplicitWait() {
		getWebDriver().manage().timeouts().implicitlyWait(SeleniumReadPropertyKeys.getTimeOut(), TimeUnit.SECONDS);
	}

	public void goToDefaultUrlPage() {
		getWebDriver().get(SeleniumReadPropertyKeys.getUrlToHome());
	}

	public void setDimensionOfTheBrowser() {
		Dimension dimension = new Dimension(1424, 900);
		getWebDriver().manage().window().setSize(dimension);
	}

	public void setUpAll() {
		getTimeOutImplicitWait();
		goToDefaultUrlPage();
		setDimensionOfTheBrowser();
	}

	public void logoutBruteForce() {
		getWebDriver().get(String.valueOf(SeleniumReadPropertyKeys.getUrlToHome()) + "/c/portal/logout");
	}
	
	public void goToSpecificURLPage_onTheSameTab(String url) {
		SeleniumWaitMethods.waitLongTime();
		getWebDriver().get(url);
	}
}
