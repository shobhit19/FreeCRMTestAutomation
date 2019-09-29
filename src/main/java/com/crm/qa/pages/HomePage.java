package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class HomePage extends TestBase {

	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'shobhit v')]")
	WebElement userameLabel;
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement lnkContacts;
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement lnkDeals;
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement lnkTasks;
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts() throws IOException {
		lnkContacts.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDeals() throws IOException {
		lnkDeals.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() throws IOException {
		lnkTasks.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName() {
		return userameLabel.isDisplayed();
	}
}
