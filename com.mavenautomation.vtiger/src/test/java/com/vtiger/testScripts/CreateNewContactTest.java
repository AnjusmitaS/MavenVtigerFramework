package com.vtiger.testScripts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepositary.ContactInformationPageMembers;
import com.vtiger.objectRepositary.ContactPageMembers;
import com.vtiger.objectRepositary.CreateNewContactPageMembers;
import com.vtiger.objectRepositary.HomePageMembers;

@Listeners(com.vtiger.genericLib.Listener_Implementation.class)
public class CreateNewContactTest extends BaseClass 
{
  // @Test(groups= {"smoke","integration"}) FOR GROUP EXECUTION
	@Test
   public void createNewContact() throws IOException, Exception
   {
		 HomePageMembers hp = PageFactory.initElements(driver, HomePageMembers.class);
	                hp.getContactLink().click();
	  
	  // Here Soft Assert to Validate Contact Page Displayed or not
	  String actTitle=driver.getTitle();
	  String expTitle=picker.getDataFromExcel("TestCaseData",5 ,2);
	  soft.assertTrue(actTitle.contains(expTitle));
	  
	  ContactPageMembers cp = PageFactory.initElements(driver, ContactPageMembers.class);
	  cp.getCreateContactPlusIcon().click();
	  
	  CreateNewContactPageMembers cncp = PageFactory.initElements(driver, CreateNewContactPageMembers.class);
	  cncp.getLastNameTF().sendKeys(picker.getDataFromExcel("TestCaseData",4,2));
	  cncp.getSaveBtn().click();
	  
	  ContactInformationPageMembers cip = PageFactory.initElements(driver, ContactInformationPageMembers.class);
	  String actualResult=cip.getContactSucessMsg().getText();
	  // Here Hard Assert to validate Main TestCase need i.e contact created or not
	  Assert.assertTrue(actualResult.contains(picker.getDataFromExcel("TestCaseData", 6,2)));
	  soft.assertAll();
	  Reporter.log("Contact Created SuccessFully",true);

	 // System.out.println("Contact Created Successfully..");
   }
}
