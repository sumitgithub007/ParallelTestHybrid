package testcases;

import org.testng.annotations.Test;
import static enumPackage.CommandType.*;

public class PurchaseProductTest extends BaseTest {

    @Test
    public void loginwebapp () {
    	executeCmd(CLICK,gethomePage().getLoginModalOpen ());
    	executeCmd(TYPE,gethomePage ().getLoginusername (),prop.getProperty ("username"));
    	//System.out.println(prop.getProperty ("password"));
    	
    	executeCmd(TYPE, gethomePage ().getLoginpassword(), prop.getProperty ("password"));
    	//executeCmd(TYPE,gethomePage ().getLoginpassword(),prop.getProperty ("password"));
    	// reusablecomponents.Type (gethomePage ().getLoginpassword (), prop.getProperty ("password"));
         
    	executeCmd(CLICK,gethomePage ().getLogin_button ());
    
		/*
		 * reusablecomponents.Click (gethomePage ().getLogin_button ());
		 * 
		 */
    	reusablecomponents.Validation (gethomePage ().getLoginperson (),"Welcome" + " " + prop.getProperty ("username"));
        reusablecomponents.refresh ();

    }

    @Test (dependsOnMethods = {"loginwebapp" })
    public void purchaseProductFromWebsite () {
        reusablecomponents.Click (getCartPage ().getSonyXperiaMob ());
        reusablecomponents.Click (getCartPage ().getAddtoCart ());
        reusablecomponents.WaitandAcceptAlert ();
        reusablecomponents.Click (getCartPage ().getCartPageOpen ());
        reusablecomponents.Click (getCartPage ().getPlaceOrderbutton ());
        reusablecomponents.Type (getCartPage ().getName (), "sumit");
        reusablecomponents.Type (getCartPage ().getCountry (), "India");
        reusablecomponents.Type (getCartPage ().getCity (), "Gwalior");
        reusablecomponents.Type (getCartPage ().getCreditcard (), "4018034566789090");
        reusablecomponents.Type (getCartPage ().getMonth (), "August");
        reusablecomponents.Type (getCartPage ().getYear (), "2023");
        reusablecomponents.Click (getCartPage ().getPurchaseItemButton ());
    }

}
