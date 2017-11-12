package freddie.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartDemo {

	public static void main(String[] args) {
		String product = "tv";
		int searchResult = 2;
		
		// Initialize the test
		System.setProperty("webdriver.chome.driver", "C:\\HexawareTraining\\Cohort101\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://sdettraining.com/online/");
		
		// Search for product and click go
		driver.findElement(By.name("txtSearch")).sendKeys(product);
		driver.findElement(By.id("Go")).click();
		
		// Product Listing Page: Add item to cart
			// driver.findElement(By.id("btnApple_Iphone_6.jpg")).click();
			// driver.findElement(By.xpath("//*[@id=\"btnApple_Iphone_6.jpg\"]")).click();
		
		// Print the item information
		System.out.println(driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[" + searchResult + "]/td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[" + searchResult + "]/td[3]/font")).getText());
		
		// Click add to cart
		driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[" + searchResult + "]/td[3]/a/img")).click();
		
		// Proceed to checkout
		// driver.findElement(By.name("cmdSubmit")).click(); >> FAIL BECAUSE SAME NAME AS CONTINUE SEARCHING
		// driver.findElement(By.xpath("/html/body/font/form/div/input[3]")).click();
		driver.findElement(By.cssSelector("input[name='cmdSubmit'][value='Proceed to Checkout']")).click();
		
		// Fill out billing and shipping >> GET FROM SELENIUM IDE & EXPORT TO JAVA JUNIT
		driver.findElement(By.name("txtCustomerName")).clear();
	    driver.findElement(By.name("txtCustomerName")).sendKeys("Roger");
	    driver.findElement(By.name("txtAddress")).clear();
	    driver.findElement(By.name("txtAddress")).sendKeys("123 Main St");
	    driver.findElement(By.name("txtCity")).clear();
	    driver.findElement(By.name("txtCity")).sendKeys("Miami");
	    driver.findElement(By.name("txtState")).clear();
	    driver.findElement(By.name("txtState")).sendKeys("FL");
	    driver.findElement(By.name("txtZIP")).clear();
	    driver.findElement(By.name("txtZIP")).sendKeys("32123");
	    driver.findElement(By.name("txtPhone")).clear();
	    driver.findElement(By.name("txtPhone")).sendKeys("1231231234");
	    driver.findElement(By.name("optPaymentType")).click();
	    driver.findElement(By.name("txtAcctNo")).clear();
	    driver.findElement(By.name("txtAcctNo")).sendKeys("4123123412341234");
	    driver.findElement(By.name("txtCVV2No")).clear();
	    driver.findElement(By.name("txtCVV2No")).sendKeys("123");
	    driver.findElement(By.name("txtExpDate")).clear();
	    driver.findElement(By.name("txtExpDate")).sendKeys("10/2020");
	    driver.findElement(By.name("txtshipCustomerName")).clear();
	    driver.findElement(By.name("txtshipCustomerName")).sendKeys("Roger");
	    driver.findElement(By.name("txtshipAddress")).clear();
	    driver.findElement(By.name("txtshipAddress")).sendKeys("123 Main St");
	    driver.findElement(By.name("txtshipCity")).clear();
	    driver.findElement(By.name("txtshipCity")).sendKeys("Miami");
	    driver.findElement(By.name("txtshipState")).clear();
	    driver.findElement(By.name("txtshipState")).sendKeys("FL");
	    driver.findElement(By.name("txtshipZIP")).clear();
	    driver.findElement(By.name("txtshipZIP")).sendKeys("32123");
	    driver.findElement(By.name("txtshipPhone")).clear();
	    driver.findElement(By.name("txtshipPhone")).sendKeys("1231231234");
	    
	    // Print confirmation
		String confirmation = driver.findElement(By.xpath("/html/body/font")).getText();
	}

}
