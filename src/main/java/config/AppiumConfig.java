package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {


    public static AppiumDriver<AndroidElement> driver;

    @BeforeMethod
    public void setup()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", " Pix2");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("appPackage", "com.telran.ilcarro");
        capabilities.setCapability("appActivity", ".SplashActivity");

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");

        try {
            driver = new AppiumDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void ternDown()
    {
        if(driver!=null)
        {
            driver.quit();
        }

    }
}
