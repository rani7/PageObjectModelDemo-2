package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CompanyPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CompaniesPage companyPage;
	
	public CompanyPageTest(){
		super();
	}

	@BeforeMethod
	  public void setUp() throws IOException, InterruptedException{
		      initialization();
		      testUtil=new TestUtil();
		      companyPage = new CompaniesPage();
			  loginPage = new LoginPage();
			  homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			  testUtil.switchToFrame();
			  homePage.clickOnNewCompaniesLink();
	}
	
	@Test
	public void CreateNewCompanyTest() throws InterruptedException{
		companyPage.createNewCompany();
	}
	
	@AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }
}
