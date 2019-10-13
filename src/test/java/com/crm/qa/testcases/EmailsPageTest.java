package com.crm.qa.testcases;

import java.io.IOException;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.EmailPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class EmailsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	EmailPage emailPage;
	public EmailsPageTest() throws IOException {
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
	public void clickOnEmailTest() throws IOException {
		emailPage=homePage.clickOnEmail();
		Assert.assertEquals(driver.getCurrentUrl(),"https://ui.freecrm.com/email" );
	}
	
	@AfterMethod(groups= {"SmokeTests"})
	public void tearDown() {
		driver.quit();
	}
}
