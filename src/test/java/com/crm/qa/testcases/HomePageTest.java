package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	public HomePageTest(){
		super();
	}
	
	 @BeforeMethod
	  public void setUp() throws IOException, InterruptedException{
		      initialization();
		      testUtil=new TestUtil();
		      //contactsPage = new ContactsPage();
			  loginPage = new LoginPage();
			  homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  }

	  @Test(priority=1)
	  public void validateHomePageTitleTest() {
		  String homePageTitle = homePage.validateHomePageTitle();
		  Assert.assertEquals(homePageTitle,"CRMPRO","Home page title not matched");
	  }
	  
	  @Test(priority=2)
	  public void userNameLabelTest() {
		  testUtil.switchToFrame();
		 Assert.assertTrue(homePage.validateUserNameLabel());
		 
	  }
	  
	  @Test(priority=3)
	  public void clickContactsLinkTest(){
		  testUtil.switchToFrame();
		  contactsPage = homePage.clickOnContactsLink();
	  }
	  
	  
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }

}
