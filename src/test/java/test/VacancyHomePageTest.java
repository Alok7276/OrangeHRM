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
import Page.Vacancies;
import utlity.TestUtil;

public class VacancyHomePageTest {
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public Vacancies vacancyPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		vacancyPage = homePage.gotoVacancy();
	}

	@DataProvider(name = "getVacancyData")
	public Object[][] getCandidatesTestData() {
		Object vacancyData[][] = TestUtil.getTestData("vacancy");
		return vacancyData;
	}

	@Test(dataProvider = "getVacancyData")
	public void createVacancyTest(String jobtitle, String Vname,String hmanager, String npostion) {
		vacancyPage.addVacancy(jobtitle,Vname,hmanager,npostion);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}