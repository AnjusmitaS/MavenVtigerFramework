package com.vtiger.objectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageMembers {

	@FindBy(css="img[title='Create Product...']")
     private WebElement createProductPlusIcon;
	
	public WebElement getCreateProductPlusIcon()
	{
		return createProductPlusIcon;
	}
}
