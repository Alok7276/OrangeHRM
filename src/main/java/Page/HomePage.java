package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;
import utlity.TestUtil;

public class HomePage extends BasePage {
	@FindBy(xpath = "//a[.='Recruitment']")
	private WebElement recruitment;

	@FindBy(xpath = "//a[.='Candidates']")
	private WebElement candidates;

	@FindBy(id = "btnAdd")
	private WebElement add;

	@FindBy(id = "addCandidate_firstName")
	private WebElement firstname;

	@FindBy(id = "addCandidate_lastName")
	private WebElement lastname;

	@FindBy(id = "addCandidate_email")
	private WebElement email;

	@FindBy(id = "addCandidate_middleName")
	private WebElement mname;
	@FindBy(id = "addCandidate_contactNo")
	private WebElement contactno;
	@FindBy(id = "addCandidate_resume")
	private WebElement resume;
	@FindBy(id="addCandidate_vacancy")
	private WebElement listbox;
	@FindBy(id="welcome")
	private WebElement welcome;
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logout;
	@FindBy(xpath="//a[.='PIM']")
	WebElement pim;
	@FindBy(xpath="//a[.='Employee List']")
	WebElement employeList;

	@FindBy(id = "btnSave")
	private WebElement saveBtn;
	@FindBy(xpath="//a[.='Vacancies']")
	private WebElement vacancies;
	@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']")
	private WebElement admin;
	@FindBy(xpath="//a[.='User Management']")
	private WebElement umanagement;
	@FindBy(xpath="//a[.='Users']")
	private WebElement user;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String homePageTitle() {

		return driver.getTitle();

	}
	//
	// public void clickonCandidate() {
	// TestUtil.mouseHover(driver, recruitment);
	// candidates.click();
	// // add.click();
	// }
	//
	// public void addCandidates() {
	// add.click();
	// }

	public void createCandidate(String fName, String mName, String lName, String emailId, String cNo,String text, String doc)
		 {
		TestUtil.mouseHover(driver, recruitment);
		candidates.click();
		add.click();
		firstname.sendKeys(fName);
		mname.sendKeys(mName);
		lastname.sendKeys(lName);
		email.sendKeys(emailId);
		contactno.sendKeys(cNo);
		 TestUtil.SelectClass(text,listbox);
		resume.sendKeys(doc);
      
		saveBtn.click();

	}
	// public void SelectClassHomePage(String val) {
	// TestUtil.SelectClass(val,select);
	//
	// }
    public Vacancies gotoVacancy() {
    	TestUtil.mouseHover(driver, recruitment);
    	vacancies.click();
		return new Vacancies(driver);
		}
    public  LoginPage logoutLoginPage() {
		welcome.click();
		logout.click();
		return new LoginPage(driver);
		
	}
    public PimPage goToEmployeList() {
    	TestUtil.mouseHover(driver,pim);
    	employeList.click();
		return new PimPage(driver);
    }
    public UserPage goTouserPage() {
    	TestUtil.mouseHover(driver, admin);
    	TestUtil.mouseHover(driver, umanagement);
    	user.click();
    	return new UserPage(driver);
    
    }

}
