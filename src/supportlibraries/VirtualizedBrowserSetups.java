
package supportlibraries;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class VirtualizedBrowserSetups {

	@SuppressWarnings("unused")
	private static final String IGNORE_ZOOM_SETTING = null;
	
	
	public WebDriver getVirtualizedFireFoxDriver() {
		String firefoxBinaryPath = "\\\\carefirst.com\\corp\\tastream\\FIREFOX_28.0_v1.0\\Mozilla Firefox 28.0.exe";
		return getFireFoxFromLocation(firefoxBinaryPath);
	}

	/**
	 * ============================================================================================
	 *	 * Function Description : [ Function to get the firefox location ]
	 * ============================================================================================
	 */
	public WebDriver getFireFoxFromLocation(String strFFBinaryLoc) {

		File pathToBinary = new File(strFFBinaryLoc);
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setAcceptUntrustedCertificates(true);
		WebDriver ffDriver = new FirefoxDriver(ffBinary, firefoxProfile);
		ffDriver.manage().window().maximize();
		return setBrowserProperties(ffDriver);
	}
	public WebDriver setBrowserProperties(WebDriver driver) {
		// Maximize Window
		driver.manage().window().maximize();

		// Set Page Load Time out and Object Search Time out.
		long timeout = Long.parseLong("60");
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		timeout = Long.parseLong("15");
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

		return driver;
	}

}
