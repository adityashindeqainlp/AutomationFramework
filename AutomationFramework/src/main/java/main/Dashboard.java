package main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @Author -- Aditya Shinde Java + Selenium 15-Sep-2023 5:13:25 pm
 **/
public class Dashboard extends BaseTest {

	@FindBy(xpath = "//*[@class='oxd-topbar-header-breadcrumb']//h6")
	WebElement titleOfDashboard;

	@FindBy(xpath = "//*[@class='oxd-userdropdown-tab']")
	WebElement dropDown;
	
	@FindBy(xpath = "//*[text()='Logout']")
	WebElement logoutBtn;
	
	
	
	public Dashboard(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String validateTitle(String titleFromUser) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String titleFromBuild = titleOfDashboard.getText();
		Assert.assertEquals(titleFromBuild, titleFromUser);
		return titleFromBuild;
	}
	
	public void validateLogout() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dropDown.click();
		logoutBtn.click();
	}
	
	
	
}
