package com.Airpay.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Airpay.BusinessLogic.AirPay_PaymentPage_BusinessLogic;
import com.Airpay.BusinessLogic.AirPay_Payment_Mode_CreditCard_BusinessLogic;
import com.Airpay.BusinessLogic.AirPay_Payment_Mode_Debit_Card_BusinessLogic;
import com.Airpay.InitialSetup.Driver_Setup;
import com.Airpay.PageObject.Airpay_PaymentPage_PageObject;
import com.Airpay.Utilities.Log;

public class TC_PP_09_Debit_Card extends Driver_Setup{
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
			AirPay_PaymentPage_BusinessLogic AirPay_Local = new AirPay_PaymentPage_BusinessLogic(driver, TC_ID);
			AirPay_Payment_Mode_CreditCard_BusinessLogic CreditCard = new AirPay_Payment_Mode_CreditCard_BusinessLogic(driver, TC_ID);
			AirPay_Payment_Mode_Debit_Card_BusinessLogic DebitCard = new AirPay_Payment_Mode_Debit_Card_BusinessLogic(driver, TC_ID);	
				AirPay_Local.LocalHostDetailPage_ErrorVerify();	
				AirPay_Local.Verify_PaymentPageFields();
				AirPay_Local.Card_Details_Options();
				DebitCard.Debit_cardProvidingValues();	
				CreditCard.CaseSensitiveValidation(Airpay_PaymentPage_PageObject.DebitCardNoInput,"[^'a-zA-Z ]");	
				CreditCard.Credit_CardCVVRedError(Airpay_PaymentPage_PageObject.DebitCardCVVCode,Airpay_PaymentPage_PageObject.DebitCardMakePaymtBtn);
				CreditCard.Credit_CardExpiryDateErrorRedLine(Airpay_PaymentPage_PageObject.DebitCardExpDate,Airpay_PaymentPage_PageObject.DebitCardMakePaymtBtn);				
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