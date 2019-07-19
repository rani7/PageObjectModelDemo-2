package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	  public void setUp() throws IOException, InterruptedException{
		      initialization();
		      testUtil=new TestUtil();
		      contactsPage = new ContactsPage();
			  loginPage = new LoginPage();
			  homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			  testUtil.switchToFrame();
			  contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLink(),"Contact label is missing");
	}
	
	@Test(priority=2)
	public void selectSingleContactTest(){
		contactsPage.selectSingleContact("Angelina Jolie");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][]=testUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=3,dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String title,String firstName,String lastName,String company){
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContact(title,firstName,lastName,company);
	}
	
	@AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }
}
