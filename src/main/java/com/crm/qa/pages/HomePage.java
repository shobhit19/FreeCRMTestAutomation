package com.crm.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.testbase.TestBase;

public class HomePage extends TestBase {

	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'shobhit v')]")
	WebElement userameLabel;
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement lnkContacts;
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement lnkDeals;
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement lnkTasks;
	@FindBy(id="//div[@class='right menu']/div[@class='ui buttons']/div[@role='listbox']")
	WebElement dropDown;
	@FindBy(xpath="//input[@type='text']")
	WebElement txtSearch;
	@FindBy(xpath="//td[contains(text(),'No records found')]")
	WebElement txtRecords;
	@FindBy(id="//button[@class='ui basic button item']")
	WebElement deleteRecords;
	@FindBy(xpath="//button[contains(text(),'Purge Selected')]")
	WebElement btnPurge;
	@FindBy(xpath="//button[contains(text(),'Restore Selected')]")
	WebElement btnRestoreSelected;
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts() throws IOException {
		lnkContacts.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDeals() throws IOException {
		lnkDeals.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() throws IOException {
		lnkTasks.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName() {
		return userameLabel.isDisplayed();
	}
	
	public void Search() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait= new WebDriverWait(driver,5);
		txtSearch=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
		txtSearch.sendKeys("deifgf"+ "\n");
	}
	
	public String getRecordCount() {
		return txtRecords.getText();
	}
	
	public void deleteRecords() {
		deleteRecords.click();
		
	}
//	public void clickOnDropDown() throws InterruptedException {
//		
//		Select sel= new Select(dropDown);
//		sel.selectByVisibleText("Settings");
//		sel.selectByVisibleText("Products");
//		sel.selectByVisibleText("Import");
//		sel.selectByVisibleText("Log Out");
		
		
//		dropDownSettings.click();
//		Actions action = new Actions(driver);
//		action.moveToElement(dropDownSettings).build().perform();
//		

	}

