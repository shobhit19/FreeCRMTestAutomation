package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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
	@FindBy(name="first_name")
	WebElement firstName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name="value")
	WebElement email;
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement btnContactSave;
	public boolean verifyContactsLabel() {
		return labelContacts.isDisplayed();
	}
	
	public void selectCheckBox() {
		chkContacts.click();
	}
	
	public void clickOnNewContact() throws InterruptedException {
		btnNew.click();
		}
	public void createNewContact(String fname, String lname, String e_mail) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		email.sendKeys(e_mail);
	}
//	public void clickOnContactSave() {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", btnContactSave);
//	}
	
	}

