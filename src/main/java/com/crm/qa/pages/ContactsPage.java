package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLink(){
		return contactsLink.isDisplayed();
	}
	
	public void selectSingleContact(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"' and @_id='52555126']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
			
    public void createNewContact(String title,String fName,String lName,String comp){
    	
    	Select select = new Select(driver.findElement(By.name("title")));
    	select.selectByVisibleText(title);
    	firstName.sendKeys(fName);
    	LastName.sendKeys(lName);
    	company.sendKeys(comp);
    	saveBtn.click();
    }
	
}
