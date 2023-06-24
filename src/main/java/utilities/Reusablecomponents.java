package utilities;

import static enumPackage.WaitStrategy.VISIBLE;

import java.util.List;

import enumPackage.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Reusablecomponents {

    public WebDriver     driver;
    public WebDriverWait wait;

    /**
     * It will perform click action
     *
     * @param locator
     */
    public void Click (By locator) {

        getWebElement (VISIBLE, locator).click ();

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

        return getWebElement (VISIBLE, locator).getText ();

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
        wait (strategy, locator);
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
            wait.until (ExpectedConditions.alertIsPresent ());
            foundAlert = true;
        } catch (Exception eTO) {
            foundAlert = false;
        }
        return foundAlert;

    }

    /**
     * Refresh the current Page
     */
    public void refresh () {
    
        driver.navigate ()
            .refresh ();
    }

    /**
     * scroll down page based on pixel value
     */
    public void scrollDownPage () {

        ((JavascriptExecutor) driver).executeScript ("window.scrollBy(0,350)", "");

    }

    /**
     * @param driver @wait will be applied to instance variable of ReusableComponents class
     */
    public void setDriver (WebDriver driver, WebDriverWait wait) {
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
