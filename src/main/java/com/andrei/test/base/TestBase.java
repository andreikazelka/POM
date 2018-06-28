package com.andrei.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.andrei.test.util.TestUtil;
import com.andrei.test.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	//for listener
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		System.out.println("Invoke TestBase constructor");
		String propertiesFile = System.getProperty("user.dir")+ "/src/main/java/com/andrei/test/config/test.properties";
		
		try {
			prop = new Properties();
			FileInputStream fileIn = new FileInputStream(propertiesFile);
			prop.load(fileIn);
			System.out.println("Initializing properties file: " + propertiesFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		System.out.println("Initializing " + browserName + " driver...");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/chromedriver");	
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
//			System.setProperty("webdriver.gecko.driver", "/Users/andreikazelka/Documents/SeleniumServer/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		String url = prop.getProperty("url");
		driver.get(url);
		System.out.println("URL: " + url);
		
	}
}
