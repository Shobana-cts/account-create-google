package supportlibraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilityFunctions {

	/**
	 * ============================================================================================
	 *	 * Function Description : [ Function to wait till the object is visible in the web page ]
	 * ============================================================================================
	 */

	public boolean waitTillObjectVisibility(WebDriver driver,By objectToWaitFor, int maximumWait, boolean throwException) throws Throwable {
			boolean isObjAvailable = true;
			String msg;

			try {isObjAvailable = false;
					int timer = 0;
					int maxwaitTime = (int) Math.ceil(maximumWait / 15);
					do {
						Thread.sleep(1000);
						timer++;
					} while ((!(isdisplayed(driver.findElement(objectToWaitFor)))) | (timer == maxwaitTime));
					isObjAvailable = isdisplayed(driver.findElement(objectToWaitFor));
				}
			catch (Exception e) {
				msg = (e.getMessage().toString()).split("\\n")[0];
				
				isObjAvailable = false;

			}
			return isObjAvailable;
		}

	
	public boolean isdisplayed(WebElement element) {
		boolean bool = false;
		try {
			element.isDisplayed();
			element.isEnabled();
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}
	}

