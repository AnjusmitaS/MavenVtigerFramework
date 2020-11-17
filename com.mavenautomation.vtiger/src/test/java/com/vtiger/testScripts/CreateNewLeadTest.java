package com.vtiger.testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepositary.CreateNewLeadPageMembers;
import com.vtiger.objectRepositary.HomePageMembers;
import com.vtiger.objectRepositary.LeadInformationPageMembers;
import com.vtiger.objectRepositary.LeadPageMembers;

@Listeners(com.vtiger.genericLib.Listener_Implementation.class)
public class CreateNewLeadTest  extends BaseClass
{
 // @Test(groups= {"smoke"})  FOR GROUP EXECUTION
	@Test
  public void createNewLead() throws IOException, Exception
  {	
		  HomePageMembers hp = PageFactory.initElements(driver, HomePageMembers.class);
	       hp.getLeadsLink().click();
	       
	       LeadPageMembers lp = PageFactory.initElements(driver,LeadPageMembers.class);
	        lp.getCreateLeasPlusIcon().click();
	  
	     CreateNewLeadPageMembers cn = PageFactory.initElements(driver,CreateNewLeadPageMembers.class);
	               cn.getLastNameTF().sendKeys(picker.getDataFromExcel("TestCaseData",1,2));
	              cn.getCompanyNameTF().sendKeys(picker.getDataFromExcel("TestCaseData",2,2));
	             cn.getSaveBtn().click();
	  
	         LeadInformationPageMembers lip = PageFactory.initElements(driver,LeadInformationPageMembers.class);
	         String actualResult=lip.getLeadSuccessMsg().getText();
	      
	         // hard assert
	      Assert.assertTrue(actualResult.contains(picker.getDataFromExcel("TestCaseData", 3, 2)));
		  Reporter.log("Lead Created SuccessFully",true);

	      // System.out.println("Lead Created Successfully..");

  }
}
