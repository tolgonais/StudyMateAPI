package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.Config;

public class CoursesSteps {
//    @Given("the user is on the Course page")
//    public void the_user_is_on_the_course_page() {
//
//    }
//    @When("the user creates a new Course")
//    public void the_user_creates_a_new_course() {
//
//    }
//    @When("provides all the information")
//    public void provides_all_the_information() {
//
//    }
//    @Then("verify that new Course has been created")
//    public void verify_that_new_course_has_been_created() {
//
//    }

    public static void main(String[] args) {
        Response response = RestAssured.given()
                .auth().oauth2(AuthorizationToken.getToken())
                .header("Origin", "https://codewiser.studymate.us")
                .header("Referer", "https://codewiser.studymate.us")
                .get(Config.getProperty("studyMateUrl") + "api/courses/");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }
}
