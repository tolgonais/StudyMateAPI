package steps;

import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Config;

public class AuthorizationToken {

    public static String getToken(){
        RequestBody requestBody = new RequestBody();
        requestBody.setEmail(Config.getProperty("email"));
        requestBody.setPassword(Config.getProperty("password"));
        Response response = RestAssured.given()
                .header("Origin", "https://codewiser.studymate.us")
                .header("Referer", "https://codewiser.studymate.us")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(Config.getProperty("studyMateUrl") + "api/auth/authenticate");

        String token = response.jsonPath().get("token");
        return token;
    }
}
