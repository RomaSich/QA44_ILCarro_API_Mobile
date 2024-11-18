package api;

import dto.UserDTO;
import interfaces.Base_Api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class AuthenticationController implements Base_Api {
    protected Response registrationLogin(UserDTO registrationBodyDto, String url)
    {
        return given()
                .body(registrationBodyDto)
                .contentType(ContentType.JSON)
                .post(BASE_URL+url)
                .thenReturn();
    }
}
