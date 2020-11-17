package com.vtiger.objectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewContactPageMembers 
{
	@FindBy(name="lastname")
	private WebElement lastName_tf;
	
	@FindBy(css="input[value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getLastNameTF()
	{
		return lastName_tf;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}

}
