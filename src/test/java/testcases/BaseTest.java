package testcases;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import enumPackage.CommandType;
import lombok.SneakyThrows;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.Manager;
import testcomponents.BrowserFactory;
import utilities.Reusablecomponents;

public class BaseTest {

	public String applicationURL;
	public BrowserFactory browserFactory;
	public WebDriver driver;// This driver object is Local to this class only
	public FileInputStream fis;
	public Properties prop;
	public Manager manager;
	public  Reusablecomponents reusablecomponents;

	/**
	 * Close Browser
	 */
	@AfterTest
	public void TearDown() {
		browserFactory.getDriver().quit();
	}
	/**
	 * @return pageObject of CartPage
	 */
	public CartPage getCartPage() {
		return manager.getCartPage();
	}

	/**
	 * @return pageObject of HomePage
	 */
	public HomePage gethomePage() {
		return manager.gethomePage();
	}

	 /**It will help you to perform basic operations CLICK,TYPE..
	 * @param type
	 * @param locator
	 * @param values
	 */
	public void executeCmd(CommandType type, By locator, String... values) {

		//System.out.println(type + "  " + locator + " " + values);

		switch (type) {
		case CLICK:
			reusablecomponents.Click(locator);
			break;

		case DOUBLECLICK:
			//reusablecomponents.DoubleClick(locator); //Implement method
			 
			break;
		case TYPE:
			if (values.length > 0) {
				reusablecomponents.Type(locator, values[0]);
			} else {
				throw new IllegalArgumentException("No value provided for TYPE command.");
			}
			break;

		default:
			throw new IllegalArgumentException("Invalid command type: " + type);

		}
	}

	/**Return the attribute value or text of speficied element
	 * @param locator
	 * @param attribute
	 * @return
	 */
	public String getAttribute(By locator, String... attribute) {

		if (attribute.length > 0) {

			return reusablecomponents.getWebElement(locator).getAttribute(attribute[0]);

		}
		return reusablecomponents.getTextValue(locator);

	}

	// executeCmd()

	/**
	 * A method to launch the browser and hit url
	 */
	@BeforeTest
	@SneakyThrows
	public void launchWebsite() {
		manager = new Manager();
		browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver("chrome");
		driver = browserFactory.getDriver();
		String path =   System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\GlobalData.properties";
		System.out.println(driver);
		fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
		applicationURL = prop.getProperty("url");
		driver.get(applicationURL);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		reusablecomponents = new Reusablecomponents(driver, wait);
	}
}
