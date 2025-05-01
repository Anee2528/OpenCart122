package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****** starting TC002_LoginTest******");
		try
		{
		//Home
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.clickLogin();
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	//MyAccountPage
	Thread.sleep(2000);
	MyAccountPage MACC=new MyAccountPage(driver);
	boolean TargetPage=MACC.isMyAccountPageExists();
	Assert.assertTrue(TargetPage);
	
		}
		catch(Exception e)
		{
			Assert.fail(); 
		}
		logger.info("******TC002_LoginTest Completed******");
	}

}

