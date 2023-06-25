package testcases;

import static enumPackage.CommandType.CLICK;
import static enumPackage.CommandType.TYPE;

import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

	@Test
	public void signUpApplication() {
		executeCmd(CLICK, gethomePage().getOpenSignUpModal());
		executeCmd(TYPE, gethomePage().getUsernamesignup(), prop.getProperty("username"));
		executeCmd(TYPE, gethomePage().getPasswordsignup(), prop.getProperty("password"));
		executeCmd(CLICK, gethomePage().getSignup_button());
		reusablecomponents.WaitandAcceptAlert();
	}
}
