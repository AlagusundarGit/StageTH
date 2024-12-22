package com.born.test;

import static com.born.test.DriverScript.APP_LOGS;
import static com.born.test.DriverScript.CONFIG;
import static com.born.test.DriverScript.OR;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
//import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.codec.binary.Base64;
import com.google.common.base.Function;

//import net.sourceforge.htmlunit.corejs.javascript.ast.ContinueStatement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import java.net.URL;
import io.github.sukgu.*;

public class Keywords {

	public WebDriver driver;
	public DesiredCapabilities capability;
	
//--------------------------------------------------------------------------------------------------------	
	//public static String USERNAME = "maheshpagadala1";
	//public static String ACCESSKEY = "8ETVtSC7bxxFeaixq2Dz";
	
	public static String USERNAME = "sachindesai2";
	public static String ACCESSKEY = "49Hxy5t7LprUcEpxHhwd";
	public static String URL = "https://" + USERNAME + ":" + ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub";
	

	// -------------------------------------------------------------------------------------------
	
	/*public String openBrowser2(String object, String data) throws MalformedURLException {

		try {
			
		if (data.equals("chrome")) {
			    APP_LOGS.debug(" Opening browser in Chrome in BS ");
				ChromeOptions options = new ChromeOptions();
				capability = new DesiredCapabilities();
				capability.setCapability("os", "Windows");
				capability.setCapability("os_version", "10");
				capability.setCapability("browser", "Chrome");
				capability.setCapability("browser_version", "86.0");
				capability.setCapability("resolution", "1920x1080");
				capability.setCapability("project", "Converse US Stage--> "+DriverScript.currentTestCaseName);
				capability.setCapability("name", "US Stage Env");
				capability.setCapability("build", "1.1");
				capability.setCapability("browserstack.console", "verbose");
				capability.setCapability("browserstack.networkLogs", "true");
				capability.setCapability(ChromeOptions.CAPABILITY, options);
				capability.setCapability("browserstack.debug", "true");
				capability.setCapability("browserstack.video", "true");
				capability.setCapability("acceptSslCerts", "true");
				driver = new RemoteWebDriver(new URL(URL), capability);
				Thread.sleep(4000);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				long implicitWaitTime = Long.parseLong(CONFIG.getProperty("implicitwait"));
				driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);

			} 
		else if (data.equals("IE")) { 
			    APP_LOGS.debug(" Opening browser in Internet Explorer ");
				DesiredCapabilities capability = new DesiredCapabilities();
				capability.setCapability("browser", "IE");
				capability.setCapability("browser_version", "11.0");
				capability.setCapability("os", "Windows");
				capability.setCapability("os_version", "10");
				capability.setCapability("resolution", "1920x1080");
				capability.setCapability("project", "Converse US Stage");
				capability.setCapability("name", "US Stage Env");
				capability.setCapability("build", "1.1");
				capability.setCapability("browserstack.console", "verbose");
				capability.setCapability("browserstack.networkLogs", "true");
				capability.setCapability("browserstack.debug", "true");
				capability.setCapability("browserstack.video", "true");
				capability.setCapability("acceptSslCerts", "true");
				driver = new RemoteWebDriver(new URL(URL), capability);
				Thread.sleep(4000);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				long implicitWaitTime = Long.parseLong(CONFIG.getProperty("implicitwait"));
				driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
			}
		else if (data.equals("Mozilla")) {
			    APP_LOGS.debug(" Opening browser in FireFox ");
				DesiredCapabilities capability = new DesiredCapabilities();
				//capability.setCapability("browser", "Firefox");
				capability.setCapability("os_version", "10");
				capability.setCapability("resolution", "1920x1080");
				capability.setCapability("browser", "Firefox");
				capability.setCapability("browser_version", "82.0");
				capability.setCapability("os", "Windows");    
				capability.setCapability("project", "Converse US Stage--> "+DriverScript.currentTestCaseName);
				capability.setCapability("name", "US Stage Env");
				capability.setCapability("build", "1.1");
				capability.setCapability("browserstack.console", "verbose");
				capability.setCapability("browserstack.networkLogs", "true");
				capability.setCapability("browserstack.debug", "true");
				capability.setCapability("browserstack.video", "true");
				capability.setCapability("acceptSslCerts", "true");
				driver = new RemoteWebDriver(new URL(URL), capability);
				Thread.sleep(4000);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				long implicitWaitTime = Long.parseLong(CONFIG.getProperty("implicitwait"));
				driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
			}
			
		else if (data.equals("Safari")) {
		    APP_LOGS.debug(" Opening browser in Safari ");
		    DesiredCapabilities capability = new DesiredCapabilities();
		    capability.setCapability("browser", "Safari");
		    capability.setCapability("browser_version", "13.0");
		    capability.setCapability("os", "OS X");
		    capability.setCapability("os_version", "Catalina");
		    capability.setCapability("resolution", "1024x768");
		    capability.setCapability("project", "UNILEVER");
			capability.setCapability("name", "UniLever");
			capability.setCapability("build", "1.1");
			capability.setCapability("browserstack.console", "verbose");
			capability.setCapability("browserstack.networkLogs", "true");
			capability.setCapability("browserstack.debug", "true");
			capability.setCapability("browserstack.video", "true");
			capability.setCapability("acceptSslCerts", "true");
			driver = new RemoteWebDriver(new URL(URL), capability);
			Thread.sleep(4000);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			long implicitWaitTime = Long.parseLong(CONFIG.getProperty("implicitwait"));
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		}	
		
			
			return Constants.KEYWORD_PASS;

		
		}
		catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - cannot Run in BrowserStack" + e.getMessage();
		}

	}*/

// -------------------------------------------------------------------------------------------------
	public String openBrowser2(String object, String data)throws MalformedURLException {

		APP_LOGS.debug("Opening browser");
		if (data.equals("Mozilla")) {

			driver = new FirefoxDriver();
		}
			
		else if (data.equals("IE")) { // You may need to change the code here
										// to start IE Driver
			driver = new InternetExplorerDriver();
		}
		
		else if (data.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/chromedriver.exe");
			driver = new ChromeDriver();

		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		long implicitWaitTime = Long.parseLong(CONFIG
				.getProperty("implicitwait"));
		driver.manage().timeouts()
				.implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		

		return Constants.KEYWORD_PASS;
	}
	
	
	
	public String fluentWait(final String object, String data) {
		APP_LOGS.debug(" Wait till the Element presents -- " + object);
		try {
			
			
			/*Wait<WebDriver> waitElement = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(100))
									.pollingEvery(Duration.ofMillis(600))
									.ignoring(NoSuchElementException.class);

			WebElement foo = waitElement
							.until(new Function<WebDriver, WebElement>() 
							{
				
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath(OR.getProperty(object)));
				}
			});
*/
			Thread.sleep(3000);
			return Constants.KEYWORD_PASS;
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL;
		}

	}


	public String droplist(String object, String data) {
		APP_LOGS.debug("select the dropdown value");
		try {

			Select oSelect = new Select(driver.findElement(By.xpath(OR
					.getProperty(object))));
			List<WebElement> elementCount = oSelect.getOptions();
			int iSize = elementCount.size();
			APP_LOGS.debug(iSize);
			for (int i = 0; i < iSize; i++) {
				String sValue = elementCount.get(i).getText();
				if (sValue.equalsIgnoreCase(data)) {
					oSelect.selectByIndex(i);
					break;
				}

			}

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ " - cannot select the dropdown value" + e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String selectstate(String object, String data) {
		APP_LOGS.debug("select the dropdown value");
		try {

			Select oSelect = new Select(driver.findElement(By.xpath(OR
					.getProperty(object))));
		
			oSelect.selectByValue(data);
			
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ " - cannot select the dropdown value" + e.getMessage();

			
		}
		return Constants.KEYWORD_PASS;

	}

	public String alertaccept(String object, String data) {
		APP_LOGS.debug("Alert present ");
		try {

			new WebDriverWait(driver, 30).ignoring(
					NoAlertPresentException.class).until(
					ExpectedConditions.alertIsPresent());

			Alert al = driver.switchTo().alert();
			al.accept();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Alert not present in webpage"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String iselementpresent(String object, String data) {
		APP_LOGS.debug("Verifying the Element in webpage");
		try {

			if (driver.findElements(By.xpath(OR.getProperty(object))).size() != 0)
				return Constants.KEYWORD_PASS
						+ " -- Element is present on the webpage ";
			else
				return Constants.KEYWORD_FAIL
						+ " -- Element is not present please check ";
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Element not found "
					+ e.getMessage();
		}

	}

	public String langtextverify(String object, String data) {
		APP_LOGS.debug("Verifying the text");
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object)))
					.getAttribute("placeholder");
			String expected = data;

			if (actual.equals(expected))
				return Constants.KEYWORD_PASS + " -- text verified " + actual
						+ " -- " + expected;
			else
				return Constants.KEYWORD_FAIL + " -- text not verified "
						+ actual + " -- " + expected;
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Object not found "
					+ e.getMessage();
		}

	}

