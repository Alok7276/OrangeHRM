package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import utlity.TestUtil;

public class UserPage extends BasePage {
	@FindBy(xpath = "//input[@value='Add']")
	private WebElement addButton;
	@FindBy(xpath = "//select[@id='systemUser_userType']")
	private WebElement userrole;
	@FindBy(xpath = "//input[@value='Type for hints...']")
	private WebElement ename;
	@FindBy(xpath= "//input[@id='systemUser_userName']")
	private WebElement userName;
	@FindBy(xpath= "//select[@id='systemUser_status']")
	private WebElement status;
	@FindBy(xpath= "//input[@id='systemUser_password']")
	private WebElement password;
	@FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
	private WebElement confirmPass;
	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement saveButton;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addUser(String text1, String eName, String uName, String text2, String psd, String cPass) throws InterruptedException {
		addButton.click();
		TestUtil.SelectClass(text1, userrole);
		ename.sendKeys(eName);
		userName.sendKeys(uName);
		TestUtil.SelectClass(text2, status);
		password.sendKeys(psd);
		confirmPass.sendKeys(cPass);
		saveButton.click();
		Thread.sleep(5000);
	}

}
