package io.swagger.testbase;


import io.restassured.RestAssured;
import io.swagger.constants.Path;
import io.swagger.utils.PropertyReader;
import org.junit.BeforeClass;

/**
 * Created by Jay
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
       // RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
        RestAssured.basePath = Path.USERS;
    }

}
