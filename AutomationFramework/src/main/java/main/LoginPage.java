package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author -- Aditya Shinde Java + Selenium 14-Sep-2023 5:50:20 pm
 **/
public class LoginPage extends BaseTest{
	
	@FindBy(name = "username")
	WebElement userNameField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@class='orangehrm-login-forgot']//p")
	WebElement forgetPasswordLink;
	
	@FindBy(xpath="//*[text()='OrangeHRM, Inc']")
	WebElement orangeHRMLink;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
