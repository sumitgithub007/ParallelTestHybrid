package testcases;

import org.testng.annotations.Test;

public class LoginTest2Test extends BaseTest {

    @Test
    public void LoginIntopApplication () {
        System.out.println ("start method Login---");
        reusablecomponents.Click (gethomePage ().getLoginModalOpen ());
        reusablecomponents.Type (gethomePage ().getLoginusername (), prop.getProperty ("username"));
        reusablecomponents.Type (gethomePage ().getLoginpassword (), prop.getProperty ("password"));
        reusablecomponents.Click (gethomePage ().getLogin_button ());
        reusablecomponents.Validation (gethomePage ().getLoginperson (),"Welcome" + " " + prop.getProperty ("username"));
    }
    
    
    
}
