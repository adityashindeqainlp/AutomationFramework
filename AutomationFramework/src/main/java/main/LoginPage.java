package main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

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
	
	@FindBy(css = "div[class='oxd-alert oxd-alert--error'] p")
	WebElement errorMsg;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String urlValidation(String urlFromUser) {
		
		String urlFromBuild = driver.getCurrentUrl();
		Assert.assertEquals(urlFromBuild, urlFromUser);
		return urlFromBuild;
		
	}
	
	public String titleValidation(String titleFromUser) {
		
		String titleFromBuild = driver.getTitle();
		Assert.assertEquals(titleFromBuild, titleFromUser);
		return titleFromBuild;
		
	}
	
	public void loginValidationUsingPositiveData(String username , String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
		
	}
	
	public String loginValidationUsingNegativeData(String username , String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
		
		String msgFromBuild = errorMsg.getText();
		Assert.assertEquals(msgFromBuild, "Invalid credentials");
		return msgFromBuild;
		
	}

}
