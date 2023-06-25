package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import static enumPackage.CommandType.*;

public class PurchaseProductTest extends BaseTest {
	public  Logger log=LogManager.getLogger(getClass());
	@Test
	public void loginwebapp() throws InterruptedException {
		log.info("Running loginwebapp() first because of depenedsOnMethods ");
		executeCmd(CLICK, gethomePage().getLoginModalOpen());
		executeCmd(TYPE, gethomePage().getLoginusername(), prop.getProperty("username"));
		executeCmd(TYPE, gethomePage().getLoginpassword(), prop.getProperty("password"));
        executeCmd(CLICK, gethomePage().getLogin_button());
		reusablecomponents.Validation(gethomePage().getLoginperson(), "Welcome" + " " + prop.getProperty("username"));
		reusablecomponents.refresh ();
		log.info("loginwebapp() test completed");

	}

	@Test(dependsOnMethods = { "loginwebapp" })
	public void purchaseProductFromWebsite() {
	
		log.info("Test Case Start" + LogManager.getLogger(getClass()));
		executeCmd(CLICK, getCartPage().getSonyXperiaMob());
		executeCmd(CLICK, getCartPage().getAddtoCart());
		reusablecomponents.WaitandAcceptAlert();
		executeCmd(CLICK, getCartPage().getCartPageOpen());
		executeCmd(CLICK, getCartPage().getPlaceOrderbutton());
		executeCmd(TYPE, getCartPage().getName(), "sumit");
		executeCmd(TYPE, getCartPage().getCountry(), "India");
		executeCmd(TYPE, getCartPage().getCity(), "Gwalior");
		executeCmd(TYPE, getCartPage().getCreditcard(), "4018034566789090");
		executeCmd(TYPE, getCartPage().getMonth(), "August");
		executeCmd(TYPE, getCartPage().getYear(), "2023");
		executeCmd(CLICK, getCartPage().getPurchaseItemButton());
		log.info("Test case End " + LogManager.getLogger(getClass()));	
		 
	}

}
