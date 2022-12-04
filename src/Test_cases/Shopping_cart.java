package Test_cases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Swaglabs_bases.Test_base;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Shopping_cart extends Test_base {

		
	
		
		private ATUTestRecorder recorder;
		public Shopping_cart() throws IOException {
		super();
		// TODO Auto-generated constructor stub
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
		}
		
	
	
	//14
	@Test(priority=14)
		public void Continue_shopping(Method method){
			WebElement continueshopping = Driver.findElement(By.id("continue-shopping"));
			continueshopping.click();
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String Expectedresult = ("https://www.saucedemo.com/inventory.html");
			String Actualresult = Driver.getCurrentUrl();
			System.out.println(Actualresult);
			Assert.assertEquals(Expectedresult, Actualresult);
	}
	
	//15
	@Test(priority=15)
		public void checkout_button(Method method){
			WebElement checkoutbutton = Driver.findElement(By.id("checkout"));
			checkoutbutton.click();
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String Expectedresult = ("https://www.saucedemo.com/checkout-step-one.html");
			String Actualresult = Driver.getCurrentUrl();
			System.out.println(Actualresult);
			Assert.assertEquals(Expectedresult, Actualresult);
	}
		@AfterMethod
		public void tearDown(Method method) throws ATUTestRecorderException{
			Driver.quit();
			recorder.stop();
		}}
	
			