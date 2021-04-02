package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	//Extends means we can inherit all the methods from "base"
	//This will allow us to call the driver "initializeDriver()" method
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	
	 
	 
	 @BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
		 //So the passed driver is now the local one as well
	}
	
	
	 
	 @Test(dataProvider="getData")
	 		//The data we want to use for our test is called from the DataProvider method below
	public void basePageNavigation(String Username,String Password,String text) throws IOException
			//We have 3 Strings here as we are expecting 3 values from the data provider below
	{
		
		driver.get(prop.getProperty("url"));
		//As we never want to hard code anything in an actual test
		LandingPage l=new LandingPage(driver);
		//Creates object "l" so we can use the methods from the "LandingPage". Also passes the driver to the LandingPage
		LoginPage lp=l.getLogin(); 
		//"getLogin()" is a method on the LandingPage that returns a LoginPage object!!!
		
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		//Send keys to text box
		log.info(text);
		
		lp.getLogin().click();
		ForgotPassword fp= lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
	}

	 
	 
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	
	
	@DataProvider
	public Object[][] getData()
		//The return type is array, in other words "Object[][]"
	{
		//Row stands for how many different data types test should run
		//Column stands for how many values per each test
		
		// Array size is 2. There are 3 values needed per test. There are 2 tests here
		// 0,1
		Object[][] data=new Object[2][3]; //Not indexes like you might think, but 2 columns, 3 rows, so its[2][3]
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restrcited User";
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		data[1][2]= "Non restricted user";
		
		return data;
		
	}
	
}




