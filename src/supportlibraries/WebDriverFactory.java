package supportlibraries;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {


	private WebDriverFactory() {
		// To prevent external instantiation of this class
	}

	/**
	 * Function to return the appropriate {@link WebDriver} object based on the parameters passed
	 * @param browser The {@link Browser} to be used for the test execution
	 * @return The corresponding {@link WebDriver} object
	 */
	public static WebDriver getDriver(Browser browser) {

		WebDriver driver = null;
		VirtualizedBrowserSetups virtualizedBrowserSetups = new VirtualizedBrowserSetups();

			driver = virtualizedBrowserSetups.getVirtualizedFireFoxDriver();

		return driver;
	}


	/**
	 * Function to return the appropriate {@link WebDriver} object based on the parameters passed
	 * @param browser The {@link Browser} to be used for the test execution
	 * @param remoteUrl The URL of the remote machine to be used for the test execution
	 * @return The corresponding {@link WebDriver} object
	 */
	public static WebDriver getDriver(Browser browser, String remoteUrl) {
		return getDriver(browser, null, null, remoteUrl);
	}

	/**
	 * Function to return the appropriate {@link WebDriver} object based on the parameters passed
	 * @param browser The {@link Browser} to be used for the test execution
	 * @param browserVersion The browser version to be used for the test execution
	 * @param platform The {@link Platform} to be used for the test execution
	 * @param remoteUrl The URL of the remote machine to be used for the test execution
	 * @return The corresponding {@link WebDriver} object
	 */
	public static WebDriver getDriver(Browser browser, String browserVersion, Platform platform, String remoteUrl) {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setBrowserName(browser.getValue());

		if (browserVersion != null) {
			desiredCapabilities.setVersion(browserVersion);
		}
		if (platform != null) {
			desiredCapabilities.setPlatform(platform);
		}

		desiredCapabilities.setJavascriptEnabled(true); // Pre-requisite for
														// remote execution

		URL url = null;
		try {
			url = new URL(remoteUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			//throw new FrameworkException("The specified remote URL is malformed");
		}

		return new RemoteWebDriver(url, desiredCapabilities);
	}
}