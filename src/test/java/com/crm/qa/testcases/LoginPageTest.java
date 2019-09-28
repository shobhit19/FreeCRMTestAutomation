package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;


public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() throws IOException  {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initilization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void validateTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test(priority=2)
	public void loginTest() throws IOException {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("clicked on sign in");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
