package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email, String Pwd, String exp)
	{
	logger.info("********TC003_LoginDDT started********");
	System.out.println("Testing login with Email: " + email + ", Password: " + Pwd + ", Expected: " + exp);
	try
	{
			HomePage hp=new HomePage(driver);
			hp.ClickMyAccount();
			hp.clickLogin();
			//Login
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(Pwd);
		lp.clickLogin();
		//MyAccountPage
		MyAccountPage MACC=new MyAccountPage(driver);
		boolean TargetPage=MACC.isMyAccountPageExists();
		if(exp.equalsIgnoreCase("valid"))
		{
			if (TargetPage==true)
			{
				MACC.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
			if(exp.equalsIgnoreCase("invalid"))
			{
				if (TargetPage==true)
				{
					
					MACC.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
	}catch(Exception e)
	{
		Assert.fail();
	}
		logger.info("*****TC003_LoginDDT Ended*****" );
	}

}
