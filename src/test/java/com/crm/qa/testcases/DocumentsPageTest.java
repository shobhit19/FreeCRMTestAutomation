package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.crm.qa.pages.DocumentsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class DocumentsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	DocumentsPage documentPage;
	public DocumentsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod(groups= {"SmokeTests"})
	public void setUp() throws IOException {
		initilization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
	}
	
	@Test(groups= {"SmokeTests"})
	public void clickOnDocumentsTest() throws IOException {
		documentPage=homePage.clickOnDocuments();
		Assert.assertEquals(driver.getCurrentUrl(), "https://ui.freecrm.com/documents","url does not match");
		
		
	}
	
	@AfterMethod(groups= {"SmokeTests"})
	public void tearDown() {
		driver.quit();
	}
}
