package com.vtiger.objectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadPageMembers {

	@FindBy(css="img[title='Create Lead...']")
	private WebElement createLeadPlusIcon;
	
	public WebElement getCreateLeasPlusIcon()
	{
		return createLeadPlusIcon;
	}
	
	
}
