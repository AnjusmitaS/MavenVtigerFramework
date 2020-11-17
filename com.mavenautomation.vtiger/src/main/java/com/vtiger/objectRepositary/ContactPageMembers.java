package com.vtiger.objectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPageMembers 
{
	@FindBy(css="img[title='Create Contact...']")
    private WebElement createContactPlusIcon;
	
	public WebElement getCreateContactPlusIcon()
	{
		return createContactPlusIcon;
	}
}
