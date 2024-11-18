package mobile_tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTests  extends AppiumConfig {

    @Test
    public void loginPositiveTest() {
        UserDTO user = UserDTO.builder()
                .username("roma@gmail.com")
                .password("7206Rom@")
                .build();
        new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginFormPositive(user)
                .isElementPresent_popUpMessageSuccess("Login success!");
    }

    @Test
    public void loginNegativeWrongPassword() {
        UserDTO user = UserDTO.builder()
                .username("roma@gmail.com")
                .password("7206Rom!")
                .build();
        new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginFormNegative(user)
                .validateErrorMessage("Login or Password incorrect")
        ;
    }
}