package testcases;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

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
	Manager manager;
	Reusablecomponents reusablecomponents;

	@AfterTest
	public void TearDown() {
		browserFactory.getDriver().quit();
	}

	public CartPage getCartPage() {
		return manager.getCartPage();
	}

	public HomePage gethomePage() {
		return manager.gethomePage();
	}

	/*
	 * public void click(By locator) { reusablecomponents.Click(locator); }
	 */

	public void Command(By locator) {
		reusablecomponents.Click(locator);
	}

	public void executeCmd(CommandType type, By locator, String... values) {

		System.out.println(type + "  " + locator + " " + values);

		switch (type) {
		case CLICK:
			reusablecomponents.Click(locator);
			break;

		case DOUBLECLICK:
			reusablecomponents.Click(locator);
			;
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

	public String getAttribute(By locator, String... attribute) {

		if (attribute.length > 0) {

			return reusablecomponents.getWebElement(locator).getAttribute(attribute[0]);

		}
		return reusablecomponents.getTextValue(locator);

	}

	// executeCmd()

	@BeforeClass
	@SneakyThrows
	public void launchWebsite() {
		manager = new Manager();
		browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver("chrome");
		driver = browserFactory.getDriver();
		String path = "C:\\Users\\goyal\\Downloads\\Telegram Desktop\\HybridFramework_Lambok\\HybridFramework_Lambok\\src\\main\\java\\utilities\\GlobalData.properties";
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
