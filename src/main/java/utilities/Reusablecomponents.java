package utilities;

import static enumPackage.WaitStrategy.VISIBLE;

import java.util.List;

import enumPackage.WaitStrategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Reusablecomponents {

    public WebDriver  driver;
    public WebDriverWait wait;
    public Logger log = LogManager.getLogger(getClass());

    /**
     * It will perform click action
     *
     * @param locator
     */
    public void Click (By locator) {

    	
        getWebElement (VISIBLE, locator).click ();
        log.info("Clicked Webelement.. " + locator);

    }

    public  Reusablecomponents (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * This method will type the desired text in textbox
     *
     * @param locator
     * @param text
     */
    public void Type (By locator, String text) {

    	
        getWebElement (VISIBLE, locator).sendKeys (text);
        log.info("Entering text = " + text + " in WebElement " + locator);

    }

    /**
     * Asserts that two Strings are equal. If they are not, an AssertionError is thrown.
     *
     * @param actualvalue
     * @param expectedvalue
     */
    public void Validation (By actualvalue, String expectedvalue) {
        Assert.assertEquals (getTextValue (actualvalue), expectedvalue);
    }

    /**
     * This method will check if Alert visible and will accept alert
     */
    public void WaitandAcceptAlert () {

        if (isAlertPresent ()) {
            driver.switchTo ()
                .alert ()
                .accept ();
        }

    }

    /**
     * It will fetch text of element present on webpage
     *
     * @param locator
     */
    public String getTextValue (By locator) {

    	
        String text = getWebElement (VISIBLE, locator).getText ();
        log.info("Fetching text.. " + locator );
        log.info("Text present = " + text);
        return text;
        

    }

    public WebElement getWebElement (By locator) {
        return driver.findElement (locator);
    }

    /**
     * This method first call the wait method to check element is visible. After that it will return webElement
     *
     * @param strategy
     * @param locator
     *
     * @return
     */
    public WebElement getWebElement (WaitStrategy strategy, By locator) {
        
    	log.info("waiting for "+ locator +" to be " + strategy);
    	wait(strategy, locator);
    	log.info("Successfully found " +locator);
        return driver.findElement (locator);
    }

    /**
     * Return list of WebElements
     *
     * @param locator
     *
     * @return
     */
    public List<WebElement> getWebElements (WaitStrategy strategy, By locator) {
        wait (strategy, locator);
        return driver.findElements (locator);
    }

    public boolean isAlertPresent () {

        boolean foundAlert = false;

        try {
        	log.info("waiting for Alert to become visible on webpage");
            wait.until (ExpectedConditions.alertIsPresent ());
            foundAlert = true;
            log.info("Alert is visible");
        } catch (Exception eTO) {
            foundAlert = false;
        }
        return foundAlert;

    }

    /**
     * Refresh the current Page
     * @throws InterruptedException 
     */
    public void refresh ()   {
    
    	try
    	{
    	log.info("Refresh the webpage");
        driver.navigate ().refresh ();
        Thread.sleep(1000);
    	}
        catch(Exception e)
        {
        	log.error("Exception  "+ e);
        
    	}
    	
    }

    /**
     * scroll down page based on pixel value
     */
    public void scrollDownPage () {
    	
    	log.info("scroll down page");
        ((JavascriptExecutor) driver).executeScript ("window.scrollBy(0,350)", "");

    }

    /**
     * @param driver @wait will be applied to instance variable of ReusableComponents class
     */
    public void setDriver (WebDriver driver, WebDriverWait wait) {
       
    	log.info("set the driver and waits in ReusableComponents class");
    	this.driver = driver;
        this.wait = wait;
    }

    public void wait (WaitStrategy strategy, By locator) {
        switch (strategy) {

            case VISIBLE:
                wait.until (ExpectedConditions.visibilityOfAllElementsLocatedBy (locator));
                break;

            case PRESENT:
                wait.until (ExpectedConditions.presenceOfElementLocated (locator));
                break;

            default:
                // default statements
        }

    }

}
