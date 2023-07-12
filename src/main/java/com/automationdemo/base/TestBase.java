package com.automationdemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class TestBase {

	public static WebDriver driver;
	public static Properties properties;
	

	
	public TestBase() {
		
		try {
			properties = new Properties();
			FileInputStream iprop = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/"
					+ "automationdemo/configs/config.properties");
			properties.load(iprop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		public static void initialization(){
		
String browserName = properties.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Webdriver\\chromedriver.exe");
			
				
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\Webdriver\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		}
		else if (browserName.equals("IE")){
			
			//code for IE Driver
		}

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
		
		}
}
