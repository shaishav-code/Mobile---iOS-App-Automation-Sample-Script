package demo.ios.login;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.net.MalformedURLException;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Login extends BaseClassForLogin 
{	
   @Test(priority = 1)
	public void loginwithoutPassword() throws InterruptedException
	{
		if(driver.findElements(By.xpath("//XCUIElementTypeButton[@name=\\\"Log in to your Indigo account\\\"]")).size()!=0)
		{
	     WebElement clickOnLogin = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Log in to your Indigo account\"]"));
		 clickOnLogin.click();
		}
		else
		{
			System.out.println("Element not Dispalyed");
		}
		 validUserName();
		 withOutPassword();
		 clickOnLoginLink();  
		 WebElement error = driver.findElementByAccessibilityId("Please enter the password");
		 System.out.println("Error Msg==≥≥"+" "+error.getText());
		 if(error.getText().contentEquals("Please enter the password"))
		  {
			 Thread.sleep(4000);
			 WebElement ok =driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]\n" + 
			  		""));
			 ok.click();
			 Assert.assertTrue(true);
		  }
		  else
		  {
			  Assert.assertTrue(false);	  
		  }		  
	}

@Test(priority = 2)

public void loginWithInvalidUserName() throws InterruptedException
{
	invalidUseName();
	validPassword();
	clickOnLoginLink();
	Thread.sleep(4000);  
	  
	WebElement error = driver.findElementByAccessibilityId("Invalid username or password");
	  
	System.out.println("Error Msg==≥≥"+" "+error.getText());
	  
	if(error.getText().contentEquals("Invalid username or password"))
	  {
		  Thread.sleep(4000);
		 WebElement ok =driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]\n" + 
		  		""));
		 ok.click();
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.assertTrue(false);
		  
	  }
}
     @Test(priority = 3)
      public void loginWithInvalidPassword() throws InterruptedException
{
    	validUserName();
    	invalidPassword();
 		clickOnLoginLink();  
 		Thread.sleep(4000);		  
 		WebElement error = driver.findElementByAccessibilityId("Invalid username or password");
 		System.out.println("Error Msg==≥≥"+" "+error.getText());
 		if(error.getText().contentEquals("Invalid username or password"))
 		  {
 			 Thread.sleep(4000);
 			 WebElement ok =driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]\n" + 
 			  		""));
 			 ok.click();
 			 Assert.assertTrue(true);
 		  }
 		  else
 		  {
 			 Assert.assertTrue(false);	  
 		  }  
}
     @Test(priority = 4)
  	public void loginWithUnauthoriseUser() throws InterruptedException
  	{
  		 
 	   demoOneUserName();
 	   demoOneUserPassword();	 
  	   clickOnLoginLink();
  	   Thread.sleep(4000);
  	   WebElement agree =driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Agree\"]\n" + 
  		 		""));
  	   agree.click();
  	   WebElement okone =driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]"));
  	   okone.click();
  	}
      @Test(priority = 5)
     public void loginWithcondition() throws InterruptedException
     {
    	 
    	validUserName();
    	validPassword();
    	clickOnLoginLink();
    	Thread.sleep(7000);
    	WebElement agree = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Agree\"]"));
 		agree.click();
 		Thread.sleep(7000);
    	driver.runAppInBackground(Duration.ofSeconds(-1));
    	
    	// launch the app again
    	
		Thread.sleep(9000);
		driver.launchApp();
    
 		Thread.sleep(7000);
 		WebElement setcodeone = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]\n" + 
 				""));
 		setcodeone.sendKeys("0");
 		WebElement setcodetwo = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]\n" + 
 				""));
 		setcodetwo.sendKeys("0");
 		WebElement setcodethree = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]\n" + 
 				""));
 		setcodethree.sendKeys("0");
 		WebElement setcodefour = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]\n" + 
 				""));
 		setcodefour.sendKeys("0");
 		Thread.sleep(4000);
 		WebElement done = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
 		done.click();
 		if (driver.findElements(By.xpath("//XCUIElementTypeButton[@name=\"Allow While Using App\"]")).size() != 0) 
 		{
 		  WebElement allow = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow While Using App\"]"));
 		  allow.click();
 		}
 		else
 		{
 			System.out.println("Allow Window Pop up not display");
 		}
 		Thread.sleep(5000);
    	// click on home
    	driver.runAppInBackground(Duration.ofSeconds(-1));
    	// launch the app again
    	Thread.sleep(7000);
    	driver.launchApp();
    	 		
    	 //enter wrong pin at access code page
    	
    	 Thread.sleep(4000);
    	 WebElement pinone = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"8\"]"));
    	 pinone.click();
    	 WebElement pintwo = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"7\"]"));
    	 pintwo.click();
    	 WebElement pinthree = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"1\"]"));
    	 pinthree.click();
    	 WebElement pinfour = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"8\"]"));
    	 pinfour.click();
    	 Thread.sleep(4000);
    	 WebElement oook = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]"));
    	 oook.click();
    			  
    	//enter correct pin
    	 
    	Thread.sleep(4000);
    	WebElement pinonee = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"0\"]\n" + 
    			  		""));
    	pinonee.click();
    	WebElement pintwoo = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"0\"]\n" + 
    			  		""));
    	pintwoo.click();
        WebElement pinthreee = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"0\"]\n" + 
    			  		""));
    	pinthreee.click();
    	WebElement pinfourr = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"0\"]\n" + 
    			  		""));
        pinfourr.click();
     }

 @Test(priority = 6)
 
	public void logout() throws InterruptedException 
	{
	    WebElement menuList = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"ic drawer\"]"));
		menuList.click();
		WebElement clickOnManageAccount = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Manage accounts\"]"));
		clickOnManageAccount.click();
		WebElement logout = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Log out\"]"));
		logout.click();
		 Thread.sleep(4000);
		WebElement popupLogout = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Log out\"]"));
		popupLogout.click();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(-1));
		Thread.sleep(5000);
		driver.launchApp();	
	}
 
 //@Test(priority = 7)
 
	public void validLogin() throws MalformedURLException, InterruptedException
	{
		 
	 Thread.sleep(4000);
	  WebElement userName = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField\n" + 
	  		""));
	 //userName.clear();
	 userName.sendKeys("Demo03");
	 Thread.sleep(2000);
	 WebElement userPassword = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField"));
	 userPassword.clear();
	 userPassword.sendKeys("Demo_1234"); 
	 WebElement login = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Continue\"]"));
	 login.click();	  
	 Thread.sleep(8000);
	 WebElement agree = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Agree\"]"));
	 agree.click();
	 Thread.sleep(3000);
		/* WebElement setAcesscodOne = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]\n" + 
		 		"")); 
		 	
			  setAcesscodOne.sendKeys("0");
			  WebElement setAccesscodeTwo = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]"));
			  setAccesscodeTwo.sendKeys("0");
			  WebElement setAccesscodeThree = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]"));
			  setAccesscodeThree.sendKeys("0");
			  WebElement setAccesscodeFour = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]"));
			  setAccesscodeFour.sendKeys("0");
			  WebElement done = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
			  done.click();*/
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
 public   void validUserName() throws InterruptedException
 {
	 
	 Thread.sleep(4000);
	 WebElement userName = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField\n" + 
		 		""));
	 userName.clear();
	 userName.sendKeys("Demo03");
 }
 
 public void validPassword() throws InterruptedException
 {
	 Thread.sleep(2000);
	 WebElement userPassword = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField"));
	 userPassword.clear();
	 userPassword.sendKeys("Demo_1234"); 
 }
 
 public void clickOnLoginLink()
 {
	 WebElement login = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Continue\"]"));
	 login.click();
 }
 
 public void enterSetAcessCodeFirst() throws InterruptedException
 {
	 Thread.sleep(7000);
	 WebElement setAcesscodOne = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]\n" + 
	 		"")); 
	 	
	 setAcesscodOne.sendKeys("0");
 }
 
 public void enterSetAcessCodeSecond() throws InterruptedException
 {
	 Thread.sleep(2000);
	 WebElement setAccesscodeTwo = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]"));
	 setAccesscodeTwo.sendKeys("0");
 }
 
 public void enterSetAccessCodeThree() throws InterruptedException
 {
	 Thread.sleep(2000);
	 WebElement setAccesscodeThree = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]"));
	 setAccesscodeThree.sendKeys("0");
	  
 }
 public void enterSetAccessCodeFour() throws InterruptedException
 {
	 Thread.sleep(2000);
	 WebElement setAccesscodeFour = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]"));
	 setAccesscodeFour.sendKeys("0");
 }
 public  void clickOnDoneLink()
 {
	 WebElement done = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
	 done.click();
 }
 
 public void invalidUseName()
 {
	 WebElement userName = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField\n" + 
		 		""));
	 userName.clear();
	 userName.sendKeys("Demo0555");
 }
 
 public void invalidPassword()
 {
	 WebElement userPassword = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField"));
	 userPassword.clear();
	 userPassword.sendKeys("InvalidPassword"); 
 }
 public void demoOneUserName()
 {
	 WebElement userNameone = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField\n" + 
		 		""));
	 userNameone.clear();
	 userNameone.sendKeys("Demo01");
 }
 
 public void demoOneUserPassword()
 {
	 WebElement userPasswordone = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField"));
	 userPasswordone.clear();
	 userPasswordone.sendKeys("Demo_1234"); 
 }
 
 public void withOutPassword()
 {
	 WebElement userPassword = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Indigo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField"));
	 userPassword.clear();
	 userPassword.sendKeys(""); 
 }
 
 	}
