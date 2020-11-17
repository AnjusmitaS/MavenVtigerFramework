package com.vtiger.objectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewProductPageMembers 
{
   @FindBy(name="productname")
   private WebElement productName_tf;
   
   @FindBy(css="input[value='  Save  ']")
   private WebElement saveBtn;
   
	public WebElement getProductNameTF()
	{
		return productName_tf;
	}
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
}
