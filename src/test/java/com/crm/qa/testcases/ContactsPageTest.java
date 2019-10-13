package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	ContactsPage contactsPage;
	HomePage homePage;
	public String sheetName="contacts";
	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod(groups= {"SmokeTests"})
	public void setup() throws IOException {
		initilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}	
	
	@Test(groups= {"SmokeTests"})
	public void verifyClickOnContactsLabel() throws IOException {
		contactsPage=homePage.clickOnContacts();
	}

	@Test(priority=2)
	public void verifyClickOnNewContact() throws IOException, InterruptedException {
		contactsPage=homePage.clickOnContacts();
		contactsPage.clickOnNewContact();
		System.out.println("clicked on New button");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object [][]data=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String Email) throws IOException, InterruptedException {
		contactsPage=homePage.clickOnContacts();
		contactsPage.clickOnNewContact();
		//contactsPage.createNewContact();
		contactsPage.createNewContact(firstName, lastName, Email);
		contactsPage.clickOnSave();
	
	}
	
//	@Test
//	public void verifyClickOnContactsCancel() {
//		contactsPage.clickOnCancel();
//	}
//	
//	@Test
//	public void verifyClickOnSave() {
//		contactsPage.clickOnSave();
//	}
	
	@AfterMethod(groups= {"SmokeTests"})
	public void tearDown() {
		driver.quit();
	}
}
