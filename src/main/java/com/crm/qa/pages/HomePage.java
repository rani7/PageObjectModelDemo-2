package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: naveen k')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Companies')]")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[contains(text(),'New Company')]")
	WebElement newCompaniesLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateUserNameLabel(){
		return userNameLabel.isDisplayed();
	}
	
    public ContactsPage clickOnContactsLink(){
    	contactsLink.click();
    	return new ContactsPage();
    }
    
    public void clickOnNewContactsLink(){
    	
    	Actions action = new Actions(driver);
    	action.moveToElement(contactsLink).build().perform();
    	newContactsLink.click();
    }
    
    public void clickOnNewCompaniesLink(){
    	
    	Actions action = new Actions(driver);
    	action.moveToElement(companiesLink).build().perform();
    	newCompaniesLink.click();
    }
}
