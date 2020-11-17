package com.vtiger.objectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadInformationPageMembers 
{
  @FindBy(css="span[class='dvHeaderText")
  private WebElement leadSuccessMsg;
  
  public WebElement getLeadSuccessMsg()
  {
	  return leadSuccessMsg;
  }
	
	
}
