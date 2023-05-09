package base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    protected static final String POSTS = BASE_URL + "/posts";
    protected static final String USERS = BASE_URL + "/users";
    @BeforeAll
    public static void setup(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}