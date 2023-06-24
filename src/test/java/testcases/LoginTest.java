package testcases;
import static org.testng.Assert.*;
 
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginIntopApplication () {
        System.out.println ("start method Login---");
        reusablecomponents.Click (gethomePage ().getLoginModalOpen ());
        reusablecomponents.Type (gethomePage ().getLoginusername (), prop.getProperty ("username"));
        reusablecomponents.Type (gethomePage ().getLoginpassword (), prop.getProperty ("password"));
        reusablecomponents.Click (gethomePage ().getLogin_button ());
        
        assertEquals(getAttribute(gethomePage().getLoginperson()), "Welcome" + " " + prop.getProperty ("username"));
		/*
		 * reusablecomponents.Validation (gethomePage ().getLoginperson(), "Welcome" +
		 * " " + prop.getProperty ("username"));
		 */
    }
    
    
    
}
