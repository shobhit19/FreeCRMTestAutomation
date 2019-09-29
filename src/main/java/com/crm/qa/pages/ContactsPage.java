package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='ui loader']")
	WebElement labelContacts;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement chkContacts;
	@FindBy(linkText="New")
	WebElement btnNew;
	
	public boolean verifyContactsLabel() {
		return labelContacts.isDisplayed();
	}
	
	public void selectCheckBox() {
		chkContacts.click();
	}
	
	public void clickOnNewContact() throws InterruptedException {
		btnNew.click();
		}
	}

