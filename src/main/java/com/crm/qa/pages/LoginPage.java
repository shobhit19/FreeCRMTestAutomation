package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	
	//object repository
	@FindBy(name="email")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//div[contains(text(),'Login')][1]")
	WebElement btnLogin;
	@FindBy(linkText = "Sign Up")
	WebElement sigup;
	
	//initialization
	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String uname,String pass) throws IOException {
		username.sendKeys(uname);
		password.sendKeys(pass);
		btnLogin.click();
		return new HomePage();
	}
	
	public SignUpPage clickOnSignUp() throws IOException {
		sigup.click();
		return new SignUpPage();
	}
	
}
