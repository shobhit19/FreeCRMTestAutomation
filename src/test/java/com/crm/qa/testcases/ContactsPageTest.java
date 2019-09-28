//package com.crm.qa.testcases;
//
//import java.io.IOException;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.crm.qa.pages.ContactsPage;
//import com.crm.qa.pages.LoginPage;
//import com.crm.qa.testbase.TestBase;
//
//public class ContactsPageTest extends TestBase {
//
//	LoginPage loginPage;
//	ContactsPage contactsPage;
//	
//	public ContactsPageTest() throws IOException {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@BeforeMethod
//	public void setup() throws IOException {
//		initilization();
//		loginPage = new LoginPage();
//		contactsPage = new ContactsPage();
//		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		
//	}	
//	
//	@Test
//	public void verifyClickOnContactsLabel() {
//		contactsPage.verifyContactsLabel();
//	}
//	
//	@Test
//	public void verifyCheckBoxContactsPage() {
//		contactsPage.selectCheckBox();
//	}
//	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
//}
