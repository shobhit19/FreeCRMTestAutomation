package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class CasesPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CasesPage casePage;
	public CasesPageTest() throws IOException {
		super();
	}

	@BeforeMethod(groups= {"SmokeTests"})
	public void setUp() throws IOException {
		initilization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		
	}
	
	@Test(groups= {"SmokeTests"})
	public void clickOnCasesTest() throws IOException {
		casePage=homePage.clickOnCases();
		Assert.assertEquals(driver.getCurrentUrl(),"https://ui.freecrm.com/cases","url does not match");	
	}
	
	@AfterMethod(groups= {"SmokeTests"})
	public void tearDown() {
		driver.quit();
	}
}
