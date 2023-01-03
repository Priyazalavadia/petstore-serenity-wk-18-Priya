package io.swagger.swaggerinfo;

import io.restassured.response.ValidatableResponse;
import io.swagger.testbase.TestBase;
import io.swagger.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;


import static org.hamcrest.Matchers.hasValue;
@RunWith(SerenityRunner.class)

public class UserCrudTestWithSteps extends TestBase {

    static int id = TestUtils.getRandomNum();
    static String username = "Champak" + TestUtils.getRandomValue();
    static String firstName = "Champaklal";
    static String lastName = "Gada";
    static String email = "Champak.Gada" + TestUtils.getRandomValue() + "@email.com";
    static String password = "Champak" + TestUtils.getRandomNum();
    static String phone = "075" + TestUtils.getRandomPhone();
    static int userStatus = 1;

    static int userID;

    @Steps
    UserSteps userSteps;

    @Title("This will create a new user")
    @Test
    public void test001() {

        ValidatableResponse response = userSteps.createUser(id, username, firstName, lastName, email, password, phone, userStatus);
        response.log().all().statusCode(200);
        response.extract().path("id");


    }

    @Title("This will verify that new user has been created")
    @Test
    public void test002() {
        HashMap<String, Object> userMap = userSteps.getUserInfoByUserId(username);
        Assert.assertThat(userMap, hasValue(username));
        userID = (int) userMap.get("id");
    }


    @Title("This will update a new user")
    @Test
    public void test003() {
        firstName = firstName + "pendra";
        ValidatableResponse response = userSteps.updateUser(id, username, firstName, lastName, email, password, phone, userStatus);
        response.log().all().statusCode(200);


        HashMap<String, Object> userMap = userSteps.getUserInfoByUserId(username);
        Assert.assertThat(userMap, hasValue(userID));
    }

    @Title("Deleting user and verifying user is delted")
    @Test
    public void test004(){
        userSteps.deleteUser(username).statusCode(200);
        userSteps.getUserInfoAfterDeletion(username).statusCode(404);

    }

}
