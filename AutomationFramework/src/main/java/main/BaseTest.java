package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.javadoc.doclet.Reporter;

/**
 * @Author -- Aditya Shinde Java + Selenium 14-Sep-2023 5:27:54 pm
 **/
public class BaseTest extends Base {

	@BeforeSuite
	public void launchBrowser() throws IOException {

		FileInputStream fis = new FileInputStream(".\\Resource\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	}

	@BeforeClass
	public void pageObjects() {

		loginPage = new LoginPage(driver);
		dashboard = new Dashboard(driver);

	}

	@AfterSuite
	public void tearDown() {

		driver.quit();
	}

}
