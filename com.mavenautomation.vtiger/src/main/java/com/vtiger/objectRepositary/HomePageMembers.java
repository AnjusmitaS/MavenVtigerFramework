package com.vtiger.objectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib.BaseClass;

public class HomePageMembers 
{
	@FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td[1]")
    private WebElement signOutDD;
	
	@FindBy(linkText="Sign Out")
    private WebElement signOutLink;
	
	@FindBy(linkText="Contacts")
    private WebElement contactLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	
	public WebElement getLeadsLink()
	{
		return leadsLink;
	}
	
	public WebElement getContactLink()
	{
		return contactLink;
	}
	
	public WebElement getSignOutDD()
	{
		return signOutDD;
	}

	public WebElement getSignOutLink()
	{
		return signOutLink;
	}
	public WebElement getProductLink()
	{
		return productsLink;
	}
	
	// re-usable method for logOut
	public void logoutFromApp()
	{
		 Actions act=new Actions(BaseClass.driver);
		 act.moveToElement(signOutDD).perform();
		 signOutLink.click();
	}
}
