package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import emailutility.Mailsend;
public class Listeners implements ITestListener{

	 
	 @Override
	 
	public void onTestStart(ITestResult result) {
		 
		
		  System.out.println("test");
		 
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	 
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		 
	}

	@Override
	public void onStart(ITestContext context) {
		 
	}

	@Override
	public void onFinish(ITestContext context) {
		
		Mailsend mail = new Mailsend();
		 mail.sendAttach("index file please check", "INDEXFILE", "goyalsumit319@gmail.com", "udemycourse2211@gmail.com");
	}

	
	
	
}
