package test;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.HomePage;
import Page.LoginPage;

public class LoginTest {

	public LoginPage loginPage;

	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public HomePage homePage;

	@BeforeMethod
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_properties();// init prop

		String browser = prop.getProperty("browser");// chrome
		driver = basePage.init_driver(browser);// init browser
		driver.get(prop.getProperty("url"));// url
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void logoTest() {

		boolean logo = loginPage.LoginLogo();
		Assert.assertTrue(logo);
	}

	@Test(priority = 2)
	public void loginPageTitleTest() {
		String title = loginPage.LoginTitle();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Test(priority = 3)
	public void doLoginTest() {

		loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}



	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
