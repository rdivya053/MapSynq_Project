package TestSteps;

import java.awt.Robot;

import org.openqa.selenium.By;

import ReusableFunctionality.ReusableFunction;
import SupportLibraries.Excel;
import SupportLibraries.Report;
import SupportLibraries.pro_1;

public class mapSynq extends TestSteps{
	public static pro_1 obj = new pro_1(file.show());
	public static pro_1 mapSynq = new pro_1(file.mapSynq());
	  
	  
	public static void registerNewUser()
	{
		try 
		{
			String Xpath_Radio_Gender="//input[@name='profile[gender]'][@value='"+Excel.Exceldata("Register_Data", "Gender")+"']";		
			
			ReusableFunction.screenShot("Map Synq Home Page");
			ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Link_Register"), "Register Link", "Nill");
			//ReusableFunction.waitByID(mapSynq.ReadProperty("Id_Txt_FirstName"), 30);
			Thread.sleep(1000);

			if ((ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Heading_SignUpPage"),30)).equalsIgnoreCase("true"))
			{
				ReusableFunction.screenShot("Map Synq Sign Up Page");
				ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_FirstName"), "First Name",Excel.Exceldata("Register_Data", "FirstName"));
				ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_LastName"), "Last Name", Excel.Exceldata("Register_Data", "LastName"));
				ReusableFunction.dropSelectByID(mapSynq.ReadProperty("Id_DD_Country"), "Country", Excel.Exceldata("Register_Data", "Country"));
				ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_Address"), "Address", Excel.Exceldata("Register_Data", "Address"));
				ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_ContactNo"), "Contact No", Excel.Exceldata("Register_Data", "ContactNo"));
				ReusableFunction.clickByXpath(Xpath_Radio_Gender, "Gender", "Nill");
				ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_DOB"), "Date Of Birth", Excel.Exceldata("Register_Data", "DOB"));
				ReusableFunction.pressEnter();
				ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_Email"), "Email", Excel.Exceldata("Register_Data", "Email"));
				ReusableFunction.getAttributeById(mapSynq.ReadProperty("Id_Label_UserName"), "User Name", Excel.Exceldata("Register_Data", "Email"));
				ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_Password"), "Password", Excel.Exceldata("Register_Data", "Password"));
				ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_ConfirmPassword"), "Confirm Password", Excel.Exceldata("Register_Data", "ConfirmPassword"));
				if ((Excel.Exceldata("Register_Data","SubToNewsLetter")).equalsIgnoreCase("Y"))
				{
					if ((ReusableFunction.objectXpathYes(mapSynq.ReadProperty("Xpath_ChkBox_SubToNewsLetter"),"Subscribe to News Letter is checked","Nill")).equalsIgnoreCase("false"))
					{
						ReusableFunction.clickById(mapSynq.ReadProperty("Id_ChkBox_SubToNewsLetter"), "Subscribe to News Letter", "Nill");
					}
				}
				else
				{
					if ((ReusableFunction.objectXpathYes(mapSynq.ReadProperty("Xpath_ChkBox_SubToNewsLetter"),"Subscribe to News Letter is checked","Nill")).equalsIgnoreCase("true"))
					{
						ReusableFunction.clickById(mapSynq.ReadProperty("Id_ChkBox_SubToNewsLetter"), "Subscribe to News Letter", "Nill");
					}
				}
				if ((ReusableFunction.objectXpathYes(mapSynq.ReadProperty("Xpath_ChkBox_Agree"),"Agree to terms and Condition","Nill")).equalsIgnoreCase("true"))
				{
					ReusableFunction.clickById(mapSynq.ReadProperty("Id_ChkBox_Agree"), "Agree to Terms and Condition", "Nill");
				}
				ReusableFunction.screenShot("Sign Up Page after entering all details");
				ReusableFunction.clickByXpath(mapSynq.ReadProperty("xpath_Button_CreateProfile"), "Create Profile Button", "Nill");
				//ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Btn_SignIn"), 60);
				Thread.sleep(2000);
				if ((ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Message_AccountCreated"),60)).equalsIgnoreCase("true"))
			//	if (((ReusableFunction.objectXpathYes(mapSynq.ReadProperty("Xpath_Message_AccountCreated"),"Account Created Message","Nill")).equalsIgnoreCase("true"))
			//			&& ((ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Btn_SignIn"), 60)).equalsIgnoreCase("true")))
				{
					Report.pass("Account Created Successfully", "Nil", "Nil");
					ReusableFunction.screenShot("Account Created successfully");
				}
				else
				{
					Report.fail("Problem in creating new account", "Nil", "Nil");
					
				}
			}
			else
			{
				Report.fail("Sign Up Page doe snot exist", "Nil", "Nil");
				
			}
			
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Report.fail("Exception in registerNewUser funtion: "+e, "Nil", "Nil");
		}
		
		
	}
	
	public static void signIn()
	{
		try
		{
			String Xpath_Label_UserName="//div[@class='account_bar']/span/a[contains(text(),'"+Excel.Exceldata("Login_Data", "UserName")+"')]";
			
			if ((ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Link_SignIn"), 30)).equalsIgnoreCase("true"))
			{
				Thread.sleep(1000);
				ReusableFunction.screenShot("Map Synq Home Page");
				ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Link_SignIn"), "Sign In link", "Nill");
				if ((ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Btn_SignIn"), 30)).equalsIgnoreCase("true"))
				{
					ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_UserName"), "User Name Field", Excel.Exceldata("Login_Data", "UserName"));
					ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_Password"), "Password Field", Excel.Exceldata("Login_Data", "Password"));
					ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Btn_SignIn"), "Sign In Button", "Nill");
					if (ReusableFunction.waitByXpath(Xpath_Label_UserName, 30).equalsIgnoreCase("true"))
					{
						Thread.sleep(3000);
						Report.pass("Login is successful", "Nil", "Nil");
						ReusableFunction.screenShot("Login Page");
					}
				}
				else
				{
					Report.fail("Login Page does not load properly", "Nil", "Nil");
					
				}
			}
			else
			{
				Report.fail("SignIn link does not exist", "Nil", "Nil");
				
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			Report.fail("Exception in signIn funtion: "+e, "Nil", "Nil");
		}
	}
	
	
	public static void verifyRouteswithSelectedCheckbox()
	{
		try
		{
			String Xpath_DD_LocationFrom="//div[@class='autocomplete']/div[2][@title='"+Excel.Exceldata("Directions_Data", "LocationFrom").toUpperCase()+"']";
			String Xpath_DD_LocationTo="//div[@class='autocomplete']/div[2][@title='"+Excel.Exceldata("Directions_Data", "LocationTo").toUpperCase()+"']";
			if (ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Tab_Directions"), 30).equalsIgnoreCase("true"))
			{
				ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Tab_Directions"), "Directions Tab", "Nill");
				if (ReusableFunction.waitByID(mapSynq.ReadProperty("Id_Txt_LocationFrom"), 30).equalsIgnoreCase("true"))
				{
						driver.findElement(By.id(mapSynq.ReadProperty("Id_Txt_LocationFrom"))).clear();
						ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_LocationFrom"), "Location From Text Field", Excel.Exceldata("Directions_Data", "LocationFrom"));
						ReusableFunction.clickByXpath(Xpath_DD_LocationFrom, "Selected Location From Dropdown", Excel.Exceldata("Directions_Data", "LocationFrom"));
						Thread.sleep(1000);
						ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_LocationTo"), "Location To Text Field", Excel.Exceldata("Directions_Data", "LocationTo"));
						//ReusableFunction.pressEnter();
						ReusableFunction.clickByXpath(Xpath_DD_LocationTo, "Selected Location To Dropdown", Excel.Exceldata("Directions_Data", "LocationTo"));
						Thread.sleep(1000);
						if (ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Link_galactioAd"), 2).equalsIgnoreCase("true"))
						{
							ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Link_galactioAd"), "Galactio Ad", "Nill");
						}
						////////////////Different Checkbox Operations///////////////////////////////////////////////
						getDirectionsWithDifferentChoices(mapSynq.ReadProperty("Id_ChkBox_Traffic"),mapSynq.ReadProperty("Xpath_Table_Traffic"),"Traffic Aware checkbox");
						getDirectionsWithDifferentChoices(mapSynq.ReadProperty("Id_ChkBox_Fastest"),mapSynq.ReadProperty("Xpath_Table_Fastest"),"Fastest checkbox");
						getDirectionsWithDifferentChoices(mapSynq.ReadProperty("Id_ChkBox_Toll"),mapSynq.ReadProperty("Xpath_Table_Toll"),"Toll Aware checkbox");
						getDirectionsWithDifferentChoices(mapSynq.ReadProperty("Id_ChkBox_Shortest"),mapSynq.ReadProperty("Xpath_Table_Shortest"),"Shortest checkbox");
						
				}
				else
				{
					Report.fail("Left Tabs (Directions, Personal and Live) does not exist", "Nil", "Nil");
				}
			}
			else
			{
				Report.fail("Left Tabs (Directions, Personal and Live) does not exist", "Nil", "Nil");
			}

				
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			Report.fail("Exception in verifyRouteswithSelectedCheckbox funtion: "+e, "Nil", "Nil");
		}
	}
	
	
	public static void getDirections()
	{
		try
		{
			String Xpath_DD_LocationFrom="//div[@class='autocomplete']/div[2][@title='"+Excel.Exceldata("Directions_Data", "LocationFrom").toUpperCase()+"']";
			String Xpath_DD_LocationTo="//div[@class='autocomplete']/div[2][@title='"+Excel.Exceldata("Directions_Data", "LocationTo").toUpperCase()+"']";
			if (ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Tab_Directions"), 30).equalsIgnoreCase("true"))
			{
				ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Tab_Directions"), "Directions Tab", "Nill");
				if (ReusableFunction.waitByID(mapSynq.ReadProperty("Id_Txt_LocationFrom"), 30).equalsIgnoreCase("true"))
				{
						driver.findElement(By.id(mapSynq.ReadProperty("Id_Txt_LocationFrom"))).clear();
						ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_LocationFrom"), "Location From Text Field", Excel.Exceldata("Directions_Data", "LocationFrom"));
						ReusableFunction.clickByXpath(Xpath_DD_LocationFrom, "Selected Location From Dropdown", Excel.Exceldata("Directions_Data", "LocationFrom"));
						Thread.sleep(1000);
						ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_LocationTo"), "Location To Text Field", Excel.Exceldata("Directions_Data", "LocationTo"));
						ReusableFunction.clickByXpath(Xpath_DD_LocationTo, "Selected Location To Dropdown", Excel.Exceldata("Directions_Data", "LocationTo"));
						Thread.sleep(1000);
						if (ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Link_galactioAd"), 2).equalsIgnoreCase("true"))
						{
							ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Link_galactioAd"), "Galactio Ad", "Nill");
						}
						ReusableFunction.clickById(mapSynq.ReadProperty("Id_Btn_Getdirections"), "Get Directions Button", "Nill");
						ReusableFunction.screenShot("Directions screenshot");
				}
				else
				{
					Report.fail("Left Tabs (Directions, Personal and Live) does not exist", "Nil", "Nil");
				}
			}
			else
			{
				Report.fail("Left Tabs (Directions, Personal and Live) does not exist", "Nil", "Nil");
			}

				
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			Report.fail("Exception in getDirections funtion: "+e, "Nil", "Nil");
		}
	}
	
	public static void saveRoute()
	{
		try
		{
			Thread.sleep(2000);
			if (ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Link_SaveRoute"), 20).equalsIgnoreCase("true"))
			{
				ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Link_SaveRoute"), "Save Route Link", "Nill");
				if (ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Label_Popup"), 10).equalsIgnoreCase("true"))
				{
					ReusableFunction.inputById(mapSynq.ReadProperty("Id_Txt_RouteName"), "Route Name Field", Excel.Exceldata("Directions_Data", "RouteName"));
					ReusableFunction.dropSelectByID(mapSynq.ReadProperty("Id_DD_AlertTime_Hr"), "Alert Time: Hr", Excel.Exceldata("Directions_Data", "AlertTimeHr"));
					ReusableFunction.dropSelectByID(mapSynq.ReadProperty("Id_DD_AlertTime_Min"), "Alert Time: Min", Excel.Exceldata("Directions_Data", "AlertTimeMin"));
					ReusableFunction.screenShot("Save Route Pop up");
					ReusableFunction.clickById(mapSynq.ReadProperty("Id_Btn_SaveRoute"), "Save Route", "Nil");
					Thread.sleep(2000);
					ReusableFunction.verfyAlertBooxMsgAndAccept("You route is successfully saved!");
					
				}
				else
				{
					Report.fail("Add to my Routes pop up does not exist", "Nil", "Nil");
				}
			}
			else
			{
				Report.fail("Save Route Link does not exist", "Nil", "Nil");
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			Report.fail("Exception in saveRoute funtion: "+e, "Nil", "Nil");
		}
	}
	public static void verifySavedRoutes()
	{
		try
		{
			Thread.sleep(2000);
			String Xpath_Label_RouteName="//p[@class='p_my_route_result']/a[contains(text(),'"+Excel.Exceldata("Directions_Data", "RouteName")+"')]";
			if (ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Tab_Personal"), 30).equalsIgnoreCase("true"))
			{
				ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Tab_Personal"), "Personal Tab", "Nill");
				if (ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Tab_MyRoutes"), 30).equalsIgnoreCase("true"))
				{
					Thread.sleep(1000);
					ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Tab_MyRoutes"), "Personal Tab", "Nill");
					Thread.sleep(1000);
					if (ReusableFunction.waitByXpath(Xpath_Label_RouteName, 30).equalsIgnoreCase("true"))
					{
						Report.pass(Excel.Exceldata("Directions_Data", "RouteName") +" route is displayed successfully", "Nil", "Nil");
						ReusableFunction.screenShot(Excel.Exceldata("Directions_Data", "RouteName")+" in MyRoutes");
					}
					else
					{
						Report.fail(Excel.Exceldata("Directions_Data", "RouteName")+" Route Name does not exist", "Nil", "Nil");
					}
				}
				else
				{
					Report.fail("Personal - Sub Tabs (MyRoutes, etc) does not exist", "Nil", "Nil");
				}
			}
			else
			{
				Report.fail("Left Tabs (Directions, Personal and Live) does not exist", "Nil", "Nil");
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			Report.fail("Exception in verifySavedRoutes funtion: "+e, "Nil", "Nil");
		}
	}
	
	public static void deleteRoute()
	{
		try
		{
			String Xpath_Label_RouteName="//p[@class='p_my_route_result']/a[contains(text(),'"+Excel.Exceldata("Directions_Data", "RouteName")+"')]";
			String Xpath_DD_RouteName="//p[contains(a,'"+Excel.Exceldata("Directions_Data", "RouteName")+"')]/span";
			verifySavedRoutes();
			if (ReusableFunction.waitByXpath(Xpath_DD_RouteName, 10).equalsIgnoreCase("true"))
			{
				ReusableFunction.clickByXpath(Xpath_DD_RouteName, "Drop Arrow for the properties", "nill");
				ReusableFunction.screenShot("Route Properties");
				ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Link_Delete"), "delete Link", "Nill");
				Thread.sleep(1000);
				if (ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Btn_DelYes"), 10).equalsIgnoreCase("true"))
				{
					Report.pass("Delete pop up exist", "Nil", "Nil");
					ReusableFunction.screenShot("Delete route pop up");
					ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Btn_DelYes"), "Yes Button", "nill");
					//Thread.sleep(1000);
					ReusableFunction.verfyAlertBooxMsgAndAccept("Your route is successfully deleted!");
					Thread.sleep(1000);
					if (ReusableFunction.objectXpathNO(Xpath_Label_RouteName, "Route Name","Nill").equalsIgnoreCase("true"))
					{
						Report.pass("Deleted successfully from MyRoutes", "Nill", "nill");
						ReusableFunction.screenShot("After deleting "+Excel.Exceldata("Directions_Data", "RouteName")+" from MyRoutes");
					}
					else
					{
						Report.fail(Excel.Exceldata("Directions_Data", "RouteName")+" Route name still exist", "Nil", "Nil");
					}
				}
				else
				{
					Report.fail("Delete pop up does not exist", "Nil", "Nil");
				}
			}
			else
			{
				Report.fail("Link to delete button does not exist", "Nil", "Nil");
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			Report.fail("Exception in deleteRoute funtion: "+e, "Nil", "Nil");
		}
	}
	
	
	
	public static void getDirectionsWithDifferentChoices(String checkBoxChoice_Obj,String resultTable_Obj,String desc)
	{
		try
		{
			if (!(driver.findElement(By.id(checkBoxChoice_Obj)).isSelected()))
			{
				ReusableFunction.clickById(checkBoxChoice_Obj, desc+" checked", "Nill");
			}
			ReusableFunction.clickById(mapSynq.ReadProperty("Id_Btn_Getdirections"), "Get Directions Button", "Nill");
			if (ReusableFunction.waitByXpath(resultTable_Obj, 60).equalsIgnoreCase("true"))
			{
				Report.pass("Route is displayed for the selected location with "+desc, "Nil", "Nil");
				ReusableFunction.screenShot("Directions with "+desc);
				ReusableFunction.clickById(checkBoxChoice_Obj, desc+" uncheck", "Nill");
			}
			else
			{
				Report.fail("Routes does not exist with selected "+desc, "Nil", "Nil");
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			Report.fail("Exception in getDirectionsWithDifferentChoices funtion: "+e, "Nil", "Nil");
		}
	}
	
	public static void logout()
	{
		try
		{
			if (ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_DDLink_Logout"), 10).equalsIgnoreCase("true"))	
			{
				ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_DDLink_Logout"), "Logout Triangle Dropdown link", "nill");
				ReusableFunction.screenShot("logout Link");
				ReusableFunction.clickByXpath(mapSynq.ReadProperty("Xpath_Link_Logout"), "Logout Link", "nill");
				Thread.sleep(1000);
				if ((ReusableFunction.waitByXpath(mapSynq.ReadProperty("Xpath_Link_SignIn"), 30)).equalsIgnoreCase("true"))
				{
					Report.pass("Logout is successful", "Nil", "Nil");
					ReusableFunction.screenShot("Home Page");
				}
				else
				{
					Report.fail("Logout is not successful", "Nil", "Nil");
				}
			}
			else
			{
				Report.fail("Logout Dropdown link does not exist", "Nil", "Nil");
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			Report.fail("Exception in logout funtion: "+e, "Nil", "Nil");
		}
	}

}
