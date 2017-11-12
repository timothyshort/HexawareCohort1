package freddie.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	// This function returns a driver
	public static WebDriver start(String browserType) {
		WebDriver driver;
		
		if (browserType.toUpperCase().equals("IE")) {
			System.setProperty("webdriver.ie.driver", GlobalSettings.driverDirectory + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", GlobalSettings.driverDirectory + "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", GlobalSettings.driverDirectory + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		// Maximize window
		// driver.manage().window().maximize();
		
		// Define the timeout or default wait
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}
	
	// This function returns a driver
	public static WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "C:\\HexawareTraining\\Cohort101\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Maximize window
		driver.manage().window().maximize();
		
		// Define the timeout or default wait
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		return driver;
	}

}
