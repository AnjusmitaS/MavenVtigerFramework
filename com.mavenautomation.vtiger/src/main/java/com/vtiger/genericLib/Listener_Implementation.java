package com.vtiger.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_Implementation implements ITestListener
{

	@Override
	public void onFinish(ITestContext arg0) 
	{
		System.out.println(arg0.getName()+"Execution Finish");
	}

	@Override
	public void onStart(ITestContext arg0) 
	{
		System.out.println(arg0.getName()+"Execution Start");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) 
	{
		System.out.println(arg0.getName()+"Fails but some percentage");

	}

	@Override
	public void onTestFailure(ITestResult arg0)
	{
		Date d=new Date();// d holds the current Date and Time
		String currentDateTime = d.toString().replace(":", "-");
		                                  // as ':' doesn't support by File hence doing replacement
		System.out.println("Current Date Time : "+ currentDateTime);
		String testCaseName = arg0.getName();
		System.out.println(testCaseName+"Test Case Fail");
		
		EventFiringWebDriver efwd=new EventFiringWebDriver(BaseClass.driver);
		                                  // invoking baseclass driver
		File sourceFile = efwd.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("./Screenshot/"+testCaseName+currentDateTime+".png"));
		} // for better understanding getting SS with TC name and to avoid deletion and confusion also capturing
		  //     current date and time with SS..Here Screenshot file will be created and all SS will store there
		catch (IOException e) {	
		                        }
	}

	@Override
	public void onTestSkipped(ITestResult arg0) 
	{
		System.out.println(arg0.getName()+"Test Case Skipped");
	}

	@Override
	public void onTestStart(ITestResult arg0) 
	{
		System.out.println(arg0.getName()+"Test Case Start");
	}

	@Override
	public void onTestSuccess(ITestResult arg0)
	{
		System.out.println(arg0.getName()+"Test Case Success");
	}

}
