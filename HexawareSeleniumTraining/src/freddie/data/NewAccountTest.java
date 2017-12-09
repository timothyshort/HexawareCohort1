package freddie.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import freddie.utilities.Checkbox;
import freddie.utilities.DriverFactory;
import freddie.utilities.Excel;
import freddie.utilities.GlobalSettings;

public class NewAccountTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.start();
		driver.get(GlobalSettings.AMSWebURL);
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(dataProvider = "getxlData")
	public void test(String firstName, String lastName, String gender, String email, String password, String phoneNumber, String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		
		String name = firstName + " " + lastName;
		String verifyPassword = password;
		
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(name);
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys(phoneNumber);
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(verifyPassword);
		
		// Radio Button >> click
		if (gender.equalsIgnoreCase("female")) {
			driver.findElement(By.id("MainContent_Female")).click();
		}
		else if (gender.equalsIgnoreCase("male")) {
			driver.findElement(By.id("MainContent_Male")).click();
		}
		
		// Define checkboxes as Web Elements
		WebElement weeklyEmailCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement monthlyEmailCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement occasionalEmailCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		
		// Call the checkbox algorithm function
		Checkbox.choose(driver, weeklyEmail, weeklyEmailCheckbox);
		Checkbox.choose(driver, monthlyEmail, monthlyEmailCheckbox);
		Checkbox.choose(driver, occasionalEmail, occasionalEmailCheckbox);

	}
	
	@DataProvider
	public Object[][] getxlData() {
		// return Excel.getXLSX(GlobalSettings.TESTDATA + "NewAccountData.xlsx");
		return Excel.getXLS(GlobalSettings.TESTDATA + "NewAccountData_XLS.xls");
	}

}
