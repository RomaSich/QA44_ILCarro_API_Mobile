package screens;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationScreen extends BaseScreen {
    public RegistrationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.telran.ilcarro:id/editRegName")
    AndroidElement firstNameField;

    @FindBy(id = "com.telran.ilcarro:id/editRegLastName")
    AndroidElement lastNameField;

    @FindBy(id = "com.telran.ilcarro:id/editRegEmail")
    AndroidElement emailField;

    @FindBy(id = "com.telran.ilcarro:id/editRegPassword")
    AndroidElement passwordField;

    @FindBy(id = "com.telran.ilcarro:id/checkBoxAgree")
    AndroidElement checkBox;

    @FindBy(id = "com.telran.ilcarro:id/regBtn")
    AndroidElement btnYalla;

    public RegistrationScreen fillRegistrationForm(UserDTO user) {
        firstNameField.sendKeys(user.getFirstName());
        lastNameField.sendKeys(user.getLastName());
        emailField.sendKeys(user.getUsername());
        passwordField.sendKeys(user.getPassword());

        return this;
    }

    public RegistrationScreen clickCheckBox() {
        checkBox.click();
        return this;
    }

    public SearchScreen clickBtnYallaPositive() {
        btnYalla.click();
        return new SearchScreen(driver);
    }

    public ErrorScreen clickBtnYallaNegative(){
        btnYalla.click();
        return new ErrorScreen(driver);
    }


}