package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class CallsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	CallsPage callsPage;
	public CallsPageTest() throws IOException {
		super();
	}
	
	@BeforeTest(groups= {"SmokeTests"})
	public void setUp() throws IOException {
		initilization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(groups= {"SmokeTests"})
	public void clickOnCallsTest() throws IOException {
		callsPage=homePage.clickOnCalls();
		Assert.assertEquals(driver.getCurrentUrl(), "https://ui.freecrm.com/calls","url does not match");
		
	}
	
	@AfterMethod(groups= {"SmokeTests"})
	public void tearDown() {
		driver.quit();
	}
	
}

