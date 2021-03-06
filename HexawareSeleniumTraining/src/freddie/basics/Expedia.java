package freddie.basics;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import freddie.utilities.DriverFactory;
import freddie.utilities.Screenshot;

public class Expedia {
	
	@Test
	public void reservationTest() throws InterruptedException {
		String month = "Dec";
		String dayS = "22";
		String yearS = "2017";
		// Convert String to int
		int dayNum = Integer.parseInt(dayS);
		int year = Integer.parseInt(yearS);
		
		WebDriver driver = DriverFactory.start();
		driver.get("https://www.expedia.com/");
		
		// driver.findElement(By.id("package-departing-hp-package")).sendKeys("12/10/2017");
		
		// TAKE SCREENSHOT
		Screenshot.snap(driver, "Expedia-01");
		
		// 1. Click on the Date field to open the DatePicker
		driver.findElement(By.id("package-departing-hp-package")).click();
		
		// 2. Select the month
		String currentDate = driver.findElement(By.xpath("//*[@id=\"package-departing-wrapper-hp-package\"]/div/div/div[2]/table/caption")).getText();
		String currentYear = currentDate.substring(4);
		String currentMonth = currentDate.substring(0,3);
		int yearChange = year - Integer.parseInt(currentYear);
		chooseMonth(driver, currentMonth, month, yearChange);
		
		// TAKE SCREENSHOT
		Screenshot.snap(driver, "Expedia-02");
		
		// 3. Generate ALL of the dates as web elements and click on the one that matches what we want
		List<WebElement> dates = driver.findElements(By.className("datepicker-cal-date"));
		dates.get(dayNum-1).click();
		
		// TAKE SCREENSHOT
		Screenshot.snap(driver, "Expedia-03");
		
		/*
		for (WebElement date : dates) {
			// System.out.println(date.getText());
			if (date.getText().equals(day)) {
				date.click();
				break;
			}
		}
		*/
	}
	
	public void chooseMonth(WebDriver driver, String currentMonth, String desiredMonth, int yearChange) throws InterruptedException {
		// write algorithm to figure out how many months to advance (how many times to click the Next Month button)
		int currentM = monthToNum(currentMonth);
		int desiredM = monthToNum(desiredMonth);
		
		// assume month is in same year
		int monthChange = desiredM - currentM;
		if (desiredM < currentM) {
			monthChange = desiredM - currentM;
		}
		// add the number of years as months
		monthChange = monthChange + (12*yearChange);
		
		// click on "next month" for as many times as we determined
		for (int i = 1; i<= monthChange; i++) {
			driver.findElement(By.xpath("//*[@id=\"package-departing-wrapper-hp-package\"]/div/div/button[2]")).click();
			Thread.sleep(100);
		}
	}
	
	private int monthToNum(String month) {
		switch (month) {
			case "Jan" : return 1;
			case "Feb" : return 2;
			case "Mar" : return 3;
			case "Apr" : return 4;
			case "May" : return 5;
			case "Jun" : return 6;
			case "Jul" : return 7;
			case "Aug" : return 8;
			case "Sep" : return 9;
			case "Oct" : return 10;
			case "Nov" : return 11;
			default : return 12;
		}
	}

}
