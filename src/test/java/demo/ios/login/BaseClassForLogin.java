package demo.ios.login;

import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClassForLogin {
	
	public static IOSDriver driver;
	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities	caps = new DesiredCapabilities();
		 caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		 caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
		 caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
		 caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
		 caps.setCapability(MobileCapabilityType.NO_RESET, "true");
		 caps.setCapability(MobileCapabilityType.APP, "/Users/c100-134/Library/Developer/Xcode/DerivedData/com.shireburn.indigo-ftxxgholupliuxhhtyxitfoidicw/Build/Products/Debug-iphonesimulator/ShireburnIndigo.app");
		// caps.setCapability(MobileCapabilityType.APP, "/Users/c100-134/Library/Developer/Xcode/DerivedData/com.shireburn.indigo-fbqseqovxmbxpfdvfjabyiohxwma/Build/Products/Debug-iphonesimulator/ShireburnIndigo.app");
		// caps.setCapability(MobileCapabilityType.APP,"com.apple.Preferences");
		 URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new IOSDriver(url , caps);
		 System.out.println("Done");
	}

}
