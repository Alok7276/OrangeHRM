package test;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.HomePage;
import Page.LoginPage;
import utlity.TestUtil;

public class HomePageTest {
	public HomePage homepage;

	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public LoginPage loginpage;

	@BeforeMethod
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_properties();// init prop

		String browser = prop.getProperty("browser");// chrome
		driver = basePage.init_driver(browser);// init browser
		driver.get(prop.getProperty("url"));// url
		loginpage = new LoginPage(driver);
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 2)
	public void homePageTitle() {
		String title = homepage.homePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");

	}
	// @Test(priority=2)
	// public void clickOnAddButton() {
	// homepage.clickonCandidate();
	// homepage.addCandidates();
	// }

	@DataProvider(name = "getCandidatesData")
	public Object[][] getCandidatesTestData() {
		Object candidatesData[][] = TestUtil.getTestData("candidates");
		return candidatesData;
	}

	@Test(dataProvider = "getCandidatesData")
	public void createCandiadtesTest(String firstName, String middleName, String lastName, String emailId, String cNo,
			String jobVacancy, String doc){

		//homepage.SelectClassHomePage("Junior Account Assistant");
		homepage.createCandidate(firstName, middleName, lastName, emailId,cNo, jobVacancy, doc);
		//homepage.createCandidate(prop.getProperty(String firstName, String middleName, String lastName, String emailId, String cNo,string jobVacancy,string doc);
	}
	
	@Test(priority=1)
	public void doLoginTest() {

		homepage.logoutLoginPage();
	}

	


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
