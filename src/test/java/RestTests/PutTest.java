package RestTests;

import base.BaseTest;
import io.restassured.http.ContentType;
import utils.PostJsonHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;

public class PutTest extends BaseTest {
    @ParameterizedTest
    @CsvSource("1")
    public void shouldOverrideUserById(String id) {
        given()
                .contentType(ContentType.JSON)
                .body(new PostJsonHandler().getPostFromFile()).
                when()
                .put(POSTS + "/" + id).
                then()
                .statusCode(200);
    }
}