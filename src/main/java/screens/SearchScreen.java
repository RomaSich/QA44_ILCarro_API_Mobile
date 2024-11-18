package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends BaseScreen{
    public SearchScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='More options']")
    AndroidElement btnDots;

    @FindBy(xpath = "//*[@text='Registration' and @resource-id ='com.telran.ilcarro:id/title']")
    AndroidElement btnRegistration;

    @FindBy(xpath = "//*[@text='Login' and @resource-id ='com.telran.ilcarro:id/title']")
    AndroidElement btnLogin;

    @FindBy(xpath = "//hierarchy/android.widget.Toast")
    AndroidElement popUpMessageSuccess;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title']")
    AndroidElement btnMyCars;


    public SearchScreen clickBtnDots(){
        btnDots.click();
        return this;
    }

    public LoginScreen clickBtnLogin(){
        pause(3000);
        btnLogin.click();
        return new LoginScreen(driver);
    }

    public RegistrationScreen clickBtnRegistration(){
        btnRegistration.click();
        return new RegistrationScreen(driver);
    }

    public boolean isElementPresent_popUpMessageSuccess(String text){
        return isTextInElementPresent(popUpMessageSuccess,text,5000);
    }

    public MyCarsScreen clickBtnMyCars(){
        btnMyCars.click();
        return new MyCarsScreen(driver);
    }

}