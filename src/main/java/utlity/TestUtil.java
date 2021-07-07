package utlity;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestUtil {

	public static final String TESTDATA_SHEET_PATH = "E:\\Automation\\NewSeleniumPom\\src\\main\\java\\testdata\\OrangeHRMTestData.xlsx";
	public static Workbook book;
	public static Sheet sheet;

	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			// TODO: handle exception
		}
		sheet = book.getSheet(sheetName);
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
	public static void SelectClass(String text,WebElement element) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
		
		
	
	
		
	}
	
}
