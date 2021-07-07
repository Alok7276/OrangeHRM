package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import utlity.TestUtil;

public class Vacancies extends BasePage {
	@FindBy(id = "btnAdd")
	private WebElement addBtn;

	@FindBy(xpath = "//select[@id='addJobVacancy_jobTitle']")
	private WebElement jobTitle;

	@FindBy(id = "addJobVacancy_name")
	private WebElement vacancyName;

	@FindBy(id = "addJobVacancy_hiringManager")
	private WebElement hiringManager;

	@FindBy(id = "addJobVacancy_noOfPositions")
	private WebElement noOfPosition;

	@FindBy(id = "addJobVacancy_description")
	private WebElement description;

	@FindBy(id = "btnSave")
	private WebElement saveBtn;

	public Vacancies(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addVacancy(String job, String vacancy, String manager, String position) {
		addBtn.click();
		TestUtil.SelectClass(job, jobTitle);
		jobTitle.sendKeys(job);
		vacancyName.sendKeys(vacancy);
		hiringManager.sendKeys(manager);
		noOfPosition.sendKeys(position);
		//description.sendKeys(desc);
		saveBtn.click();
	}
}