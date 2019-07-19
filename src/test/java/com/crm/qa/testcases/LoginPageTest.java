package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public  LoginPageTest(){
		super();
	}
 
  @BeforeMethod
  public void setUp() throws IOException{
	      initialization();
		  loginPage = new LoginPage();
  }

  @Test(priority=1)
  public void loinPageTitleTest() {
	  String title = loginPage.validateLoginPageTitle();
	  Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
  }
  
  @Test(priority=2)
  public void crmLogoImageTest() {
	  boolean flag=loginPage.validateCRMImage();
	  Assert.assertTrue(flag);
  }
  
  @Test(priority=3)
  public void loginTest() throws InterruptedException{
	  homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