	public String shippingstate(String object, String data) {
		APP_LOGS.debug("Selecting Random item from dropdown");
		try {

			Select droplist = new Select(driver.findElement(By
					.xpath("//select[@id='billing:country_id']")));

			droplist.selectByVisibleText("New York");

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ " - cannot select the dropdown random" + e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String getCurrentURL(String object, String data) {
		APP_LOGS.debug("Checking the Current URL of the page");
		try {

			String URL = driver.getCurrentUrl();
			if (URL.equals(data)) {
				System.out.println("Cuurent URL is = "+URL);
				return Constants.KEYWORD_PASS;
			}

			else if (URL.contains(data)) {
				return Constants.KEYWORD_PASS;
			} else {
				return Constants.KEYWORD_FAIL;
			}

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ " -Current URL is not fetched properly " + e.getMessage();

		}
	}

	public String DefaultVariant(String object, String data) {
		APP_LOGS.debug("Selecting dropdownvalue");
		try {
			WebElement myAccountDropList = driver.findElement(By.xpath(OR
					.getProperty(object)));
			Thread.sleep(1000L);

			Select sel = new Select(myAccountDropList);
			String VariantTxt = sel.getFirstSelectedOption().getText();
			if (VariantTxt.startsWith("BOX")) {
				return Constants.KEYWORD_PASS;
			}

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String SortByAscending(String object, String data) {
		APP_LOGS.debug("Verifying the SortBy-Ascending");
		try {

			List<WebElement> products_Webelement = new LinkedList<WebElement>();
			APP_LOGS.debug("Storing the products into the linkedlist");
			products_Webelement = driver.findElements(By.xpath(OR
					.getProperty(object)));

			LinkedList<String> product_names = new LinkedList<String>();
			for (int i = 0; i < products_Webelement.size(); i++) {
				String s = products_Webelement.get(i).getAttribute("alt");
				product_names.add(s.toLowerCase().trim());

			}

			boolean result = chkalphabetical_order_ascending(product_names);

			if (result == true) {
				return Constants.KEYWORD_PASS;
			}

			else {

				return Constants.KEYWORD_FAIL + " - SortBy Ascending Failed";
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}
	}

	private static boolean chkalphabetical_order_ascending(
			LinkedList<String> product_names) {
		String previous = ""; // empty string

		for (final String current : product_names) {
			if (current.compareTo(previous) < 0)
				return false;
			previous = current;
		}
		return true;
	}

	public String SortByDescending(String object, String data) {
		APP_LOGS.debug("Verifying the SortBy-Descending");
		try {

			List<WebElement> products_Webelement = new LinkedList<WebElement>();
			APP_LOGS.debug("Storing the products into the linkedlist");
			products_Webelement = driver.findElements(By.xpath(OR
					.getProperty(object)));

			LinkedList<String> product_names = new LinkedList<String>();
			for (int i = 0; i < products_Webelement.size(); i++) {
				String s = products_Webelement.get(i).getAttribute("alt");
				product_names.add(s.toLowerCase().trim());

			}

			boolean result = chkalphabetical_order_descending(product_names);

			if (result == true) {
				return Constants.KEYWORD_PASS;
			}

			else {

				return Constants.KEYWORD_FAIL + " - SortBy Descending Failed";
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}
	}

	private static boolean chkalphabetical_order_descending(
			LinkedList<String> product_names) {
		String previous = ""; // empty string

		for (final String current : product_names) {
			if (current.compareTo(previous) > 0)
				return true;
			previous = current;
		}
		return false;
	}

	public String ElementNotPresent(String object, String data) {
		APP_LOGS.debug("Checking that element is not present");
		try {

			List<WebElement> ls = driver.findElements(By.xpath(OR
					.getProperty(object)));
			if (ls.isEmpty() == false) {
				return Constants.KEYWORD_FAIL;
			}

			else {
				return Constants.KEYWORD_PASS;
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ " - Exception thrown while checking for element not present "
					+ e.getMessage();

		}
	}
	
public String pumaPopupClose(String object, String data) {
		
		
		APP_LOGS.debug("Puma Popup Close");
		try {
			Shadow shadow=new Shadow(driver);
			WebElement shadElement=shadow.findElement(OR.getProperty(object));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", shadElement);
			
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL ;
		}
		return Constants.KEYWORD_PASS;
	}

public String pumaCookies(String object, String data) {
	
	
	APP_LOGS.debug("Accept Cookies");
	try {
		Shadow shadow=new Shadow(driver);
		WebElement shadElement=shadow.findElement(OR.getProperty(object));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", shadElement);
		
	} catch (Exception e) {
		return Constants.KEYWORD_FAIL ;
	}
	return Constants.KEYWORD_PASS;
}

	public String scrollToElement(String object, String data) {
		APP_LOGS.debug("Page scroll to a particular element");
		try {
			WebElement element = driver.findElement(By.xpath(OR
					.getProperty(object)));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", element);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].click();", element);

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ " - cannot scroll the page to particular element"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	// Added : Jayakumar
	// Keyword added to select list values
	public String selectDropDownByVisibleText(String object, String data) {
		APP_LOGS.debug("select the dropdown value");
		try {

			Select oSelect = new Select(driver.findElement(By.xpath(OR
					.getProperty(object))));
			List<WebElement> elementCount = oSelect.getOptions();
			int iSize = elementCount.size();
			APP_LOGS.debug("Size of the List: " + iSize);
			for (int i = 0; i < iSize; i++) {
				String sValue = elementCount.get(i).getText().trim();
				System.out.println(sValue);
				if (sValue.equalsIgnoreCase(data)) {
					// oSelect.selectByVisibleText(sValue);
					elementCount.get(i).click();
					APP_LOGS.debug("Selected Value: " + sValue);
					// oSelect.selectByIndex(i);
					break;
				}

			}

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ " - cannot select the dropdown value" + e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	private String trim(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	// Added : Jayakumar
	// Keyword added to have explicit wait
	public String WaitTillElementPresent(String object, String data) {
	
		try {
			new WebDriverWait(driver, 120)
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath(OR.getProperty(object))));

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Wait Failed" + e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}
	
	
	
	public String waitTillElementClickable(String object, String data) {
		
		try {
			new WebDriverWait(driver, 30)
					.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(OR.getProperty(object))));

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Wait Failed" + e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	// Added : Jayakumar
	// Keyword added to check if the checkbox is selected
	public String IsSelected(String object, String data) {
		// APP_LOGS.debug("select the dropdown value");
		try {
			if (!driver.findElement(By.xpath(OR.getProperty(object)))
					.isSelected()) {
				driver.findElement(By.xpath(OR.getProperty(object))).click();
			}

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Click Failed" + e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String ContainsText(String object, String data) {
		APP_LOGS.debug("Verifying the text "+object);
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected = data;

			if (actual.contains(expected))
				return Constants.KEYWORD_PASS + " -- text verified " + actual
						+ " -- " + expected;
			else
				return Constants.KEYWORD_FAIL + " -- text not verified "
						+ actual + " -- " + expected;
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Object not found "
					+ e.getMessage();
		}
	}

	public String ContainsTexts(String object, String data) {
		APP_LOGS.debug("Verifying the text");
		try {
			String currenturl=driver.getCurrentUrl();
			System.out.println("Current url is " + currenturl);
			String actual = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected = data;

			if (actual.trim().equalsIgnoreCase(expected.trim()))
				return Constants.KEYWORD_PASS + " -- text verified " + actual
						+ " -- " + expected;
			else
				return Constants.KEYWORD_FAIL + " -- text not verified "
						+ actual + " -- " + expected;
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Object not found "
					+ e.getMessage();
		}
	}
	public String switchToDefaultFrame(String object, String data) {
		APP_LOGS.debug("Switching perticular frame");

		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ " Unable to switch to default frame " + e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String ClickEnter(String object, String data) {
		APP_LOGS.debug("Clicking on OK button");

		try {
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to Click on OK button"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	

	public String SortByPrice(String object, String data) {
		APP_LOGS.debug("Checking Sort By - Price");

		try {

			String FirstVal = driver.findElement(
					By.xpath(OR.getProperty("first_product_price"))).getText();
			String SecondVal = driver.findElement(
					By.xpath(OR.getProperty("second_product_price"))).getText();
			if (Integer.parseInt(FirstVal) < Integer.parseInt(SecondVal)) {
				APP_LOGS.debug("Products Sorted");
			} else {
				APP_LOGS.debug("Products Sort - Failed");
			}

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Products Sort - Failed"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String navigate(String object, String data) {
		APP_LOGS.debug("Navigating to URL");
		try {
			driver.get(data);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " -- Not able to navigate";
		}
		return Constants.KEYWORD_PASS;
	}

	public String enablehidden(String object, String data) {
		APP_LOGS.debug("Clicking on link or button "+object);
		try {

			WebElement Element = driver.findElement(By.xpath(OR
					.getProperty(object)));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", Element);

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " -- Not able to enable the link or button"
					+ e.getMessage();
		}

		return Constants.KEYWORD_PASS;
	}

	
	
	public String clickLink(String object, String data) {
		APP_LOGS.debug("Clicking on link");
		try {
			driver.findElement(By.xpath(OR.getProperty(object))).click();
			Thread.sleep(1000L);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " -- Not able to click on link"
					+ e.getMessage();
		}

		return Constants.KEYWORD_PASS;
	}

	public String clickLinkCss(String object, String data) {
		APP_LOGS.debug("Clicking on link ");
		try {
			driver.findElement(By.cssSelector(OR.getProperty(object))).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " -- Not able to click on link"
					+ e.getMessage();
		}

		return Constants.KEYWORD_PASS;
	}

	public String clickLink_linkText(String object, String data) {
		APP_LOGS.debug("Clicking on link ");
		driver.findElement(By.linkText(OR.getProperty(object))).click();

		return Constants.KEYWORD_PASS;
	}

	public String verifyLinkText(String object, String data) {
		APP_LOGS.debug("Verifying link Text");
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected = data;

			if (actual.equals(expected))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " -- Link text not verified";

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " -- Link text not verified"
					+ e.getMessage();

		}

	}

	public String clickButton(String object, String data) {
		APP_LOGS.debug("Clicking on Button");
		try {
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " -- Not able to click on Button"
					+ e.getMessage();
		}

		return Constants.KEYWORD_PASS;
	}

	public String clickButtonCss(String object, String data) {
		APP_LOGS.debug("Clicking on Button");
		try {
			driver.findElement(By.cssSelector(OR.getProperty(object))).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " -- Not able to click on Button"
					+ e.getMessage();
		}

		return Constants.KEYWORD_PASS;
	}

	public String verifyButtonText(String object, String data) {
		APP_LOGS.debug("Verifying the button text");
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected = data;

			if (actual.equals(expected))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " -- Button text not verified "
						+ actual + " -- " + expected;
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Object not found "
					+ e.getMessage();
		}
	}

	public String selectList(String object, String data) {
		APP_LOGS.debug("Selecting from list");
		try {
			if (!data.equals(Constants.RANDOM_VALUE)) {
				driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(
						data);
			} else {
				// logic to find a random value in list
				WebElement droplist = driver.findElement(By.xpath(OR
						.getProperty(object)));
				List<WebElement> droplist_cotents = droplist.findElements(By
						.tagName("option"));
				Random num = new Random();
				int index = num.nextInt(droplist_cotents.size());
				String selectedVal = droplist_cotents.get(index).getText();

				driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(
						selectedVal);
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String verifyAllListElements(String object, String data) {
		APP_LOGS.debug("Verifying the selection of the list");
		try {
			WebElement droplist = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> droplist_cotents = droplist.findElements(By
					.tagName("option"));

			// extract the expected values from OR. properties
			String temp = data;
			String allElements[] = temp.split(",");
			// check if size of array == size if list
			if (allElements.length != droplist_cotents.size())
				return Constants.KEYWORD_FAIL + "- size of lists do not match";

			for (int i = 0; i < droplist_cotents.size(); i++) {
				if (!allElements[i].equals(droplist_cotents.get(i).getText())) {
					return Constants.KEYWORD_FAIL + "- Element not found - "
							+ allElements[i];
				}
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String verifyListSelection(String object, String data) {
		APP_LOGS.debug("Verifying all the list elements");
		try {
			String expectedVal = data;
			// System.out.println(driver.findElement(By.xpath(OR.getProperty(object))).getText());
			WebElement droplist = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> droplist_cotents = droplist.findElements(By
					.tagName("option"));
			String actualVal = null;
			for (int i = 0; i < droplist_cotents.size(); i++) {
				String selected_status = droplist_cotents.get(i).getAttribute(
						"selected");
				if (selected_status != null)
					actualVal = droplist_cotents.get(i).getText();
			}

			if (!actualVal.equals(expectedVal))
				return Constants.KEYWORD_FAIL + "Value not in list - "
						+ expectedVal;

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not find list. "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String selectRadio(String object, String data) {
		APP_LOGS.debug("Selecting a radio button");
		try {
			String temp[] = object.split(Constants.DATA_SPLIT);
			driver.findElement(
					By.xpath(OR.getProperty(temp[0]) + data
							+ OR.getProperty(temp[1]))).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "- Not able to find radio button";

		}

		return Constants.KEYWORD_PASS;

	}

	public String verifyRadioSelected(String object, String data) {
		APP_LOGS.debug("Verify Radio Selected");
		try {
			String temp[] = object.split(Constants.DATA_SPLIT);
			String checked = driver.findElement(
					By.xpath(OR.getProperty(temp[0]) + data
							+ OR.getProperty(temp[1]))).getAttribute("checked");
			if (checked == null)
				return Constants.KEYWORD_FAIL + "- Radio not selected";

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "- Not able to find radio button";

		}

		return Constants.KEYWORD_PASS;

	}

	public String checkCheckBox(String object, String data) {
		APP_LOGS.debug("Checking checkbox");
		try {
			// true or null
			String checked = driver.findElement(
					By.xpath(OR.getProperty(object))).getAttribute("checked");
			if (checked == null)// checkbox is unchecked
				driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not find checkbo";
		}
		return Constants.KEYWORD_PASS;

	}

	public String unCheckCheckBox(String object, String data) {
		APP_LOGS.debug("Unchecking checkBox");
		try {
			String checked = driver.findElement(
					By.xpath(OR.getProperty(object))).getAttribute("checked");
			if (checked != null)
				driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not find checkbox";
		}
		return Constants.KEYWORD_PASS;

	}

	public String verifyCheckBoxSelected(String object, String data) {
		APP_LOGS.debug("Verifying checkbox selected");
		try {
			String checked = driver.findElement(
					By.xpath(OR.getProperty(object))).getAttribute("checked");
			if (checked != null)
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " - Not selected";

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not find checkbox";

		}

	}

	public String verifyText(String object, String data) {
		APP_LOGS.debug("Verifying the text");
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected = data;

			if (actual.equalsIgnoreCase(expected))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " -- text not verified "
						+ actual + " -- " + expected;
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Object not found "
					+ e.getMessage();
		}

	}

	public String writeInInput(String object, String data) {
		APP_LOGS.debug("Writing in text box "+object);

		try {
			
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to write "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}
	

	
	
	public String clearInInput(String object, String data) {
		APP_LOGS.debug("Writing in text box");

		try {
			driver.findElement(By.xpath(OR.getProperty(object))).clear();
			
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to write "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}
	public String writeInInputCss(String object, String data) {
		APP_LOGS.debug("Writing in text box");

		try {
			driver.findElement(By.cssSelector(OR.getProperty(object)))
					.sendKeys(data);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to write "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String verifyTextinInput(String object, String data) {
		APP_LOGS.debug("Verifying the text in input box");
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object)))
					.getAttribute("value");
			String expected = data;

			if (actual.equals(expected)) {
				return Constants.KEYWORD_PASS;
			} else {
				return Constants.KEYWORD_FAIL + " Not matching ";
			}

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to find input box "
					+ e.getMessage();

		}
	}

	public String clickImage() {
		APP_LOGS.debug("Clicking the image");

		return Constants.KEYWORD_PASS;
	}

	public String verifyFileName() {
		APP_LOGS.debug("Verifying inage filename");

		return Constants.KEYWORD_PASS;
	}

	public String verifyTitle(String object, String data) {
		APP_LOGS.debug("Verifying title");
		try {
			String actualTitle = driver.getTitle();
			String expectedTitle = data;
			if (actualTitle.equals(expectedTitle))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " -- Title not verified "
						+ expectedTitle + " -- " + actualTitle;
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Error in retrieving title";
		}
	}

	public String exist(String object, String data) {
		APP_LOGS.debug("Checking existance of element");
		try {
			driver.findElement(By.xpath(OR.getProperty(object)));
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Object doest not exist";
		}

		return Constants.KEYWORD_PASS;
		
	}

	public String click(String object, String data) {
		APP_LOGS.debug("Clicking on any element "+object);
		try {
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Not able to click";
		}
		return Constants.KEYWORD_PASS;
	}

	
	public String clickCss(String object, String data) {
		APP_LOGS.debug("Clicking on any element");
		try {
			driver.findElement(By.cssSelector(OR.getProperty(object))).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Not able to click";
		}
		return Constants.KEYWORD_PASS;
	}

	public String synchronize(String object, String data) {
		APP_LOGS.debug("Waiting for page to load");
		((JavascriptExecutor) driver)
				.executeScript("function pageloadingtime()" + "{"
						+ "return 'Page has completely loaded'" + "}"
						+ "return (window.onload=pageloadingtime());");

		return Constants.KEYWORD_PASS;
	}

	public String waitForElementVisibility(String object, String data) {
		APP_LOGS.debug("Waiting for an element to be visible");
		int start = 0;
		int time = (int) Double.parseDouble(data);
		try {
			while (time == start) {
				if (driver.findElements(By.xpath(OR.getProperty(object)))
						.size() == 0) {
					Thread.sleep(1000L);
					start++;
				} else {
					break;
				}
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to close browser. Check if its open"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}

	public String closeBrowser(String object, String data) {
		APP_LOGS.debug("Closing the browser");
		try {
			driver.close();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to close browser. Check if its open"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String deleteAllCookies(String object, String data) {
		APP_LOGS.debug("Deleting all the Browser cookies");
		try {
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable delete all the cookies from Browser"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String quitBrowser(String object, String data) {
		APP_LOGS.debug("Closing the browser");
		try {
			driver.quit();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to close browser. Check if its open"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String pause(String object, String data)
			throws NumberFormatException, InterruptedException {
		long time = (long) Double.parseDouble(object);
		Thread.sleep(time * 1000L);
		return Constants.KEYWORD_PASS;
	}
	
	public String explicitwait(String object, String data) {
	     APP_LOGS.debug("Waiting for the element to be visible");
	     try{
	      WebDriverWait wait=new WebDriverWait(driver,30);
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));
	      Thread.sleep(5000);
	     }catch(Exception e)
	     {
	      return Constants.KEYWORD_FAIL+"Element is not visible even after explicitwait"+e.getMessage();
	     }
	  
	  return Constants.KEYWORD_PASS;
	 }


	/************************ APPLICATION SPECIFIC KEYWORDS ********************************/

	public String countryselect(String object, String data) {
		APP_LOGS.debug("Selecting dropdownvalue");
		try {
			WebElement myAccountDropList = driver.findElement(By.xpath(OR
					.getProperty(object)));
			Thread.sleep(1000L);

			Select cuntry = new Select(myAccountDropList);
			cuntry.selectByVisibleText(data);

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	

	public String enter(String object, String data) {
		APP_LOGS.debug("Clicking on the enter key");
		try {
			 Actions action=new Actions(driver);
	            action.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "Unable to click, Enter Key "
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}
	
	public String ArrowKeyDown(String object, String data) {
		APP_LOGS.debug("Clicking Arrow Down key");
		try{
       	 Actions action=new Actions(driver);
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
       }catch(Exception e){
           return Constants.KEYWORD_FAIL+"Unable to click, Arrow Key Down"+e.getMessage();
       }
       return Constants.KEYWORD_PASS;

	}

	public String tab(String object, String data) {
		APP_LOGS.debug("Click the tab");
		try {
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(
					Keys.TAB);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to go back, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String enterCss(String object, String data) {
		APP_LOGS.debug("Going back one page");
		try {
			driver.findElement(By.cssSelector(OR.getProperty(object)))
					.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to go back, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String windowHandler(String object, String data) {
		APP_LOGS.debug("Handling multiple windows");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
			String mainWindowHandle = driver.getWindowHandle();
			System.out.println(mainWindowHandle);
			 FileInputStream fs = new FileInputStream("src/test/java/com/born/config/config.properties");
		        CONFIG= new Properties();
		        CONFIG.load(fs);
		   
		        CONFIG.setProperty("MainWindowHandler",mainWindowHandle);
		       FileOutputStream fos=new FileOutputStream("src/test/java/com/born/config/config.properties");
		       CONFIG.store(fos, "saved to config");
		
			
			driver.findElement(By.xpath(OR.getProperty(object))).click();
			Set<String> window = driver.getWindowHandles();
			Iterator<String> iterator = window.iterator();

			while (iterator.hasNext()) {
				String popupHandle = iterator.next().toString();
				System.out.println(popupHandle);
				if (!popupHandle.contains(mainWindowHandle)) {

					driver.switchTo().window(popupHandle);
					driver.manage().window().maximize();
					

				}
			}

			// Back to main window
			// driver.switchTo().window(mainWindowHandle);

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to handle windows, See log4j report for more info"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}
	
	
	public String switchBacktoMainWindow(String object, String data) {

		try {
				driver.switchTo().window(CONFIG.getProperty("MainWindowHandler"));
				}catch (Exception e) {
					return Constants.KEYWORD_FAIL
							+ "Unable to Switch to main window"
							+ e.getMessage();
				}
				return Constants.KEYWORD_PASS;

			}		
	


	public String click_JS(String object, String data) {
		APP_LOGS.debug("Clicking on any element using JavaScript");
		try {
			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('" + object
							+ "').click()");
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to click, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}

	public String writeInInput_JS(String object, String data) {
		APP_LOGS.debug("Writing in text box using JavaScript");
		try {
			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('" + object
							+ "').value='" + data + "'");
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to write, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}

	// << Go back one page
	public String goBack(String object, String data) {
		APP_LOGS.debug("Going back one page");
		try {
			driver.navigate().back();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to go back, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	// >> Go to forward one page
	public String goForward(String object, String data) {
		APP_LOGS.debug("Going back one page");
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to go back, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	// Verify list of items after clicking on drop-down list like Newborn, Shoes
	// etc.
	public String verifyAllItems(String object, String data) {
		APP_LOGS.debug("Verifying link Text");
		try {
			for (int i = 0; i <= 150; i++) {
				List<WebElement> gridBoxes = driver.findElements(By
						.className("events-div"));
				System.out.println("Number of boxes " + gridBoxes.size());
				// Pick random link box
				Random gridnum = new Random();
				int grids = gridnum.nextInt(gridBoxes.size());
				WebElement grid = gridBoxes.get(grids);
				// WebElement box = link_boxes.get(0);
				List<WebElement> ItemBoxes = grid.findElements(By
						.className("product-image"));
				System.out.println("Total links are -- " + ItemBoxes.size());
				// Pick random item
				Random itemnum = new Random();
				int items = itemnum.nextInt(ItemBoxes.size());
				WebElement item = ItemBoxes.get(items);
				item.click();
				Thread.sleep(4000L);
				System.out.println(driver.getTitle());
				driver.navigate().back();

			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " -- Link text not verified"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;
	}

	// Credit Card functionality at the CheckOut
	public String selectExpMonth(String object, String data) {
		APP_LOGS.debug("Selecting Expiration Month");
		try {
			WebElement states = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> state = states.findElements(By.tagName("option"));
			Random num = new Random();
			int index = num.nextInt(state.size());
			state.get(index).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	// Credit Card functionality at the CheckOut
	public String selectExpYear(String object, String data) {
		APP_LOGS.debug("Selecting Expiration Year");
		try {
			WebElement states = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> state = states.findElements(By.tagName("option"));
			Random num = new Random();
			int index = num.nextInt(state.size());
			state.get(index).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	// Credit Card functionality at the CheckOut
	public String selectAmex(String object, String data) {
		APP_LOGS.debug("Selecting American Express Card");
		try {
			WebElement size = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> selectSize = size.findElements(By
					.tagName("option"));
			selectSize.get(0).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	// Credit Card functionality at the CheckOut
	public String selectVisa(String object, String data) {
		APP_LOGS.debug("Selecting Visa Credit Card");
		try {
			WebElement size = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> selectSize = size.findElements(By
					.tagName("option"));
			selectSize.get(1).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	// Credit Card functionality at the CheckOut
	public String selectMasterCard(String object, String data) {
		APP_LOGS.debug("Selecting MasterCard");
		try {
			WebElement size = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> selectSize = size.findElements(By
					.tagName("option"));
			selectSize.get(2).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectRandomState(String object, String data) {
		APP_LOGS.debug("Selecting Random States");
		try {
			WebElement states = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> state = states.findElements(By.tagName("option"));
			Random num = new Random();
			int index = num.nextInt(state.size());
			state.get(index++).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectEvent(String object, String data) {
		APP_LOGS.debug("Selecting Random event");
		try {
			WebElement eventList = driver.findElement(By
					.xpath("//*[@id='events-live']/ul"));
			List<WebElement> events = eventList.findElements(By
					.xpath("//*[@class='event-link']"));

			int time = Integer.parseInt(object);

			if (events.size() == 0) {
				APP_LOGS.debug("There's no events on the page");

			} else {
				events.get(time).click();
			}

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectRandomEvent(String object, String data) {
		APP_LOGS.debug("Selecting Random event");
		try {
			List<WebElement> events = driver.findElements(By
					.xpath("//*[@id='events-live']/ul/li[not(@style)]/a"));
			Random num = new Random();
			int index = num.nextInt(events.size());
			WebElement menu = events.get(index);
			Actions builder = new Actions(driver);
			builder.moveToElement(menu).build().perform();
			menu.click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectProduct(String object, String data) {
		APP_LOGS.debug("Selecting Random Product");

		int time = Integer.parseInt(object);

		try {
			List<WebElement> items = driver.findElements(By
					.xpath("//*[@class='product-image']"));
			if (items.size() == 0) {
				APP_LOGS.debug("There's no product on the page");
				driver.navigate().back();
				selectRandomEvent(object, data);
				selectRandomProduct(object, data);

			} else {
				items.get(time).click();
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectRandomProduct(String object, String data) {
		APP_LOGS.debug("Selecting Random Product");
		try {
			List<WebElement> items = driver.findElements(By
					.xpath("//div[@id='grid-view']/div/div/div/a"));
			Random num = new Random();
			int index = num.nextInt(items.size());
			items.get(index).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectRandomColor(String object, String data) {
		APP_LOGS.debug("Selecting Random Color");
		try {
			WebElement color = driver.findElement(By
					.xpath("//*[@id='attribute85']"));
			List<WebElement> selectColor = color.findElements(By
					.tagName("option"));
			selectColor.get(1).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectRandomSize(String object, String data) {
		APP_LOGS.debug("Selecting Random Size");
		try {
			WebElement size = driver.findElement(By
					.xpath("//select[@id='Size'][@name='size']"));
			List<WebElement> selectSize = size.findElements(By
					.tagName("option"));
			selectSize.get(1).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String chrodKeys(String object, String data) {
		APP_LOGS.debug("Selecting in text box");

		try {
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(
					Keys.chord(data));
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to select "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String chrodKeysCss(String object, String data) {
		APP_LOGS.debug("Selecting in text box");

		try {
			driver.findElement(By.cssSelector(OR.getProperty(object)))
					.sendKeys(Keys.chord(data));
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to select "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	

	
	public String mouseHover(String object, String data) {
		APP_LOGS.debug("Mouse Hovering to the element");
		try {

		
			WebElement menu = driver.findElement(By.xpath(OR
					.getProperty(object)));
			
			Actions builder = new Actions(driver);
			builder.moveToElement(menu).clickAndHold().perform();
			Thread.sleep(2000L);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "Unable to mouse hover"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String mouseHoverCss(String object, String data) {
		APP_LOGS.debug("Mouse Hovering to the element");
		try {

			Thread.sleep(3000L);
			WebElement menu = driver.findElement(By.cssSelector(OR
					.getProperty(object)));
			Actions builder = new Actions(driver);
			builder.moveToElement(menu).build().perform();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "Unable to mouse hover"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String doubleClick(String object, String data) {
		APP_LOGS.debug("Mouse Hovering to the element");
		try {

			Thread.sleep(3000L);
			WebElement menu = driver.findElement(By.xpath(OR
					.getProperty(object)));
			Actions builder = new Actions(driver);
			builder.doubleClick(menu).build().perform();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "Unable to mouse hover"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}


	
	public String switchToFrame(String object, String data) {
		APP_LOGS.debug("Switching perticular frame");

		try {
			driver.switchTo().frame(
					driver.findElement(By.id(OR.getProperty(object))));
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to switch farme "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String switchToFrameByTitle(String object, String data) {
		APP_LOGS.debug("Switching perticular frame "+object);

		try {
			driver.switchTo().frame(
					driver.findElement(By.xpath(OR.getProperty(object))));
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to switch farme "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}
	// not a keyword

	public void captureScreenshot(String filename,
			String keyword_execution_result) throws IOException {
		// take screen shots
		if (CONFIG.getProperty("screenshot_everystep").equals("Y")) {
			// capturescreen

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
					+ "//screenshots//" + filename + ".jpg"));

		} else if (keyword_execution_result.startsWith(Constants.KEYWORD_FAIL)
				&& CONFIG.getProperty("screenshot_error").equals("Y")) {
			// capture screenshot
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
					+ "//screenshots//" + filename + ".jpg"));
		}

	}

	

	public String scroll(String object, String data) {
		APP_LOGS.debug("Scroll down the element to Visible ");
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;

			jse.executeScript("window.scrollBy(0,250)", "");

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable refresh the Browser and GFS is down"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String scrolldown(String object, String data) {
		APP_LOGS.debug("Scroll down the element to Visible ");
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,850)", "");

			jse.executeScript("window.scrollBy(0,850)", "");

			jse.executeScript("window.scrollBy(0,450)", "");

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to Scrolldown the Browser and GFS is down"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}
	public String scrolldowns(String object, String data) {
		APP_LOGS.debug("Scroll down the element to Visible ");
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to Scroll down the Element"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}
	public String scrollup(String object, String data) {
		APP_LOGS.debug("Scroll Up the element till visible");
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;

			jse.executeScript("window.scrollBy(0,-450)", "");

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to scroll Up the element"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String refresh(String object, String data) {
		APP_LOGS.debug("Refreshing the Browser");
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable refresh the Browser and GFS is down"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String switchToFrameByName(String object, String data) {
		APP_LOGS.debug("Switching perticular frame by Name");

		try {
			driver.switchTo().frame(
					driver.findElement(By.name(OR.getProperty(object))));
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to switch farme "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}



	public String textverify(String object, String data) {
		APP_LOGS.debug("Verifying the text");
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected = data;

			if (actual.equals(expected))
				return Constants.KEYWORD_PASS + " -- text verified " + actual
						+ " -- " + expected;
			else
				return Constants.KEYWORD_FAIL + " -- text not verified "
						+ actual + " -- " + expected;
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Object not found "
					+ e.getMessage();
		}

	}

	
	
	public void captureScreenshotNew(String filename, String keyword_execution_result) throws IOException {
		File dir = new File(System.getProperty("user.dir") + "//screenshots");
		dir.mkdir();
		// take screen shots
		if (CONFIG.getProperty("screenshot_everystep").equals("Y")) {
			// capturescreen
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(25))
					.takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "JPG",
					new File(System.getProperty("user.dir") + "//screenshots//" + filename + ".jpg"));
		} else if (keyword_execution_result.startsWith(Constants.KEYWORD_FAIL)
				&& CONFIG.getProperty("screenshot_error").equals("Y")) {
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(25))
					.takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "JPG",
					new File(System.getProperty("user.dir") + "//screenshots//" + filename + ".jpg"));

		}
	}
	
public void New(String filename,
			String keyword_execution_result) throws IOException {
		// take screen shots
		File dir = new File(System.getProperty("user.dir") + "//screenshots");
		dir.mkdir();
		if (CONFIG.getProperty("screenshot_everystep").equals("Y")) {
			// capturescreen
			Screenshot screenshot = new AShot().shootingStrategy(
					ShootingStrategies.viewportPasting(1000)).takeScreenshot(
					driver);
			ImageIO.write(screenshot.getImage(), "JPG",
					new File(System.getProperty("user.dir") + "//screenshots//"
							+ filename + ".jpg"));
		} else if (keyword_execution_result.startsWith(Constants.KEYWORD_FAIL)
				&& CONFIG.getProperty("screenshot_error").equals("Y")) {
			Screenshot screenshot = new AShot().shootingStrategy(
					ShootingStrategies.viewportPasting(1000)).takeScreenshot(
					driver);

			ImageIO.write(screenshot.getImage(), "JPG",
					new File(System.getProperty("user.dir") + "//screenshots//"
							+ filename + ".jpg"));

		}
	}


public String switchToFrameByIndex0(String object, String data) {
	APP_LOGS.debug("Switching perticular frame");

	try {
		driver.switchTo().frame(0);
	} catch (Exception e) {
		return Constants.KEYWORD_FAIL + " Unable to switch frame "
				+ e.getMessage();

	}
	return Constants.KEYWORD_PASS;

}




	public String switchToFrameByIndex(String object, String data) {
		APP_LOGS.debug("Switching perticular frame");

		try {
			driver.switchTo().frame(1);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to switch frame "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}
	
	public String switchToFrameByIndex2(String object, String data) {
		APP_LOGS.debug("Switching perticular frame");

		try {
			driver.switchTo().frame(2);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to switch frame "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}
	
	public String switchToFrameByIndex3(String object, String data) {
		APP_LOGS.debug("Switching perticular frame");

		try {
			driver.switchTo().frame(3);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to switch frame "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}
	
	
	
	
	
	
	

	public String SelectfromList(String object, String data) {

		APP_LOGS.debug("Handling the Date picker "+object);
		try {

			List<WebElement> allDates = driver.findElements(By.xpath(OR
					.getProperty(object)));
			APP_LOGS.debug("Loop through the all dates and select the one that matches");
			for (WebElement opt : allDates) {
				if (opt.getText().equalsIgnoreCase(data)) {
					System.out.println("Element which is click = "+opt.getText());
					opt.click();

				}
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to handle the Calender control" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}
	public String SelectfromLists(String object, String data) {

		APP_LOGS.debug("Handling the DropDown Values from the List " + object);
		try {

			List<WebElement> allDates = driver.findElements(By.xpath(OR.getProperty(object.trim())));
			APP_LOGS.debug("Loop through the all the values and select the one that matches");
			for (WebElement opt : allDates) {
				if (opt.getText().trim().equalsIgnoreCase(data.trim())) {
					System.out.println(opt.getText() + " --> " + data);
					opt.click();

				}
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "Unable to handle the Values from DropDown" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String RegisterEmail(String object, String data) {
		APP_LOGS.debug("Entering randomly generated Email");
		try {
			WebElement email = driver.findElement(By.xpath(OR
					.getProperty(object)));
			String prefix="cnv-test";
			final int RANDOM_STRING_LENGTH = 2;
			String suffix1=RandomStringUtils.randomAlphabetic(RANDOM_STRING_LENGTH);
			String suffix2="@borngroup.com";
			Random rnd=new Random();
			int rand_int1 = rnd.nextInt(3000); 
	       String finalemail=prefix+"+john.sumanth+"+rand_int1+suffix1+suffix2;

	      System.out.println("Random email generated is>>"+finalemail);
			email.sendKeys(finalemail);
			
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ "Unable to handle the register email" + e.getMessage();
		}

		return Constants.KEYWORD_PASS;
	}

	
	public String RandomString(String object, String data) {
		APP_LOGS.debug("Entering Random String");
		try {
			final int RANDOM_STRING_LENGTH = 5;

			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(
					RandomStringUtils.randomAlphabetic(RANDOM_STRING_LENGTH));

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Random String not entered "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}
	

	public String mouseHover1(String object, String data) {
		APP_LOGS.debug("Mouse Hovering to the element");
		try {

			Thread.sleep(3000L);
			WebElement menu = driver.findElement(By.xpath(OR
					.getProperty(object)));
			Thread.sleep(2000L);
			Actions builder = new Actions(driver);
			builder.moveToElement(menu).build().perform();
			Thread.sleep(2000L);
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "Unable to mouse hover"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}
	
	
	
	
	public String fetchordernumber(String object, String data) {
		APP_LOGS.debug("Fetching the order number");
		try {
			Thread.sleep(2000);
			String ordernumdetails =driver.findElement(By.xpath(OR.getProperty(object))).getText().trim();
			Thread.sleep(2000);
			System.out.println(ordernumdetails);
			//System.out.println(driver.getCurrentUrl());
			if(!ordernumdetails.isEmpty()) {
				return Constants.KEYWORD_PASS + " Order Number : --> " + ordernumdetails;
				
			}
			else {
				return Constants.KEYWORD_FAIL;
			}
			
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "Unable to fetch ordernumberr " + e.getMessage();

		}
		
	}
	
	public String fetchPaymentDetail(String object, String data) {
		APP_LOGS.debug("Fetching the order number");
		try {
			Thread.sleep(2000);
			String paymentDetails =driver.findElement(By.xpath(OR.getProperty(object))).getText().trim();
			Thread.sleep(2000);
			System.out.println(paymentDetails);
			//System.out.println(driver.getCurrentUrl());
			if(!paymentDetails.isEmpty()) {
				return Constants.KEYWORD_PASS + " Payment Details : --> " + paymentDetails;
				
			}
			else {
				return Constants.KEYWORD_FAIL;
			}
			
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "Unable to fetch paymentDetails " + e.getMessage();

		}
	}


//added for converse for fetching ordernumber
	
	/*public String fetchordernumber(String object, String data)  {
		APP_LOGS.debug("Fetching the order number");
		try {

			String ordernumdetails=driver.findElement(By.xpath(OR.getProperty(object))).getText();
			String[] ordernum_split=ordernumdetails.split("\\s+");
			System.out.println("Order Number is :"+ordernum_split[2]);
			if(!ordernum_split[2].isEmpty()) {
				return Constants.KEYWORD_PASS;
				
			}
			
			else {
				return Constants.KEYWORD_FAIL;	
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + "Unable to fetch ordernumberr"
					+ e.getMessage();
		}
		
		//return Constants.KEYWORD_PASS;
		

	}
	*/
	// Added By mahesh
		/*public String fetchordernumber(String object, String data) {
			APP_LOGS.debug("Fetching the order number");
			try {
				Thread.sleep(4000);
				String ordernumdetails =driver.findElement(By.xpath(OR.getProperty(object))).getText().trim();
				Thread.sleep(3000);
				System.out.println(ordernumdetails);
				
				String ordnumber=ordernumdetails.replaceAll("Order Number #", " ");
				//System.out.println("Order No: is after Replace : = "+ ordnumber);
				String OrderNumber=ordnumber.trim();
				//System.out.println("Order No: is after Replace : = "+ OrderNumber);
				Thread.sleep(1000);
				String configdata=OrderNumber.trim();
				if(OrderNumber==configdata) {
					return Constants.KEYWORD_PASS + " Order Number : --> " + OrderNumber;
					
				}
				else {
					return Constants.KEYWORD_FAIL;
				}
				
			} catch (Exception e) {
				return Constants.KEYWORD_FAIL + "Unable to fetch ordernumberr" + e.getMessage();

			}
		}
	*/
	//added for converse for upload a file
	
	public String uploadfile(String object, String data) {
		APP_LOGS.debug("Uploading the File...");
		try {

			
			StringSelection selection=new StringSelection(System.getProperty("user.dir") + "/Converse.PNG");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "Unable to upload file"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

public String uniqueSelect(String object, String data) {
		APP_LOGS.debug("Clicking one element out of list");
		try {
			List<WebElement> stores = driver.findElements(By.xpath(OR
					.getProperty(object)));
			int count = stores.size();

			for (WebElement store : stores) {

				Actions act = new Actions(driver);
				act.moveToElement(store).click().build().perform();
				break;
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ " Not able to click element from list " + e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	

	public String DefaultList(String object, String data) {
		APP_LOGS.debug("Verifying the default selected list item");
		try {
			String expectedVal = data;
			// System.out.println(driver.findElement(By.xpath(OR.getProperty(object))).getText());
			WebElement droplist = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> droplist_cotents = droplist.findElements(By
					.tagName("option"));
			String actualVal = null;
			for (int i = 0; i < droplist_cotents.size(); i++) {
				String selected_status = droplist_cotents.get(i).getAttribute(
						"selected");
				if (selected_status != null)
					actualVal = droplist_cotents.get(i).getText().trim();
			}

			if (!actualVal.equals(expectedVal))
				return Constants.KEYWORD_FAIL + "Value not in list - "
						+ expectedVal;

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not find list. "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	

	public String selectRandom(String object, String data) {
		APP_LOGS.debug("Selecting Random item from dropdown");
		try {

			WebElement droplist = driver.findElement(By.xpath(OR
					.getProperty(object)));
			Select sel = new Select(droplist);
			List<WebElement> lst = sel.getOptions();
			int count = lst.size();
			Random num = new Random();

			int low = 0;
			int high = 1;
			int randomInt = num.nextInt(high) + low;

			// int isel=num.nextInt(count);
			sel.selectByIndex(randomInt);
			System.out.println(droplist.getAttribute("value"));
			

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL
					+ " - cannot select the dropdown random" + e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	


public String MailinatorEmailStore(String object, String data) {
	APP_LOGS.debug("Save channel email to config file");
	try {

		 FileInputStream fs = new FileInputStream("src/test/java/com/born/config/config.properties");
	        CONFIG= new Properties();
	        CONFIG.load(fs);
	     
	        JavascriptExecutor jse = (JavascriptExecutor) driver; 
	       String script="return document.getElementById('dwfrm_login_username_*')";
	      System.out.println(script);
	        String email=(String)jse.executeScript(script);
	        System.out.println(email);
	        CONFIG.setProperty("Mailinator_Email",email);
	       FileOutputStream fos=new FileOutputStream("src/test/java/com/born/config/config.properties");
	       CONFIG.store(fos, "saved to config");
	  

	} catch (Exception e) {
		return Constants.KEYWORD_FAIL
				+ " - cannot save the email to config file" + e.getMessage();

	}
	return Constants.KEYWORD_PASS;

}

public String windowHandler1(String object, String data) {
	APP_LOGS.debug("Handling multiple windows "+ object);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	try {
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe[@title='PayPal']")));
		System.out.println("Switch to the Iframe");
		System.out.println(mainWindowHandle);
		driver.findElement(By.xpath(OR.getProperty(object))).click();
		System.out.println("Click on PAYPAL button");
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iterator = window.iterator();

		while (iterator.hasNext()) {
			String popupHandle = iterator.next().toString();
			System.out.println(popupHandle);
			if (!popupHandle.contains(mainWindowHandle)) {

				driver.switchTo().window(popupHandle);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//div[@id='splitEmail']/descendant::input[@type='email']")).sendKeys("cnv-test+paypal@borngroup.com");
		System.out.println("Enter User Name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='splitEmail']/descendant::button[@id='btnNext']")).click();
		System.out.println("Click on Continue Button");
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@id='splitPasswordSection']/descendant::input[@id='password']")).sendKeys("3dkX4Ypsg*");
		System.out.println("Enter Password");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='splitPassword']/descendant::button[text()='Log In']")).click();
		System.out.println("Click on Login Button");
		Thread.sleep(12000);
		scrolldowns(object, data);
		WebElement Element = driver.findElement(By.xpath("//div[contains(@class,'PageWrapper')]/descendant::button[contains(text(),'Continue')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Element);
		System.out.println("Click on Continue Button");
		Thread.sleep(10000);
				driver.switchTo().window(mainWindowHandle);

			}
		}

		// Back to main window
		// driver.switchTo().window(mainWindowHandle);

	} catch (Exception e) {
		return Constants.KEYWORD_FAIL + "Unable to handle windows, See log4j report for more info" + e.getMessage();
	}
	return Constants.KEYWORD_PASS;

}

public String windowHandler2ios(String object, String data) {
	APP_LOGS.debug("Handling multiple windows");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	try {

		Thread.sleep(8000);
		driver.findElement(By.xpath(OR.getProperty(object))).click();
		Thread.sleep(8000);
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("Switching to the Paypal Window");
		System.out.println(mainWindowHandle);
		//enablehidden(object, data);
		System.out.println("Click on Paypal Second Button");
		Thread.sleep(7000);
		//driver.switchTo().alert().accept();
		//Thread.sleep(5000);

		
		  Set<String> window = driver.getWindowHandles(); Iterator<String> iterator =
		  window.iterator();
		  
		  while (iterator.hasNext()) { String popupHandle = iterator.next().toString();
		  System.out.println(popupHandle); Thread.sleep(7000); if
		  (!popupHandle.contains(mainWindowHandle)) {
		  
		  driver.switchTo().window(popupHandle);
		 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='splitEmail']/descendant::input[@type='email']"))
				.sendKeys("cnv-test+paypal@borngroup.com");
		System.out.println("Enter User Name");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='splitEmail']/descendant::button[@id='btnNext']")).click();
		System.out.println("Click on Continue Button");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[@id='splitPasswordSection']/descendant::input[@id='password']"))
				.sendKeys("3dkX4Ypsg*");
		System.out.println("Enter Password");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='actions']/descendant::button[text()='Log In']")).click();
		System.out.println("Click on Login Button");
		Thread.sleep(20000);
		//driver.findElement(By.xpath("//div[contains(@class,'buttons reviewButton')]/descendant::button[contains(text(),'Continue')]")).click();
		//driver.findElement(By.xpath("//div[contains(@class,'pageWrapper')]/descendant::button[@id='payment-submit-btn']")).click();
		
		//System.out.println("Click on Continue Button");
		//Thread.sleep(10000);
		
		//driver.findElement(By.xpath("//button[@pagename='PayPal Checkout|acceptcookies']")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'buttons__btn--2CPW9 common__full--zwc2E') and @value='Agree & Continue']")).click();
		//driver.findElement(By.xpath("//div[contains(@class,'pageWrapper')]/descendant::button[@id='payment-submit-btn']")).click();
		
		System.out.println("Click on Agree & Continue");
		Thread.sleep(10000);
		driver.switchTo().window(mainWindowHandle);

		}
		}

	} catch (Exception e) {
		e.printStackTrace();
		return Constants.KEYWORD_FAIL + "Unable to handle windows, See log4j report for more info" + e.getMessage();
	}
	return Constants.KEYWORD_PASS;

}

public String CartPaypal(String object, String data) {
	APP_LOGS.debug("Handling multiple windows "+ object);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	try {
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe[@title='PayPal']")));
		System.out.println("Switch to the Iframe");
		System.out.println(mainWindowHandle);
		//driver.findElement(By.xpath(OR.getProperty(object))).click();
		enablehidden("paypal_Cart1", data);
		System.out.println("Click on PAYPAL button");
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iterator = window.iterator();

		while (iterator.hasNext()) {
			String popupHandle = iterator.next().toString();
			System.out.println(popupHandle);
			if (!popupHandle.contains(mainWindowHandle)) {

				driver.switchTo().window(popupHandle);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//div[@id='splitEmail']/descendant::input[@type='email']")).sendKeys("cnv-test+paypal@borngroup.com");
		System.out.println("Enter User Name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='splitEmail']/descendant::button[@id='btnNext']")).click();
		System.out.println("Click on Continue Button");
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@id='splitPasswordSection']/descendant::input[@id='password']")).sendKeys("3dkX4Ypsg*");
		System.out.println("Enter Password");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='splitPassword']/descendant::button[text()='Log In']")).click();
		System.out.println("Click on Login Button");
		Thread.sleep(12000);
		scrolldowns(object, data);
		WebElement Element = driver.findElement(By.xpath("//div[contains(@class,'PageWrapper')]/descendant::button[contains(text(),'Continue')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Element);
		System.out.println("Click on Continue Button");
		Thread.sleep(10000);
				driver.switchTo().window(mainWindowHandle);

			}
		}

		// Back to main window
		// driver.switchTo().window(mainWindowHandle);

	} catch (Exception e) {
		return Constants.KEYWORD_FAIL + "Unable to handle windows, See log4j report for more info" + e.getMessage();
	}
	return Constants.KEYWORD_PASS;

}

public String windowHandler3destop(String object, String data) {
	APP_LOGS.debug("Handling multiple windows");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	try {

		Thread.sleep(8000);
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("Switching to the Paypal Window");
		System.out.println(mainWindowHandle);
		enablehidden(object, data);
		System.out.println("Click on Paypal Second Button");
		Thread.sleep(7000);
		//driver.switchTo().alert().accept();
		//Thread.sleep(5000);

		
		  Set<String> window = driver.getWindowHandles(); Iterator<String> iterator =
		  window.iterator();
		  
		  while (iterator.hasNext()) { String popupHandle = iterator.next().toString();
		  System.out.println(popupHandle); Thread.sleep(7000); if
		  (!popupHandle.contains(mainWindowHandle)) {
		  
		  driver.switchTo().window(popupHandle);
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='fieldWrapper']/descendant::input[@type='email']"))
				.sendKeys("cnv-test+paypal@borngroup.com");
		System.out.println("Enter User Name");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='actions']/descendant::button[@id='btnNext']")).click();
		System.out.println("Click on Continue Button");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[@class='fieldWrapper']/descendant::input[@id='password']"))
				.sendKeys("3dkX4Ypsg*");
		System.out.println("Enter Password");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='actions']/descendant::button[text()='Log In']")).click();
		System.out.println("Click on Login Button");
		Thread.sleep(30000);
		driver.findElement(By.xpath("//button[@pagename='PayPal Checkout|acceptcookies' and @id='acceptAllButton']")).click();
		Thread.sleep(30000);
		//driver.findElement(By.xpath("//div[contains(@class,'CheckoutButton_buttonWrapper_2VloF')]/descendant::button[contains(text(),'Continue')]")).click();
		//driver.findElement(By.xpath("//div[contains(@class,'pageWrapper')]/descendant::button[@id='payment-submit-btn']")).click();
		
		//System.out.println("Click on Continue Button");
		//Thread.sleep(10000);
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class,'buttons__btn--2CPW9 common__full--zwc2E') and @value='Agree & Continue']")).click();
		//driver.findElement(By.xpath("//div[contains(@class,'pageWrapper')]/descendant::button[@id='payment-submit-btn']")).click();
		
		System.out.println("Click on Agree & Continue");
		Thread.sleep(30000);
		driver.switchTo().window(mainWindowHandle);

		}
		}

	} catch (Exception e) {
		e.printStackTrace();
		return Constants.KEYWORD_FAIL + "Unable to handle windows, See log4j report for more info" + e.getMessage();
	}
	return Constants.KEYWORD_PASS;

}


public String windowHandler11(String object, String data) {
	APP_LOGS.debug("Handling multiple windows "+ object);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	try {
		String mainWindowHandle = driver.getWindowHandle();
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='PayPal']")));
		//System.out.println("Switch to the Iframe");
		System.out.println(mainWindowHandle);
		driver.findElement(By.xpath(OR.getProperty(object))).click();
		System.out.println("Click on PAYPAL button");
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iterator = window.iterator();
		while (iterator.hasNext()) {
			String popupHandle = iterator.next().toString();
			System.out.println(popupHandle);
			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//div[@id='splitEmail']/descendant::input[@type='email']")).sendKeys("sb-ia33b5875070@personal.example.com");
				
		System.out.println("Enter User Name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		System.out.println("Click on Continue Button");
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@id='splitPasswordSection']/descendant::input[@id='password']")).sendKeys("r*l(&Vc0");
		System.out.println("Enter Password");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='splitPassword']/descendant::button[text()='Log In']")).click();
		System.out.println("Click on Login Button");
		Thread.sleep(12000);
		scrolldowns(object, data);
		WebElement Element = driver.findElement(By.xpath("//div[contains(@class,'CheckoutButton_buttonWrapper_2VloF')]/descendant::button[contains(text(),'Continue to Review Order')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Element);
		System.out.println("Click on Continue Button");
		Thread.sleep(10000);
				driver.switchTo().window(mainWindowHandle);
			}
		}
		// Back to main window
		// driver.switchTo().window(mainWindowHandle);
	} catch (Exception e) {
		return Constants.KEYWORD_FAIL + "Unable to handle windows, See log4j report for more info" + e.getMessage();
	}
	return Constants.KEYWORD_PASS;
}

public String popupclosepdp(String object, String data) {
	APP_LOGS.debug("Handling Popup in PDP"+ object);
	try {
		Thread.sleep(2000);
		String popupclose="(//button[contains(@class,'button button--primary accept-button')])[1]";
		if(popupclose!=null) {
			driver.findElement(By.xpath("(//button[contains(@class,'button button--primary accept-button')])[1]")).click();
			
		}
		else {
			return Constants.KEYWORD_PASS;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return Constants.KEYWORD_PASS;
	
}

//Added By Mahesh
//Switch to Second Tab - First index
	public String tabFirstTab(String object, String data) {
		APP_LOGS.debug("Switch To Tab Second");
		try {
			Thread.sleep(2000);
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab.get(1));
			Thread.sleep(1000);

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to Switch To Tab First " + e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}

	public String accountinfoedit(String object, String data) {
		APP_LOGS.debug("Capture the EMAIL Field");
		try {
			Thread.sleep(2000);
			//WebElement email=driver.findElement(By.xpath("(//input[contains(@value,'cnv')])[1]"));
			//String emailvalue=email.getText();
			WebElement actual = driver.findElement(By.xpath("//input[@name='dwfrm_profile_customer_email'])[1]"));
			String email=actual.getAttribute("value");
			System.out.println("Email Value is "+email);
			Thread.sleep(2000);
			System.out.println("Click on x icon/button");
			driver.findElement(By.xpath("(//button[@class='window-modal__close'])[2]")).click();
			Thread.sleep(2000);
			System.out.println("Click on User Account Icon");
			driver.findElement(By.xpath("//div[contains(@class,'header-utility')]/descendant::a[contains(@href,'ConverseUS/account') and contains(@title,'Hey')]")).click();
			Thread.sleep(3000);
			System.out.println("Click on SIGNOUT Icon");
			driver.findElement(By.xpath("(//a[@title='Sign Out' and contains(@href,'default/Login-Logout')])[1]")).click();
			Thread.sleep(3000);
			System.out.println("Click on SIGN IN Icon");
			driver.findElement(By.xpath("(//a[@title='Sign In' and contains(@href,'ConverseUS/account') and contains(@class,'header-user')])[2]")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='dwfrm_login_username']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='dwfrm_login_password']")).sendKeys("Born@1234");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@name='dwfrm_login_login']")).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Unable to capture the Email Value " + e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}

	public String Textnotpresent(String object, String data) {
		APP_LOGS.debug("Verifying the text "+object);
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected = data;

			if (!actual.contains(expected))
				return Constants.KEYWORD_PASS + " -- text not present " + actual
						+ " -- " + expected;
			else
				return Constants.KEYWORD_FAIL + " -- text  present "
						+ actual + " -- " + expected;
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Object not found "
					+ e.getMessage();
		}
	}
	
	public String singleClick(String object, String data) {
		APP_LOGS.debug("Single click on Web Element " + object);
		try {

			Thread.sleep(3000L);
			WebElement menu = driver.findElement(By.xpath(OR.getProperty(object)));
			Actions builder = new Actions(driver);
			builder.click(menu).build().perform();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "Unable to Single click an element" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}
	
	
	
	public String isdiablehidden(String object, String data){
	    APP_LOGS.debug("Check elements "+ object);
		   
		   try {

				if (!driver.findElement(By.xpath(OR.getProperty(object))).isEnabled())
					return Constants.KEYWORD_PASS + " -- Element is disabled ";
				else
					return Constants.KEYWORD_FAIL + " -- Element is enabled";
			} catch (Exception e) {
				return Constants.KEYWORD_FAIL + " Element not found " + e.getMessage();
			}

		}		

	public String popupclosepdp1(String object, String data) {
		APP_LOGS.debug("Handling Popup in PDP"+ object);
		try {
			Thread.sleep(2000);
			String popupclose="//button[@class='window-modal__close']";
			if(popupclose!=null) {
				driver.findElement(By.xpath("//button[@class='window-modal__close']")).click();
				
			}
			else {
				return Constants.KEYWORD_PASS;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Constants.KEYWORD_PASS;
		
	}
}







