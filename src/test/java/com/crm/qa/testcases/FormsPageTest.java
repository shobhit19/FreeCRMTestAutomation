package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class FormsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	public FormsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod(groups= {"SmokeTests"})
	public void setUp() throws IOException {
		initilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(groups= {"SmokeTests"})
	public void clickOnFormsTest() throws IOException {
		homePage.clickOnForms();
		Assert.assertEquals(driver.getCurrentUrl(), "https://ui.freecrm.com/forms","url does not match");
		
	}
	@AfterMethod(groups= {"SmokeTests"})
	public void tearDown() {
		driver.quit();
	}
}
