package RestTests;

import base.BaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetTest extends BaseTest {
    JsonPath jsonPath;
    @ParameterizedTest
    @CsvSource({"1, sunt aut facere repellat provident occaecati excepturi optio reprehenderit"})
    public void shouldReturnAllPosts(String id, String title) {
        String userPosition = String.valueOf(Integer.parseInt(id)-1);
        jsonPath =
                when().
                        get(POSTS).
                        then().
                        statusCode(200).
                        extract().
                        response().jsonPath();
        Assertions.assertThat(jsonPath.get("title[" + userPosition + "]").toString()).isEqualTo(title);
    }
    @ParameterizedTest
    @CsvSource({"1"})
    public void shouldGetPostById(String id) {
        jsonPath =
                given()
                        .pathParams("id", id).
                        when().
                        get(POSTS + "/{id}").
                        then().
                        statusCode(200).
                        body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/jsonSchema.json"))).
                        extract().
                        response().jsonPath();
        Assertions.assertThat(jsonPath.get("id").toString()).isEqualTo(id);
    }
    @ParameterizedTest
    @CsvSource({"3, 21"})
    public void shouldGetPostsByUserId(String userId, String minUserPostId) {
        jsonPath =
                given()
                        .pathParams("id", userId).
                        when().
                        get(USERS + "/{id}/posts").
                        then().
                        statusCode(200).
                        extract().
                        response().jsonPath();
        Assertions.assertThat(jsonPath.get("id.min()").toString()).isEqualTo(minUserPostId);
    }
}
