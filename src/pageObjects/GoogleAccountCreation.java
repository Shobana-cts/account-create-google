package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import supportlibraries.Browser;
import supportlibraries.UtilityFunctions;
import supportlibraries.WebDriverFactory;

public class GoogleAccountCreation extends UtilityFunctions{
		
		// to initialize the webdriver
		private static WebDriver initializeWebDriver() 
		{
			WebDriver driver = WebDriverFactory.getDriver(Browser.Firefox);
			return driver;
		}
		
		/**
		 * Function to invoke the google application and to enter the fields necessary for creating an account
		 * Error message validation when the user name is not entered
		
		**/
		public  boolean googleLaunchBrowser() throws Throwable
		{
		boolean launch= false;
		try
		{
			
			WebDriver driver = initializeWebDriver();
			String error;
			driver.get("https://www.google.com/?gws_rd=ssl");
			if(driver.findElement(By.xpath("//a[contains(.,'Sign in')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//a[contains(.,'Sign in')]")).click();
				// wait function to wait till the Create account page is displayed
				if(waitTillObjectVisibility(driver, By.xpath("//a[contains(.,'Create account')]"), 10, false))
				{
				driver.findElement(By.xpath("//a[contains(.,'Create account')]")).click();
				}
				driver.findElement(By.id("FirstName")).sendKeys("Test");
				driver.findElement(By.id("LastName")).sendKeys("User");
				driver.findElement(By.id("Passwd")).sendKeys("Test123Test123");
				driver.findElement(By.id("PasswdAgain")).sendKeys("Test123Test123");
				driver.findElement(By.xpath(".//*[@id='BirthMonth']/div[contains(.,'Month')]")).sendKeys("May");
				driver.findElement(By.id("BirthDay")).sendKeys("02");		
				driver.findElement(By.id("BirthYear")).sendKeys("1992");
				driver.findElement(By.xpath(".//*[@id='Gender']/div[contains(.,'I am')]")).sendKeys("Female");
				driver.findElement(By.id("SkipCaptcha")).click();
				driver.findElement(By.id("TermsOfService")).click();
				driver.findElement(By.id("submitbutton")).click();
				error=driver.findElement(By.id("errormsg_0_GmailAddress")).getText();
				//error message validation
				if(error.equals("You can't leave this empty."))
				{
					System.out.println("Error message validated successfully");
				}
				}
			
		}
		catch(Exception e)
		{
			
		}
		return launch;
		
	}
		
		
		

}
