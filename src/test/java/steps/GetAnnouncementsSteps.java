package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.Config;

public class GetAnnouncementsSteps {
    Response response;

    @When("the user wants to retrieve an announcement")
    public void the_user_wants_to_retrieve_an_announcement() {
       response = RestAssured.given()
                .auth().oauth2(AuthorizationToken.getToken())
                .header("Origin", "https://codewiser.studymate.us")
                .header("Referer", "https://codewiser.studymate.us")
                .get(Config.getProperty("studyMateUrl") + "api/announcements");
    }
    @When("provides the announcement ID or relevant criteria")
    public void provides_the_announcement_id_or_relevant_criteria() {

    }
    @Then("verify that the announcement is successfully retrieved.")
    public void verify_that_the_announcement_is_successfully_retrieved() {
        System.out.println(response.statusCode());
        response.prettyPrint();
    }
}