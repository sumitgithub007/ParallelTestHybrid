/*
 * package testcomponents;
 * 
 * import java.io.File; import java.io.FileInputStream; import
 * java.time.Duration; import java.util.Properties;
 * 
 * import lombok.SneakyThrows; import org.apache.commons.io.FileUtils; import
 * org.openqa.selenium.OutputType; import org.openqa.selenium.TakesScreenshot;
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.support.ui.WebDriverWait; import
 * utilities.Reusablecomponents;
 * 
 * public class BaseFile extends Reusablecomponents {
 * 
 * public String applicationURL; public FileInputStream fis; public Properties
 * prop; public Reusablecomponents reusablecomponents;
 * 
 * public BaseFile (final WebDriver driver, final WebDriverWait wait) { super
 * (driver, wait); }
 * 
 *//**
	 * Take the screenshot place it in report folder and return the path of the
	 * screenshot
	 *
	 * @param testCaseName
	 *
	 * @return
	 */
/*
 * @SneakyThrows public String getScreenshot (String testCaseName) {
 * TakesScreenshot screenshot = (TakesScreenshot) driver; File source =
 * screenshot.getScreenshotAs (OutputType.FILE); File newfile = new File
 * (System.getProperty ("user.dir") + "//reports//" + testCaseName + ".png");
 * FileUtils.copyFile (source, newfile); return System.getProperty ("user.dir")
 * + "//reports//" + testCaseName + ".png";
 * 
 * }
 * 
 *//**
	 * This method launch webpage,hit url and return the driver object
	 *
	 * @return basedriver
	 *//*
		 * @SneakyThrows public WebDriver launchApplication (WebDriver driver) { String
		 * path = "_Lambok/src/main/java/utilities/GlobalData.properties";
		 * System.out.println (driver); fis = new FileInputStream (path); prop = new
		 * Properties (); prop.load (fis); applicationURL = prop.getProperty ("url");
		 * driver.get (applicationURL); reusablecomponents = new Reusablecomponents
		 * (driver,new WebDriverWait (driver, Duration.ofSeconds (10))); return driver;
		 * }
		 * 
		 * }
		 */