package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class LoginPage extends BasePage {
	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//img[@src='/webres_6051af48107ce6.31500353/themes/default/images/login/logo.png']")
	private WebElement Logo;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Login;
	@FindBy(id="welcome")
	private WebElement welcome;
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logout;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String LoginTitle() {

		return driver.getTitle();

	}

	public boolean LoginLogo() {
		return Logo.isDisplayed();

	}

	public HomePage Login(String User, String Pass) {
		username.sendKeys(User);
		password.sendKeys(Pass);
		Login.click();

		return new HomePage(driver);

	}
	
}
