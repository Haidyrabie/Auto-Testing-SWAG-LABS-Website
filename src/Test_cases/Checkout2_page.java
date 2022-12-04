package Test_cases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Swaglabs_bases.Test_base;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Checkout2_page extends Test_base{

	

	private ATUTestRecorder recorder;

	public Checkout2_page() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup(Method method) throws InterruptedException, ATUTestRecorderException{ 
		
	intialization();
	recorder = new ATUTestRecorder("E:\\Qc\\automation\\eclipse-workspace\\SWAG LABS\\videos",method.getName(),false);
	recorder.start();
	WebElement usernametextbox = Driver.findElement(By.id("user-name"));
	WebElement passwordtextbox = Driver.findElement(By.id("password" ));
	WebElement loginbutton = Driver.findElement(By.id("login-button"));
	usernametextbox.sendKeys("standard_user");
	passwordtextbox.sendKeys("secret_sauce");
	loginbutton.click();
	Thread.sleep(20);
	WebElement shoppingicon = Driver.findElement(By.className("shopping_cart_link"));
	shoppingicon.click();
	WebElement checkoutbutton = Driver.findElement(By.id("checkout"));
	checkoutbutton.click();
	WebElement firstname = Driver.findElement(By.id("first-name"));
	WebElement lastname = Driver.findElement(By.id("last-name"));
	WebElement postalcode = Driver.findElement(By.id("postal-code"));
	WebElement continuebutton = Driver.findElement(By.id("continue"));
	firstname.sendKeys("Haidy");
	lastname.sendKeys("Rabie");
	postalcode.sendKeys("0000000000");
	continuebutton.click();

	
}
	//18
		@Test(priority=18)
		public void cancel_button(Method method) {
			WebElement cancel_button = Driver.findElement(By.id("cancel"));
			cancel_button.click();
			String Expectedresult = ("https://www.saucedemo.com/inventory.html");
			String Actualresult = Driver.getCurrentUrl();
			System.out.println(Actualresult);
			Assert.assertEquals(Expectedresult, Actualresult);
		
	}
	
	//19
		@Test(priority=19)
		public void finish_button(Method method){
			WebElement finishbutton =Driver.findElement(By.id("finish"));
			finishbutton.click();
			String Expectedresult = ("https://www.saucedemo.com/checkout-complete.html");
			String Actualresult = Driver.getCurrentUrl();
			System.out.println(Actualresult);
			Assert.assertEquals(Expectedresult, Actualresult);
	
			}
	
		@AfterMethod
		public void tearDown(Method method) throws ATUTestRecorderException{
			Driver.quit();
			recorder.stop();
}

}	
