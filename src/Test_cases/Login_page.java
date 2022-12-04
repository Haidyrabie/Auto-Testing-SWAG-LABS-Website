package Test_cases;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Swaglabs_bases.Test_base;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Login_page extends Test_base {

	private ATUTestRecorder recorder;
		public Login_page() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
		@BeforeMethod 
		public void setup(Method method) throws InterruptedException, ATUTestRecorderException {
			
			intialization();
			recorder = new ATUTestRecorder("E:\\Qc\\automation\\eclipse-workspace\\SWAG LABS\\videos",method.getName(),false);
			recorder.start();
			
			}

	//1
		@Test(priority=1 )
		public void Title_test(Method method) {	
			SoftAssert softAssert = new SoftAssert();
			 
			String Expectedresult = "Swag Labs";
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String Actualresult = Driver.getTitle();
			System.out.println(Actualresult);
			softAssert.assertEquals(Expectedresult, Actualresult,"this title is matching");
		
		}
	
	
	//2
		@Test(priority=2)
		public void CheckURL(Method method) {			
			String Expectedresult = ("https://www.saucedemo.com/");
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String Actualresult = Driver.getCurrentUrl();
			System.out.println(Actualresult);
			Assert.assertEquals(Expectedresult, Actualresult);
		
		}
	
	//3
	@Test(priority=3)
		public void logo_test(Method method) {
		
			WebElement logo = Driver.findElement(By.className("login_logo"));
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			boolean Actualresult=logo.isDisplayed();
			Assert.assertTrue(true);
		
		}
	
	//4
	
	@Test(priority=4,dataProvider="mydata")
		public void login_test(String username, String password) {
		
			WebElement usernametextbox = Driver.findElement(By.id("user-name"));
			WebElement passwordtextbox = Driver.findElement(By.id("password" ));
			WebElement loginbutton = Driver.findElement(By.id("login-button"));
			usernametextbox.sendKeys("username");
			passwordtextbox.sendKeys("password");
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			loginbutton.click();
			String Expectedresult = "Swag Labs";
			String Actualresult = Driver.getTitle();
			Assert.assertEquals(Expectedresult, Actualresult);
		
		}
	@DataProvider
		public Object[][] mydata() { 
			
			Object [][] Data =new Object[5][2];
			Data[0][0]="standard_user";
			Data[0][1]="secret_sauce";
			Data[1][0]="standard_user";
			Data[1][1]="secret2011";
			Data[2][0]="standard_user1";
			Data[2][1]="secret_sauce";
			Data[3][0]="standard";
			Data[3][1]="secret";
			Data[4][0]="";
			Data[4][1]="";
			 
			
			return Data;
		
		
	}
		
	
		@AfterMethod
		public void tearDown(Method method) throws ATUTestRecorderException{
			Driver.quit();
			recorder.stop();
		}
}

		
			
			
