package RestTests;

import base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;

public class DeleteTest extends BaseTest {
    @ParameterizedTest
    @CsvSource({"1"})
    public void shouldDeleteUserById(String id) {
        given().
                pathParams("id", id).
                when().
                delete(POSTS + "/{id}").
                then().
                statusCode(200);
    }
}