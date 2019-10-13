package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.testbase.TestBase;

public class TasksPageTest extends TestBase{

	LoginPage loginPage;
	TasksPage tasksPage;
	HomePage homePage;
	public TasksPageTest() throws IOException {
		super();
	}	
	
	@BeforeMethod(groups= {"SmokeTests"})
	public void setup() throws IOException {
		initilization();
		homePage = new HomePage();
		loginPage= new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		tasksPage = new TasksPage();
	}
	
	@Test(groups= {"SmokeTests"})
	public void clickOnTasksTest() {
		try {
			tasksPage=homePage.clickOnTasks();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod(groups= {"SmokeTests"})
	public void tearDown() {
		driver.quit();
	}
}
