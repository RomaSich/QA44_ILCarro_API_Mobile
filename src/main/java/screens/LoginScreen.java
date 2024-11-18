package screens;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }


    @FindBy(id="com.telran.ilcarro:id/editLoginEmail")
    AndroidElement emailField;

    @FindBy(id="com.telran.ilcarro:id/editLoginPassword")
    AndroidElement passwordField;

    @FindBy(id="com.telran.ilcarro:id/loginBtn")
    AndroidElement btnYalla;

    public SearchScreen typeLoginFormPositive(UserDTO user){
        pause(2000);
        emailField.sendKeys(user.getUsername());
        passwordField.sendKeys(user.getPassword());
        btnYalla.click();
        return new SearchScreen(driver);
    }

    public ErrorScreen typeLoginFormNegative(UserDTO user) {
        emailField.sendKeys(user.getUsername());
        passwordField.sendKeys(user.getPassword());
        btnYalla.click();
        return new ErrorScreen(driver);
    }
}