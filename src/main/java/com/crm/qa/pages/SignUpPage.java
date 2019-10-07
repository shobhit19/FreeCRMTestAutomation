package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.testbase.TestBase;

public class SignUpPage extends TestBase{

	@FindBy(name="email")
	WebElement emailSignUp;
	@FindBy(xpath="//input[@class='search']")
	WebElement dropDownSignUp;
	
	public SignUpPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	
}
