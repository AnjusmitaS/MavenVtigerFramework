package com.vtiger.objectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewLeadPageMembers 
{
   @FindBy(name="lastname")
   private WebElement lastName_tf;
   
   @FindBy(name="company")
   private WebElement companyName_tf;
   
   @FindBy(css="input[value='  Save  ']")
   private WebElement saveBtn;

	
	public WebElement getCompanyNameTF()
	{
		return companyName_tf;
	}
	
	public WebElement getLastNameTF()
	{
		return lastName_tf;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
		
}
