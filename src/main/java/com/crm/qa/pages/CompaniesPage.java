package com.crm.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CompaniesPage extends TestBase {

	@FindBy(id="company_name")
	WebElement cmpName;
	
	@FindBy(xpath="//input[@type='button' and @value='Lookup']")
	WebElement lookupParentCmp;
	
	@FindBy(id="search")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//a[contains(text(),'amazon')]")
	WebElement selectParentCmp;
	
	@FindBy(xpath="//form[@id='contactForm']//tbody//input[@type='submit' and @value='Save']")
	//input[@type='button' and @value='Load From Company']//following-sibling::input[@type='submit' and @value='Save']
	WebElement saveBtn;
	
	
	public CompaniesPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void createNewCompany() throws InterruptedException{
		cmpName.sendKeys("paymall");
		Thread.sleep(3000);
		Select status = new Select(driver.findElement(By.xpath("//select[@name='status']")));
		status.selectByValue("Active");
		lookupParentCmp.click();
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		String parentWindowId=it.next();
		String childWindowId=it.next();
		driver.switchTo().window(childWindowId);
		searchBox.sendKeys("amazon");
		searchBtn.click();
		selectParentCmp.click();
		driver.switchTo().window(parentWindowId);
		//driver.switchTo().frame("mainpanel");
		saveBtn.click();
		
	}
}
