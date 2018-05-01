package ReusableFunctionality;
 
import io.appium.java_client.AppiumDriver;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import Execute.RUN;
import SupportLibraries.Report;
import TestSteps.TestSteps;
 
 
public class ReusableFunction extends TestSteps{
               
/////////////////////////////////////////Click by using ID///////////////////////               
                public static void clickById(String objects, String description,
                                                String testData)  {
                                try {
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.id(objects)).click();
                                                Report.pass(description+" is clicked successfully", objects, testData);
                                } else {
                                                Report.fail(description+" Object not available and count is "+count, objects, testData);
                                }
                               
                                                
                                } catch (Exception e) {
                                                Report.fail("Exception in clickById function: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Click by using name///////////////////////        
                public static void clickByName(String objects, String description,
                                                String testData) {
                                try {
                                int count = driver.findElements(By.name(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.name(objects)).click();
                                                Report.pass(description+" is clicked successfully", objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                               
                                                
                                } catch (Exception e) {
                                                Report.fail("Exception in clickByName function: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Click by using xpath///////////////////////        
                public static void clickByXpath(String objects,String description, String testData)
                {
                                try{
                                int count=driver.findElements(By.xpath(objects)).size();
                                if(count==1)
                                {
                                                driver.findElement(By.xpath(objects)).click();
                                                Report.pass( description+" is clicked successfully",  objects, testData);
                                }else
                                {
                                                Report.fail(description+" Object not available",  objects, testData);
                                }
                                }
                                catch (Exception e) {
                                                Report.fail("Exception in clickByXpath function: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Click by using LinkText///////////////////////  
                public static void clickByLinktext(String objects, String description,
                                                String testData){
                                try {
                                int count = driver.findElements(By.linkText(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.linkText(objects)).click();
                                                Report.pass(description+" is clicked successfully", objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                               
                                                
                                }catch (Exception e) {
                                                Report.fail("Exception in clickByLinktext function: "+e, "Nil", "Nil");
                                }
                }
 
/////////////////////////////////////////Click by using ID///////////////////////               
                public static void inputById(String objects, String description,
                                                String testData){
                                try{
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.id(objects)).sendKeys(testData);;
                                                Report.pass(description+ " Text field", objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Exception in inputById function: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Input by using name///////////////////////      
public static void inputByName(String objects, String description,
                                String testData){
                try {
                int count = driver.findElements(By.name(objects)).size();
                if (count == 1) {
                                driver.findElement(By.name(objects)).sendKeys(testData);;
                                Report.pass(description+ " Text field", objects, testData);
                } else {
                                Report.fail(description+" Object not available", objects, testData);
                }
               
                                
                } catch (Exception e) {
                                Report.fail("Exception in inputByName function: "+e, "Nil", "Nil");
                }
}

/////////////////////////////////////////Drop Down Selection Through Xpath(No test data)///////////////////////  

                public static void dropboxSelectXpath(String objects, String description,
                                                String testData) {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                               
                                                String dropText =  driver.findElement(By.xpath(objects)).getText();
                                                String[] drop=objects.split("/option");
                                                Thread.sleep(2000);
                                                new Select(driver.findElement(By.xpath(drop[0]))).selectByVisibleText(dropText);
                                               
                                                Report.pass(description+ "dropdown", objects, dropText);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Exception in dropboxSelectXpath function: "+e, "Nil", "Nil");
                                }
                }

               
/////////////////////////////////////////Input by using xpath///////////////////////                  
                public static void inputByXpath(String objects, String description,
                                                String testData){
                                try{
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.xpath(objects)).sendKeys(testData);;
                                                Report.pass(description+" Text field", objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Exception in inputByXpath function: "+e, "Nil", "Nil");
                                }
                }
                
                
                
/////////////////////////////////////////get Attribute by using id///////////////////////     
public static void getAttributeById(String objects, String description,
                        String testData)  {
        try {
        String runtimeText = "";
        int count = driver.findElements(By.id(objects)).size();
        if (count == 1) {
                        runtimeText = driver.findElement(By.id(objects)).getAttribute("value");
                        if (runtimeText.trim().equals(testData)) {
                                        Report.pass("Expected text is available: " + testData, objects,
                                                                        testData);
                        } else {
                                        Report.fail("Expected text is not available: " + testData,
                                                                        objects, testData);
                        }
                        // Report.pass(description, objects, testData);
        } else {
                        Report.fail(description + " Object not available", objects,
                                                        testData);
        }
       
                        
        } catch (Exception e) {
                        Report.fail("Exception in getAttributeById function: "+e, "Nil", "Nil");
        }
}

                
                ////////Drop Down Select/////////////////////   
               
                public static void dropSelectByID(String objects, String description,
                                                String testData) {
                                try{
                                String runtimeText = "";
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                new Select(driver.findElement(By.id(objects))).selectByVisibleText(testData);        
                                                Report.pass("Drop down selected successfully " + testData, objects,
                                                        testData);
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Exception in dropSelectByID function: "+e, "Nil", "Nil");
                                }
                }
               
              
                      
                
                ////////Child Window navigation/////////////////////   
                
                public static void navigateChildWindow(String objects, String description,
                                                String testData) {
                                try{
                                //boolean blnExpectedWindowFound=false;
                                
                                for (String handle : driver.getWindowHandles()) {
                                                driver.switchTo().window(handle);
                                                String strCurrentUrl = driver.getCurrentUrl();
                                                //Decoding the URL
                                                String strDecodedUrl=URLDecoder.decode(strCurrentUrl, "US-ASCII");
                                                if ((strDecodedUrl.toUpperCase()).indexOf(testData.toUpperCase())!=-1){
                                                                //blnExpectedWindowFound=true;
                                                                try {
                                                                                ((JavascriptExecutor) driver).executeScript("window.focus();");
                                                                                driver.manage().window().maximize();
                                                                                Report.pass("Child window navigation Success: "+testData, objects, testData);
                                                                } catch (Exception ex){
                                                                                Report.fail("Child window not available: "+testData, objects, testData);
                                                                }
                                                                break;
                                                }
                                } 
                                Thread.sleep(3000);}catch (Exception e) {
                                                Report.fail("Exception in navigateChildWindow function: "+e, "Nil", "Nil");
                                }
                }
               
               
              
                
                ////////Object available validation/////////////////////   
               
                public static String objectXpathYes(String objects, String description,
                                                String testData) {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                                Report.pass(description + " Object available", objects,
                                                                                testData);
                                                return "true";
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                                return "false";
                                }
                               
                                                
                                } catch (Exception e) {
                                                Report.fail("Exception in objectXpathYes function: "+e, "Nil", "Nil");
                                                return "false";
                                }
}
               
                
                
          ////////Object not available validation/////////////////////      
                
                public static String objectXpathNO(String objects, String description,
                                                String testData)  {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 0) {
                                                Report.pass(description + " Object not available", objects,
                                                                                testData);
                                                return "true";
                                } else {
                                                Report.fail(description + " Object available", objects,
                                                                                testData);
                                                return "false";
                                }
                               
                                                
                                } catch (Exception e) {
                                                Report.fail("Exception in objectXpathNO function: "+e, "Nil", "Nil");
                                                return "false";
                                }
}
               
  
   
          	  public static void screenShot(String DES)
              {
                   try{
                          if(!Browser1.equals("HTML Unit Driver"))
                         {
                         DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
                         Date date1 = new Date();
                        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                        FileUtils.copyFile(scrFile, new File("Reports//"+date23+"//"+dateFormat1.format(date1)+"screenshot.png"));
                       
                                 bw.write("<tr>");
                                 bw.write("<td border="+2+" width="+50+">" +
                                             "<a href="+dateFormat1.format(date1)+"screenshot.png"+"><font color="+blue+"><b><center>ScreenShot</center></font></a></td>");
                                 bw.write("<td colspan="+5+" border="+2+" width="+300+">"+DES+"</td>");
                                 bw.write("</tr>");
                         }
                          Thread.sleep(500);
                   }catch(Exception e)
                 {
                        System.out.println("Exception in screenShot function: "+e);
                 }
           
        }
              ///Page Scroll Down///////////////////             
                 
                public static void scrollDownEnd() {
                                try{
                                Robot robot=new Robot();
                                robot.keyPress(java.awt.event.KeyEvent.VK_END);
                                robot.keyRelease(java.awt.event.KeyEvent.VK_END);
                                Thread.sleep(3000);}
                                catch (Exception e) {
                                                Report.fail("Exception in scrollDownEnd function: "+e, "Nil", "Nil");
                                }
                }
 /////////////Wait by ID/////////////////////////
                
                public static String waitByID(String obj,int waittime) {
                	try{
                		WebDriverWait wait = new WebDriverWait(driver, waittime);
                		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(obj)));
                	   	return "true";
                	}catch (Exception e) {
                         //Report.failm("Exception in waitByID function: "+e, "Nil", "Nil");
                		return "false";
         }

    }
                
 /////////////Wait by Xptah/////////////////////////
                
                public static String waitByXpath(String obj,int waittime) {
                	try{
                		WebDriverWait wait = new WebDriverWait(driver, waittime);
                		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj)));
                	   	return "true";
                	}catch (Exception e) {
                         //Report.failm("Exception in waitByXpath function: "+e, "Nil", "Nil");
                         return "false";
         }

    }
                public static void pressEnter()
                {
                	try
                	{
	                	Robot robot=new Robot();
	                    robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	                    robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	                    Thread.sleep(1000);
                	}
                	catch (Exception e) 
                	{
                        Report.fail("Exception in pressEnter function: "+e, "Nil", "Nil");
                        
                	}
                }
                
                public static void verfyAlertBooxMsgAndAccept(String Alertmessage)
                {
                	try
                	{
                		Alert alert = driver.switchTo().alert();
                		String alertMessage= driver.switchTo().alert().getText();
                		System.out.println(alertMessage);
                		if (alertMessage.equalsIgnoreCase(Alertmessage))
                		{
                			Report.pass(Alertmessage+" is displayed","Nill","Nill");
                			//screenShot("Alert Box screenshot");
                			alert.accept();	
                		}
                		else
                		{
                			Report.fail(Alertmessage+" is not displayed", "Nil", "Nil");
                		}
                	}
                	catch(Exception e)
                	{
                		Report.fail("Exception in alertBox function: "+e, "Nil", "Nil");
                	}
                }
               
}