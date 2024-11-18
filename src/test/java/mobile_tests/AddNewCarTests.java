package mobile_tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreen;

public class AddNewCarTests extends AppiumConfig {


    SearchScreen searchScreen;

    @BeforeMethod
    public void login() {
        UserDTO user = UserDTO.builder()
                .username("roma@gmail.com")
                .password("7206Rom@")
                .build();
        searchScreen = new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginFormPositive(user)
        ;
    }

    @Test
    public void addNewCarPositiveTest() {
        searchScreen.clickBtnDots()
                .clickBtnMyCars();
    }
}