package api_tests.rest;

import api.AuthenticationController;
import dto.ErrorMessageDtoString;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTestsRest extends AuthenticationController {

    @Test
    public void registrationPositiveTest()
    {
        int i = new Random().nextInt(1000)+1000;
        UserDTO bodyDto = UserDTO.builder()
                .username("steve_dow" + i + "gmail.com")
                .password("Steve12345$")
                .firstName("Steve")
                .lastName("Dow")
                .build();
        Assert.assertEquals(registrationLogin(bodyDto,REGISTRATION_URL).getStatusCode(),200);
    }
    @Test
    public void registrationNegativeTest_EmptyPassword()
    {
        int i = new Random().nextInt(1000)+1000;
        UserDTO bodyDto = UserDTO.builder()
                .username("steve_dow" + i + "gmail.com")
                .password("")
                .firstName("Steve")
                .lastName("Dow")
                .build();
        Assert.assertEquals(registrationLogin(bodyDto,REGISTRATION_URL).getBody().
                as(ErrorMessageDtoString.class)
                .getStatus(),400);
    }

}
