package Swaglabs_bases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import SWAGLABS_util.Web_listener;
import atu.testrecorder.ATUTestRecorder;

public class Test_base {
	
	public static WebDriver Driver;
	public static Properties prop ;
	public static EventFiringWebDriver e_driver;
	public static Web_listener weblistener;
	public static ATUTestRecorder recorder;
	
	public Test_base () throws IOException {
		
		
	prop = new Properties();
	FileInputStream fis = new FileInputStream ("E:\\Qc\\automation\\eclipse-workspace\\SWAG LABS\\src\\configuration\\config.properties");
	prop.load(fis);
	
	String url = prop.getProperty("URL");
	System.out.println(url);
	
	}
	
	public void intialization() {
		System.setProperty("webdriver.chrome.driver","E:\\Qc\\automation\\auto\\chromedriver_win32 (1)\\chromedriver.exe");
		Driver= new ChromeDriver();
		e_driver = new EventFiringWebDriver(Driver);
		weblistener = new Web_listener();
		e_driver.register(weblistener);
		Driver=e_driver;
		Driver.get(prop.getProperty("URL"));
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
}}
