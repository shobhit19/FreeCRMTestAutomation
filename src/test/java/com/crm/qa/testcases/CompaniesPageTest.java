package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;


public class CompaniesPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CompaniesPage companiesPage;
	
	public CompaniesPageTest() throws IOException {
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
	public void clickOnCompaniesTest() throws IOException {
		companiesPage=homePage.clickOnCompanies();
		String companiesUrl=driver.getCurrentUrl();
		Assert.assertEquals(companiesUrl, "https://ui.freecrm.com/companies","url does not match");
	}
	
	@AfterMethod(groups= {"SmokeTests"})
	public void tearDown() {
		driver.quit();
	}
}
