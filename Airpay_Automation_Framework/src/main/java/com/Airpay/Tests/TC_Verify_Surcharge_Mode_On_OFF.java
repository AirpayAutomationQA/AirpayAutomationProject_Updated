package com.Airpay.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Airpay.BusinessLogic.AirPay_MA_Panel_Select_Merchant_BusinessLogic;
import com.Airpay.InitialSetup.Driver_Setup;
import com.Airpay.PageObject.AirPay_Payment_MA_Panel_PageObject;
import com.Airpay.TestData.Excel_Handling;
import com.Airpay.Utilities.Log;

public class TC_Verify_Surcharge_Mode_On_OFF extends Driver_Setup{
	public static WebDriver webDriver = null;
	public static String tcID = null;
	public static String FlagValue="";
	//Business Logic Class Object list	
	@Test(priority=1)
	public void setup()
	{
		Log.info("Setup the variable for Test");
		webDriver = driver; 
		tcID = TC_ID;
		Log.info("Setup completed for the variable");
	}
	@Test(priority = 2)
	public void TC_TestCaseName() throws Throwable {
		try {
			Log.info("Script Starts..");
			AirPay_MA_Panel_Select_Merchant_BusinessLogic MA_panel = new AirPay_MA_Panel_Select_Merchant_BusinessLogic(driver, TC_ID);
				
			MA_panel.MA_Panel_Login();
			MA_panel.Select_Merchant();
			MA_panel.Filter_Merchant();
			MA_panel.Choose_Merchant();		
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MA_HomeMenu);
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MerchantMember_NextBtn);
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MM_Airpay_SettingNextBtn);
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MM_Airpay_Setting);
			MA_panel.VerifyText(AirPay_Payment_MA_Panel_PageObject.MM_SaveCardFieldName, "Save Card Checked");
		    FlagValue= MA_panel.Verify_SurchargeFlag_Mode(AirPay_Payment_MA_Panel_PageObject.MM_ONOFFCheckBoxSurchargeFlag);		   
		    if(FlagValue.contains("OFF"))
		    {
		    	Excel_Handling.Put_Data_Replace(TC_ID, "Surcharge_Mode","OFF");
		    }
		    else{
		    	Excel_Handling.Put_Data_Replace(TC_ID, "Surcharge_Mode","ON");

		    }
			Log.info("Scripts Ends....");
		} catch (Exception e) {
			Log.error(e.getMessage());
			System.out.println(e);
		}
	}
	@AfterTest
	public void tearDown()
	{
		if(webDriver != null)
			webDriver.close();
	}
}