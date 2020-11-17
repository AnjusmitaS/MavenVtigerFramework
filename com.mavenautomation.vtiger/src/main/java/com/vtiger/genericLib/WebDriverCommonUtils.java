package com.vtiger.genericLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebDriverCommonUtils 
{
   String mainID;
   String childID;
   
   // EXPLICIT WAIT
   public void waitForElementToVisible(By locatorValue)
   {
	   WebDriverWait wait=new WebDriverWait(BaseClass.driver,20);
	   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorValue));
   }
   
   public void waitForAllElementToVisible(By locatorValue)
   {
	   WebDriverWait wait=new WebDriverWait(BaseClass.driver,20);
	   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorValue));	   
   }
   // AUTOSUGGESTION HANDLING
   public void pickItemFromAutoSuggestion(List<WebElement> suggestionList,String item)
   {
	   for(WebElement wb:suggestionList)
	   {
		   if(wb.getText().contains(item))
		   {
			   wb.click();
			   break;
		   }
	   }
   }
   // WINDOW HANDLING
   public void switchToChildWindow()
   {
	   Set<String> allID = BaseClass.driver.getWindowHandles();
	   Iterator<String> itr = allID.iterator();
	   
	   mainID=itr.next();
	   childID=itr.next();
	   BaseClass.driver.switchTo().window(childID);
   }
   
   public void switchToMainWindow() 
   {
	   BaseClass.driver.switchTo().window(mainID);
   }
   //FRAME HANDLING
   public void switchIntoFrame(WebElement frameElement)
   {
	   BaseClass.driver.switchTo().frame(frameElement);
   }
   
   public void switchToMainPage()
   {
	   BaseClass.driver.switchTo().defaultContent();
   }
   // AUTO-SUGGESTION HANDLING
   public void pickItemFromList(WebElement listElement,String item)
   {
	   Select s=new Select(listElement);
	   s.selectByVisibleText(item);
   }
   
   public List<WebElement> getAllOptionsFromList(WebElement listElement)
   {
	   Select s=new Select(listElement);
            List<WebElement> options = s.getOptions();	
            return options;
   }
   // ALERT HANDLING
   private void waitForAlert()
   {
	   WebDriverWait wait=new WebDriverWait(BaseClass.driver,20);
	   wait.until(ExpectedConditions.alertIsPresent());
   }
   
   public void acceptAlert()
   {
	   waitForAlert();
	   Alert alt = BaseClass.driver.switchTo().alert();
	   alt.accept();
   }
   
   public void rejectAlert()
   {
	   waitForAlert();
	   Alert alt = BaseClass.driver.switchTo().alert();
	   alt.dismiss();
   }

   public void validateAlertMsg(String expMsg)
   {
	   waitForAlert();
	   Alert alt = BaseClass.driver.switchTo().alert();
         String actualAlertMsg = alt.getText();	
         
         Assert.assertEquals(actualAlertMsg, expMsg);
         System.out.println("Alert Validated Successfully..");
   }
   // MOUSEOVER
   public void moveMouseOnElement(WebElement targetElement)
   {
	  Actions act=new Actions(BaseClass.driver) ;
	  act.moveToElement(targetElement).perform();
   }
   // DRAG & DROP HANDLING
   public void handleDragDrop(WebElement sourceElement,WebElement targetElement)
   {
		  Actions act=new Actions(BaseClass.driver) ;
             act.dragAndDrop(sourceElement, targetElement).perform();	   
   }
   // SCROLL HANDLING
   public void scrollMainWindow(int horizontalDistance,int verticalDistance)
   {
	   JavascriptExecutor jse=(JavascriptExecutor)BaseClass.driver;
	   jse.executeScript("window.scrollBy("+horizontalDistance+","+verticalDistance+")");
   }
   // FILE UPLOAD HANDLING
   public void waitUpto(int timeinSec)
   {
	  try {
		  Thread.sleep(timeinSec);
	     }
	  catch(InterruptedException e)
	  {
		  e.printStackTrace();
	  }
   }
   
   public void uploadDocument(WebElement uploadBtn,String filePath)
   {
	   String typeValue = uploadBtn.getAttribute("type");
	      
	   if(typeValue.equalsIgnoreCase("file"))
	   {
		   uploadBtn.sendKeys(filePath);
	   }
	   else
	   { 
		   uploadBtn.click();
		   StringSelection path=new StringSelection(filePath);
		   Toolkit tool = Toolkit.getDefaultToolkit();
		   Clipboard clip = tool.getSystemClipboard();
		   clip.setContents(path, null);
		   
		   try {
			   Robot r=new Robot();
			   waitUpto(500);
			   r.keyPress(KeyEvent.VK_CONTROL);
			   r.keyPress(KeyEvent.VK_V);
			   waitUpto(500);
			   r.keyRelease(KeyEvent.VK_CONTROL);
			   r.keyRelease(KeyEvent.VK_V);
			   waitUpto(500);
			   r.keyPress(KeyEvent.VK_ENTER);
			   r.keyRelease(KeyEvent.VK_ENTER);			   
		   }
		   catch(AWTException e)
		   {
			   
		   }
	   }
   }
}
























