package freddie.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
	
	// This method receives a checkbox value and checkbox element and performs algorithm to check or uncheck
	public static void choose(WebDriver driver, boolean checkBox, WebElement checkboxElement) {
		// Do we want the checkbox checked?
		if (checkBox) {
			// Is the checkbox not checked?
			if (!checkboxElement.isSelected()) {
				checkboxElement.click();
			}
		}
		else {
			if (checkboxElement.isSelected()) {
				checkboxElement.click();
			}
		}
	}
	
}
