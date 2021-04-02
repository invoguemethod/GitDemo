package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//rahulonlinetutor@gmail.com
public class portalHomePage {

	public WebDriver driver;
	By searchBox = By.name("query");
	//Define searchBox object
	
	public portalHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}

}
