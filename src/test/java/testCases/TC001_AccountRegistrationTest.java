package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"Regression","Master"})
	public void Verify_accoun_Registration() throws InterruptedException
	{
		logger.info("******starting TC001_AccountRegistrationTest*******");
		try
		{
		HomePage hp= new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on myaccount");
		hp.ClickRegister();
		logger.info("Clicked on register");
		AccountRegistrationPage ARP= new AccountRegistrationPage(driver);
	logger.info("Providing customer details");
		ARP.setFirstName(randomString().toUpperCase());
		ARP.setsecondName(randomString().toUpperCase());
		ARP.setemail(randomString()+"@gmail.com");
		ARP.setTelephone(randomNumber());
		
		String Pswd=randomalphanumeric();
		
		ARP.setPassword(Pswd);
		ARP.setConfirmPassword(Pswd);
		ARP.setPrivacyPolicy();
		ARP.clickContinue();
		
		
		Thread.sleep(2000);
		
		logger.info("Validating expected message");
		String confmsg=ARP.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		}
		catch (Exception e)
		{
			
			Assert.fail();
			
		}
		logger.info("****Test finished*****");
	}
	
	
	
	
}
