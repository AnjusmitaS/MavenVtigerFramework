package com.vtiger.genericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.vtiger.objectRepositary.HomePageMembers;
import com.vtiger.objectRepositary.LoginPageMember;

public class BaseClass 
{
   public static WebDriver driver;
   public SoftAssert soft=new SoftAssert();
   public DataStorage picker=new DataStorage();
   
   //@BeforeSuite(groups= {"smoke","integration"}) FOR GROUP EXECUTION
   @BeforeSuite
   public void configBS()
   {
	   System.out.println("DB Connected");
   }
  // @BeforeTest(groups= {"smoke","integration"}) FOR GROUP EXECUTION
   @BeforeTest
   public void configBT()
   {
	   System.out.println("Before Test Dependency");
   }
  // @BeforeClass(groups= {"smoke","integration"}) FOR GROUP EXECUTION
   @BeforeClass
   /*  CHANGES FOR CROSS_BROWSER BATCH EXECUTION ONLY
    @Parameters("browserValue")
   public void configBC(String browserValue) throws IOException
   {
       if(browserValue.equals("chrome"))
       {
    	  driver= new ChromeDriver();
       }
       else if(browserValue.equals("firefox"))
       {
    	   driver=new FirefoxDriver();
       }
      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
      driver.get(picker.getDataFromProperty("url"));
      driver.manage().window().maximize();
      System.out.println("Launch Browser");
   }*/
   public void configBC() throws IOException
   {
	   String browserValue=picker.getDataFromProperty("browser");
       if(browserValue.equals("chrome"))
       {
    	   System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe" );
    	  driver= new ChromeDriver();
       }
       else if(browserValue.equals("firefox"))
       {
    	   System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe" );

    	   driver=new FirefoxDriver();
       }
      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
      driver.get(picker.getDataFromProperty("url"));
      driver.manage().window().maximize();
      System.out.println("Launch Browser");
   }

  // @BeforeMethod(groups= {"smoke","integration"}) FOR GROUP EXECUTION
   @BeforeMethod
   public void configBM() throws IOException
   {
	   LoginPageMember login=PageFactory.initElements(driver, LoginPageMember.class);
	   login.loginToApp(picker.getDataFromProperty("username"),picker.getDataFromProperty("password"));
   }
   //@AfterMethod(groups= {"smoke","integration"}) FOR GROUP EXECUTION
   @AfterMethod
   public void configAM()
   {
	   HomePageMembers hp = PageFactory.initElements(driver, HomePageMembers.class);
	    hp.logoutFromApp();
	    System.out.println("Logout Done");
   }
  // @AfterClass(groups= {"smoke","integration"})
   @AfterClass
   public void configAC()
   {
	   driver.quit();
	   System.out.println("Browser Closed");
   }
  // @AfterTest(groups= {"smoke","integration"})
   @AfterTest
   public void configAT()
   {
	   System.out.println("After Test Dependency");
   }
  // @AfterSuite(groups= {"smoke","integration"})
   @AfterSuite
   public void configAS()
   {
	   System.out.println("DB Dis-connected");
   }
}

















