package steps;

import com.github.javafaker.Faker;
import entities.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.Config;

public class CoursesSteps {
    RequestBody requestBody = new RequestBody();
    Response response;
    Faker faker = new Faker();

    @Given("the user is on the Course page")
    public void the_user_is_on_the_course_page() {

    }
    @When("the user creates a new Course")
    public void the_user_creates_a_new_course() {
        response = RestAssured.given()
                .auth().oauth2(AuthorizationToken.getToken())
                .header("Origin", "https://codewiser.studymate.us")
                .header("Referer", "https://codewiser.studymate.us")
                .get(Config.getProperty("studyMateUrl") + "api/courses/");
    }
    @Then("verify that new Course has been created")
    public void verify_that_new_course_has_been_created() {
        System.out.println(response.statusCode());
        response.prettyPrint();
    }

}
