package demo.ios.login;

import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	public static IOSDriver driver;
	public static DesiredCapabilities caps ;
	
		@BeforeClass
		public void setUp() throws MalformedURLException
		{
			caps = new DesiredCapabilities();
			 caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			 caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
			 caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
			 caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
			// caps.setCapability(MobileCapabilityType.NO_RESET, "true");
			 caps.setCapability(MobileCapabilityType.APP, "/Users/c100-134/Library/Developer/Xcode/DerivedData/com.shireburn.indigo-ftxxgholupliuxhhtyxitfoidicw/Build/Products/Debug-iphonesimulator/ShireburnIndigo.app");
			 //caps.setCapability(MobileCapabilityType.APP, "/Users/c100-134/Library/Developer/Xcode/DerivedData/com.shireburn.indigo-fbqseqovxmbxpfdvfjabyiohxwma/Build/Products/Debug-iphonesimulator/ShireburnIndigo.app"); // old 
			//caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,40000000);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"400000");	
			 URL url = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new IOSDriver(url , caps);
			 System.out.println("Done");
			 
		}
		
		public void validLogin() throws MalformedURLException, InterruptedException
		{
			 
		 Thread.sleep(4000);
		  WebElement userName = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField\n" + 
		 		""));
		 userName.clear();
		 userName.sendKeys("Demo05");
		 Thread.sleep(2000);
		 WebElement userPassword = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField"));
		  userPassword.clear();
		 userPassword.sendKeys("Demo_1234"); 
		 WebElement login = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Continue\"]"));
		  login.click();	  
			Thread.sleep(15000);
			WebElement agree = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Agree\"]"));
			agree.click();
			 Thread.sleep(3000);
			 WebElement setAcesscodOne = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]\n" + 
			 		"")); 
			 	
				  setAcesscodOne.sendKeys("0");
				  WebElement setAccesscodeTwo = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]"));
				  setAccesscodeTwo.sendKeys("0");
				  WebElement setAccesscodeThree = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]"));
				  setAccesscodeThree.sendKeys("0");
				  WebElement setAccesscodeFour = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]"));
				  setAccesscodeFour.sendKeys("0");
				  WebElement done = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
				  done.click();
			  Thread.sleep(7000);
			  	 
			if (driver.findElements(By.xpath("//XCUIElementTypeButton[@name=\"Allow While Using App\"]")).size() != 0) 
			{
			  WebElement allow = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow While Using App\"]"));
			  allow.click();
			}
			else
			{
				System.out.println("Allow Window Pop up not display");
			}
	
		}
		public String GetMonthName()
		{
			       String[] monthName = {"January", "February",
		                "March", "April", "May", "June", "July",
		                "August", "September", "October", "November",
		                "December"};

			        Calendar cal  = Calendar.getInstance();
			        String currentMonth = monthName[cal.get(Calendar.MONTH)];
					return currentMonth;
			       
					
			    }
			
		}

