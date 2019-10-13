package com.crm.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class HomePage extends TestBase {

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'shobhit v')]")
	WebElement userameLabel;
	@FindBy(xpath = "//a[@href='/contacts']")
	WebElement lnkContacts;
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement lnkDeals;
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement lnkTasks;
	@FindBy(id = "//div[@class='right menu']/div[@class='ui buttons']/div[@role='listbox']")
	WebElement dropDown;
	@FindBy(xpath = "//input[@type='text']")
	WebElement txtSearch;
	@FindBy(xpath = "//td[contains(text(),'No records found')]")
	WebElement txtRecords;
	@FindBy(id = "//button[@class='ui basic button item']")
	WebElement deleteRecords;
	@FindBy(xpath = "//button[contains(text(),'Purge Selected')]")
	WebElement btnPurge;
	@FindBy(xpath = "//button[contains(text(),'Restore Selected')]")
	WebElement btnRestoreSelected;
	@FindBy(xpath = "//a[@href='/calendar']")
	WebElement lnkCalendar;
	@FindBy(xpath = "//a[@href='/companies']")
	WebElement lnkCompanies;
	@FindBy(xpath = "//a[@href='/cases']")
	WebElement lnkCases;
	@FindBy(xpath = "//a[@href='/calls']")
	WebElement lnkCalls;
	@FindBy(xpath = "//a[@href='/documents']")
	WebElement lnkDocuments;
	@FindBy(xpath = "/email")
	WebElement lnkEmails;
	@FindBy(xpath="//a[@href='/compaigns']")
	WebElement lnkCompaigns;
	@FindBy(xpath="//a[@href='/forms']")
	WebElement lnkForms;
	
	
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

	public CalendarPage clickOnCalendar() throws IOException {
		lnkCalendar.click();
		return new CalendarPage();
	}

	public CompaniesPage clickOnCompanies() throws IOException {
		lnkCompanies.click();
		return new CompaniesPage();
	}

	public CasesPage clickOnCases() throws IOException {
		lnkCases.click();
		return new CasesPage();
	}

	public CallsPage clickOnCalls() throws IOException {
		lnkCalls.click();
		return new CallsPage();
	}

	public DocumentsPage clickOnDocuments() throws IOException {
		lnkDocuments.click();
		return new DocumentsPage();
	}

	public EmailPage clickOnEmail() throws IOException {
		lnkEmails.click();
		return new EmailPage();

	}
	
	public CompaignsPage clickOnCompaigns() throws IOException {
		lnkCompaigns.click();
		return new CompaignsPage();
	}

	public FormsPage clickOnForms() throws IOException {
		lnkForms.click();
		return new FormsPage();
	}
	
	public boolean verifyCorrectUserName() {
		return userameLabel.isDisplayed();
	}

	public void clickOnDeleteIconAndCheckEachCatRecords() {
		deleteRecords.click();
		List<WebElement> catIcons = driver.findElements(By.xpath("//div[@class='ui center aligned segment']"));
		System.out.println(catIcons.size());

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
