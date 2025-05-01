package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_secondname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_tel;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_pwd;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_confrimPwd;
	@FindBy(xpath="//input[@name='agree']")
	WebElement Chkdpolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement BtnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement MsgConfirmation;
	
	public void setFirstName(String fname)
	{
		txt_firstname.sendKeys(fname);
	}
	public void setsecondName(String lname)
	{
		txt_secondname.sendKeys(lname);
	}
	public void setemail(String email)
	{
		txt_email.sendKeys(email);
	}
	public void setTelephone(String tel)
	{
		txt_tel.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		txt_pwd.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txt_confrimPwd.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		Chkdpolicy.click();
	}
	
	public void clickContinue()
	{
		BtnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return (MsgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
		
	}
}

