package com.Airpay.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Airpay.BusinessLogic.AirPay_MA_Panel_Select_Merchant_BusinessLogic;
import com.Airpay.InitialSetup.Driver_Setup;
import com.Airpay.PageObject.AirPay_Payment_MA_Panel_PageObject;
import com.Airpay.Utilities.Log;

public class TC_Verify_Make_one_successful_transaction_with_applied_convenience_fee_pg extends Driver_Setup{
	public static WebDriver webDriver = null;
	public static String tcID = null;	
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
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MA_MerchantSettingLink);
			MA_panel.VerifyText(AirPay_Payment_MA_Panel_PageObject.MA_MerchantSurchageRule, "accounts details");
			MA_panel.GetTextButNotCompare(AirPay_Payment_MA_Panel_PageObject.MA_MerchantMCCName);
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MA_HomeMenu);			
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MasterMenu_NextBtn);						
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MM_SurChargeMenuLink);
			MA_panel.VerifyText(AirPay_Payment_MA_Panel_PageObject.MM_GlobalSurchargeRules, "global surcharge rules");
			MA_panel.CLickbtn(AirPay_Payment_MA_Panel_PageObject.MA_AdvanceSerchBtn, "Advance Search");
			MA_panel.AdvancesearchDropDown();
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MA_FilterSearchBtn);

			
			
			
			
			
			
			
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MA_AssignSurchargeRuleLink);	
			
			MA_panel.GetTextFromWeb(AirPay_Payment_MA_Panel_PageObject.FetchExistFirstRule);
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.MA_AddNewRuleBtn);
			MA_panel.VerifyText(AirPay_Payment_MA_Panel_PageObject.MA_MerchantSurchageRule, "Add merchant surcharge rule");
			MA_panel.VerifyText(AirPay_Payment_MA_Panel_PageObject.MM_ConvenienceFeeField, "Convenience Fee");
			MA_panel.NewRuleAddMerchantDetails();
			MA_panel.Home_LHS_Dashboard(AirPay_Payment_MA_Panel_PageObject.SurchargeSubmitBtn);
			MA_panel.DuplicateRuleNameErrorExist("Rule added successfully");
			MA_panel.MerchantRuleCreatedVerifyTest();
			MA_panel.Verify_Surchagre_Button(AirPay_Payment_MA_Panel_PageObject.MM_SurchagreCheckbxColor);
		   	MA_panel.Verify_Surchagre_OFFVerify(AirPay_Payment_MA_Panel_PageObject.MM_SurchagreCheckbxColor);
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
