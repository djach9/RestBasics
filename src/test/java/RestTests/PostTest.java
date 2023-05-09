package RestTests;

import base.BaseTest;
import io.restassured.http.ContentType;
import utils.PostJsonHandler;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostTest extends BaseTest {
    @Test
    public void shouldAddPost() {
        given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                            "userId": 1,
                            "title": "Example title",
                            "body": "Example body"
                          }""").
                when()
                .post(POSTS).
                then()
                .statusCode(201);
    }
    @Test
    public void shouldAddPostSecondOption() {
        given()
                .contentType(ContentType.JSON)
                .body(new PostJsonHandler().getPostFromFile()).
                when()
                .post(POSTS).
                then()
                .statusCode(201);
    }
}
