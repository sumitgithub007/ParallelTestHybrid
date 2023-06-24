package testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

   
    @Test
    public void signUpApplication (){
        reusablecomponents.Click(gethomePage ().getOpenSignUpModal ());
        reusablecomponents.Type (gethomePage ().getUsernamesignup (),
            prop.getProperty ("username")); //remove hardcode data later
        reusablecomponents.Type (gethomePage ().getPasswordsignup (), prop.getProperty ("password"));
        reusablecomponents.Click (gethomePage ().getSignup_button ());
        reusablecomponents.WaitandAcceptAlert ();
    }
}
