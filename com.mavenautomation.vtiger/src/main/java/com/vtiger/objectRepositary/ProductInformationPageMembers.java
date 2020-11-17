package com.vtiger.objectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductInformationPageMembers 
{

	@FindBy(css="span[class='lvtHeaderText")
	private WebElement productSuccessMsg;
	
	public WebElement getProductSuccessMsg()
	{
		return productSuccessMsg;
	}
	
}
