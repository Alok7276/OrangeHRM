package test;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.HomePage;
import Page.LoginPage;
import Page.PimPage;

public class PimPageTest {
	public HomePage homepage;

	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public LoginPage loginpage;
	public PimPage pimPage;
	
	@BeforeMethod
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_properties();// init prop

		String browser = prop.getProperty("browser");// chrome
		driver = basePage.init_driver(browser);// init browser
		driver.get(prop.getProperty("url"));// url
		loginpage = new LoginPage(driver);
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
       pimPage= homepage.goToEmployeList();

}
	@Test()
	public void addEmployeeTest( ) {
		pimPage.addEmployee("Alok","Kumar","sharma","AlokKumar","Alok@1990","Alok@1990","Disabled");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
