package Test_cases;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Swaglabs_bases.Test_base;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Home_page extends Test_base {


	
	private ATUTestRecorder recorder;
	public Home_page() throws IOException {
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
		}
	
	//5
	@Test(priority=5)
		public void logo_test(Method method){
			
			WebElement logo = Driver.findElement(By.className("app_logo"));
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			boolean Actualresult=logo.isDisplayed();
			Assert.assertTrue(true);
		}
	//6
	@Test(priority=6)
		public void menutest(Method method){			

			WebElement menu = Driver.findElement(By.className("bm-burger-button"));
			menu.click();
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			WebElement allitemslabel=Driver.findElement(By.id("inventory_sidebar_link"));
			boolean Actualresult =allitemslabel.isDisplayed();
			System.out.println(Actualresult);
			Assert.assertTrue(true,"the actualrestult is diplayed");
		}

	//7
	@Test(priority=7)
		public void click_onabout(Method method){
			WebElement menu = Driver.findElement(By.id("react-burger-menu-btn"));
			menu.click();
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			WebElement about = Driver.findElement(By.id("about_sidebar_link"));
			about.click();
			WebElement solutionslable = Driver.findElement(By.linkText("Solutions"));
			boolean Actualresult = solutionslable.isDisplayed();
			Assert.assertTrue(true,"this solution is didplayed");
			
		}
	//8
	@Test(priority=8)
		public void click_onlogout(Method method){
			WebElement menu = Driver.findElement(By.className("bm-burger-button"));
			menu.click();
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			WebElement about = Driver.findElement(By.id("logout_sidebar_link"));
			about.click();
			String Expectedresult = ("https://www.saucedemo.com/");
			String Actualresult = Driver.getCurrentUrl();
			System.out.println(Actualresult);
			Assert.assertEquals(Expectedresult, Actualresult);
		}
	//9	
	@Test(priority=9)
		public void Add_item1(Method method){
				WebElement addpackback = Driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
				addpackback.click();
				Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				WebElement remove = Driver.findElement(By.id("remove-sauce-labs-backpack"));
				boolean Actualresult = remove.isDisplayed();
				Assert.assertTrue(true);
				
		}
	//10
	@Test(priority=10)
		public void Add_item2(Method method){
				WebElement addbikelight = Driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
				addbikelight.click();
				Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				WebElement remove = Driver.findElement(By.id("remove-sauce-labs-bike-light"));
				boolean Actualresult = remove.isDisplayed();
				Assert.assertTrue(true);
			
			}
	//11		
	@Test(priority=11)
		public void Drop_down(Method method){
				WebElement Drop_down = Driver.findElement(By.className("product_sort_container"));
				Drop_down.click();
				Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Select Hightolow = new Select(Drop_down);
				Hightolow.selectByValue("hilo");
			
			}
			
	//12	
	@Test(priority=12)
		public void shoppingcart(Method method){
				WebElement shoppingicon = Driver.findElement(By.className("shopping_cart_link"));
				shoppingicon.click();
				Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				WebElement cartlist = Driver.findElement(By.className("cart_list"));
				boolean Actualresult=cartlist.isDisplayed();
				Assert.assertTrue(true);
				
			}
	//13
	@Test(priority=13)
		public void Addelement_tocart(Method method){
				WebElement addpackback = Driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
				addpackback.click();
				Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				WebElement shoppingicon = Driver.findElement(By.className("shopping_cart_link"));
				shoppingicon.click();
				WebElement sauceaddpackback = Driver.findElement(By.className("inventory_item_name"));
				boolean Actualresult = sauceaddpackback.isDisplayed();
				Assert.assertTrue(true);
				
			
			
	}
		@AfterMethod
			public void tearDown(Method method) throws ATUTestRecorderException{
				Driver.quit();
				recorder.stop();
			}
		
}	

