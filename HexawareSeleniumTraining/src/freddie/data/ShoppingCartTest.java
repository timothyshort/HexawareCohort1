package freddie.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import freddie.utilities.DriverFactory;
import freddie.utilities.GlobalSettings;
import freddie.utilities.XML;

public class ShoppingCartTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.start();
		driver.get(GlobalSettings.SHOPPINGCARTURL);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(dataProvider = "shoppingCartData")
	public void test(String product, String itemResult, String qty, String name, String address, String city) {
		// Search for product and click go
		driver.findElement(By.name("txtSearch")).sendKeys(product);
		driver.findElement(By.id("Go")).click();
		
		// Print the item information
		System.out.println(driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[" + itemResult + "]/td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[" + itemResult + "]/td[3]/font")).getText());
		
		// Click add to cart
		driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[" + itemResult + "]/td[3]/a/img")).click();
		
		// Update quantity
		driver.findElement(By.name("txtItemQty1")).clear();
		driver.findElement(By.name("txtItemQty1")).sendKeys(qty);
		
		// Proceed to checkout
		driver.findElement(By.cssSelector("input[name='cmdSubmit'][value='Proceed to Checkout']")).click();
		
		// Fill out billing and shipping >> GET FROM SELENIUM IDE & EXPORT TO JAVA JUNIT
	    driver.findElement(By.name("txtCustomerName")).sendKeys(name);
	    driver.findElement(By.name("txtAddress")).sendKeys(address);
	    driver.findElement(By.name("txtCity")).sendKeys(city);
	}
	
	@DataProvider
	public Object[][] shoppingCartData() {
		return XML.get(GlobalSettings.TESTDATA + "ShoppingCartData.xml");
	}

}
