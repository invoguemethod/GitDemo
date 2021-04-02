package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class LandingPage {

	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	//Simplifying web element locators to a single word
	
	By popup = By.xpath("//button[text()= 'NO THANKS']");
	//This is for an unpredictable pop-up that sometimes comes on screen at this point
	
	
	
	public LandingPage(WebDriver driver) 
	{
		//Method is the same name as class, therefore it is a constructor
		//This is needed to pass the driver created in "base" to here. And then make it the local driver as well
		this.driver=driver;
	}




	public LoginPage getLogin()
	{
		 driver.findElement(signin).click();
		 LoginPage lp=new LoginPage(driver);
		 return lp; 
		//This is a centralised getLogin() method so we can easily call it in our tests
	}
	
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	
	
	
	public List<WebElement> getPopUpSize()
	{
		return driver.findElements(popup);
	}
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
	
	
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	
	
}
