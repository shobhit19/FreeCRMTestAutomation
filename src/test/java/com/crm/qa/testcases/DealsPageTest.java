package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class DealsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	public DealsPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		dealsPage = new DealsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority=-1)
	public void verifyClickOnDealsTest() {
		try {
			dealsPage=homePage.clickOnDeals();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
