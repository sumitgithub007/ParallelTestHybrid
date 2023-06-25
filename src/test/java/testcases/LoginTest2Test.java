package testcases;

import static enumPackage.CommandType.CLICK;
import static enumPackage.CommandType.TYPE;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest2Test extends BaseTest {
	public  Logger log=LogManager.getLogger(getClass());
    @Test
    public void LoginIntopApplication () {
    	 
    	log.info("Test case Start " + LogManager.getLogger(getClass()));
		executeCmd(CLICK, gethomePage().getLoginModalOpen());
		executeCmd(TYPE, gethomePage().getLoginusername(), prop.getProperty("username"));
		executeCmd(TYPE, gethomePage().getLoginpassword(), prop.getProperty("password"));
		executeCmd(CLICK, gethomePage().getLogin_button());
		assertEquals(getAttribute(gethomePage().getLoginperson()), "Welcome" + " " + prop.getProperty("username"));
		reusablecomponents.refresh();
		log.info("Test case End " + LogManager.getLogger(getClass()));
    }
    
    
    
}
