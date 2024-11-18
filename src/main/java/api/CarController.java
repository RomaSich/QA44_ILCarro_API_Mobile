package api;

import dto.CarDto;

import dto.TokenDto;
import interfaces.Base_Api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class CarController implements Base_Api {
    public TokenDto tokenDto;

    @BeforeSuite
    public void login() {
        AuthenticationController authenticationController = new AuthenticationController();
        tokenDto = authenticationController.registrationLogin(USER_LOGIN, LOGIN_URL)
                .as(TokenDto.class);

    }

    protected Response addNewCarResponse(CarDto car, String token) {
        return given()
                .body(car)
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .post(BASE_URL+ADD_NEW_CAR_URL)
                .thenReturn();

    }

    protected Response getAllCarsResponse (String token){
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .get(BASE_URL+GET_USER_CARS_URL)
                .thenReturn();
    }

    protected Response deleteCarByIdResponse(String token,String id){
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .delete(BASE_URL+DELETE_CAR_URL+id)
                .thenReturn();
    }

}