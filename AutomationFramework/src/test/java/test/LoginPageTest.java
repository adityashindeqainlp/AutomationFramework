package test;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.Test;

import main.BaseTest;
import main.LoginPage;

/**
 * @Author -- Aditya Shinde Java + Selenium 15-Sep-2023 4:33:28 pm
 **/
public class LoginPageTest extends BaseTest {

	@Test(priority = 0)
	public void validateUrlOfPage() {

		loginPage.urlValidation("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Reporter.log("Url is matching and Test Case Pass", true);
		System.out
				.println(loginPage.urlValidation("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
	}

	@Test(priority = 1)
	public void validateTitleOfPage() {

		loginPage.titleValidation("OrangeHRM");
		Reporter.log("Title is matching and Test case pass", true);
		System.out.println(loginPage.titleValidation("OrangeHRM"));

	}

	@Test(priority = 2)
	public void validateLoginWithPositiveData() {
		loginPage.loginValidationUsingPositiveData("Admin", "admin123");
		dashboard.validateTitle("Dashboard");
		Reporter.log("Title is Matching and Test case pass", true);
		System.out.println(dashboard.validateTitle("Dashboard"));

		dashboard.validateLogout();

	}
	
	@Test(priority = 3)
	public void validateLoginWithNegativeData() {
		
		loginPage.loginValidationUsingNegativeData("xyz", "1234");
		Reporter.log("Error msg display test case pass " , true);
		System.out.println(loginPage.loginValidationUsingNegativeData("xyz", "1234"));
	}

}
