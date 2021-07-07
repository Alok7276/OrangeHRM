package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import utlity.TestUtil;

public class PimPage extends BasePage {
	
	@FindBy(id="btnAdd")
	WebElement addButton;
	@FindBy(name="firstName")
	WebElement fname;
	@FindBy(id="middleName")
	WebElement middlename;
	@FindBy(id="lastName")
	WebElement lname;
	@FindBy(id="photofile")
	WebElement pfile;
	@FindBy(id="chkLogin")
	WebElement checkbox;
	@FindBy(id="user_name")
	WebElement userName;
	@FindBy(id="user_password")
	WebElement userPassword;
	@FindBy(id="re_password")
	WebElement confPass;
	@FindBy(id="status")
	WebElement status;
	@FindBy(id="btnSave")
	WebElement saveButton;
	public PimPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public void addEmployee(String firstName,String middlName,String LastName,String uName,String uPassword,String cPassword,String text) {
	
		addButton.click();
		fname.sendKeys(firstName);
		middlename.sendKeys(middlName);
		lname.sendKeys(LastName);
		//pfile.sendKeys(photograph);
		checkbox.click();
		userName.sendKeys(uName);
		userPassword.sendKeys(uPassword);
		confPass.sendKeys(cPassword);
		TestUtil.SelectClass(text,status);
		saveButton.click();
		
		
	}
}


	
	
	
	
	
	
	
	
	


