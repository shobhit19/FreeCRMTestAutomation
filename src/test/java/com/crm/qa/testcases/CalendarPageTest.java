package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.testbase.TestBase;

public class CalendarPageTest extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	TasksPage taskPage;
	CalendarPage calendarPage;
	public CalendarPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod(groups= {"SmokeTests"})
	public void setUp() throws IOException {
		initilization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		calendarPage = new CalendarPage();
	}
	
	@Test(groups= {"SmokeTests"})
	public void clickOnCalendarTest() throws IOException, InterruptedException {
		calendarPage=homePage.clickOnCalendar();
	}
	
	@AfterMethod(groups= {"SmokeTests"})
	public void tearDown() {
		driver.quit();
	}
	
}
