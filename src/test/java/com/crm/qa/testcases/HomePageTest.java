package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;





public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() throws IOException {
		super();
	}

	// test cases should be independent of each other
	// before each test case launch the browser and login
	// after each test case close the browser
	
	@BeforeMethod
	public void setUp() throws IOException {
		initilization();
		loginPage = new LoginPage();
		contactsPage= new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority=1,enabled=false)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle,"Cogmento CRM","Home Page Title noyt matched");	
	}
	
	@Test(priority=2,enabled=false)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3,enabled=false)
	public void clickOnContactsLinkTest() throws IOException {
		contactsPage=homePage.clickOnContacts();
	}
//	@Test
//	public void verifyClickedOnDropDownSettings() {
//		try {
//			homePage.clickOnDropDown();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void clickOnDeleteIconAndCheckEachCatRecordsTest() {
		homePage.clickOnDeleteIconAndCheckEachCatRecords();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
}
