package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen{
    public SplashScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/versionText']")
    AndroidElement versionApp;


    public boolean validateVersion() {
        return isTextInElementPresent(versionApp,"Version 1.0.0",3000);
    }

    public SearchScreen goToSearchScreen(){
        pause(5000);
        return new SearchScreen(driver);
    }
}