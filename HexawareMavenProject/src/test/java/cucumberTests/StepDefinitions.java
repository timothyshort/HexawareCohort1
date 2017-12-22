package cucumberTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinitions {
	WebDriver driver;
	
	@Given("^the user navigates to our home page$")
	public void the_user_navigates_to_our_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\HexawareTraining\\Cohort101\\Software\\" + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://sdettraining.com/projects/");
	}

	@Then("^the user should see the message$")
	public void the_user_should_see_the_message() throws Throwable {
	    System.out.println(driver.findElement(By.xpath("html/body")).getText());
	}

}
