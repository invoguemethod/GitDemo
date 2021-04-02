package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

public class stepDefinition extends base {
//Even for stepDefinition, we need to extend base so we can use driver
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		 driver =initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
		driver.get(arg1);
		//When we were NOT using the Cucumber framework, we had to take values from a ".properties" file
		//But now we can put values directly into the ".feature" file and send it to here are an argument
	}

	@Given("^Click on Login link in home page to land on Secure sign in Page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() throws Throwable {
		
		LandingPage l=new LandingPage(driver);
		if(l.getPopUpSize().size()>0)
			//This is to check for the unpredictable pop up
		{
			l.getPopUp().click();
			//This will be to say to click on the "NO THANKS" on the pop up
		}
		l.getLogin().click(); 
		//driver.findElement(By.css() 
	}

	

	@Then("^Verify that user is succesfully logged in$")
	public void verify_that_user_is_succesfully_logged_in() throws Throwable {
	    
		portalHomePage p = new portalHomePage(driver);
      Assert.assertTrue(p.getSearchBox().isDisplayed());
      //Checking if the searchBox is displayed on web page
	}
	
	
	
	@When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		//In "HomePage" we had to use TestNG data provider to get the data. But with Cucumber we can take from feature file
		LoginPage lp=new LoginPage(driver);
			lp.getEmail().sendKeys(username);
			lp.getPassword().sendKeys(password);
	        lp.getLogin().click();
	    }
	 @And("^close browsers$")
	    public void close_browsers() throws Throwable {
	        driver.quit();
	    }
	

}




