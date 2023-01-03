package io.swagger.swaggerinfo;

import io.restassured.response.ValidatableResponse;
import io.swagger.constants.EndPoints;
import io.swagger.model.UserPojo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class UserSteps {

    @Step("Creating userSteps with id:{0},username:{1},firstname:{2},lastName:{3}, email:{4},password:{5},phone:{6}, userStatus:{}")
    public ValidatableResponse createUser(int id, String userName,String firstName, String lastName,String email,String password,String phone,int userStatus){
        UserPojo userPojo = UserPojo.getUserPojo(id,userName,firstName,lastName,email,password,phone,userStatus);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post(EndPoints.CREATE_USER)
                .then().log().all().statusCode(200);

    }

    @Step("Getting the user detail with userID : {0}")
    public HashMap<String, Object> getUserInfoByUserId(Object userID) {
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .pathParam("userID", userID)
                .get(EndPoints.GET_USER_BY_ID)
                .then().log().all().statusCode(200)
                .extract()
                .path("");
    }
    @Step("Update userSteps with id:{0},username:{1},firstname:{2},lastName:{3}, email:{4},password:{5},phone:{6}, status:{}")
    public ValidatableResponse updateUser(int id, String userID, String firstName, String lastName, String email, String password,String phone, int userStatus) {
        UserPojo userPojo = UserPojo.getUserPojo(id,userID, firstName, lastName, email, password, phone, userStatus);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .pathParam("userID", userID)
                .put(EndPoints.UPDATE_USER_BY_ID)
                .then().log().all().statusCode(200);

    }
    @Step("Deleting user by userID")
    public ValidatableResponse deleteUser(String userID){

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .pathParam("userID", userID)
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then().log().all().statusCode(200);
    }

    @Step("Verifying user is deleted")
    public ValidatableResponse getUserInfoAfterDeletion(Object userID) {
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .pathParam("userID", userID)
                .get(EndPoints.GET_USER_BY_ID)
                .then().log().all().statusCode(404);


    }
}
