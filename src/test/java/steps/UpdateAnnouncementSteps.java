package steps;

import entities.RequestBody;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Config;



public class UpdateAnnouncementSteps {

    int announcementId = 208;
    boolean active = false;
    RequestBody requestBody = new RequestBody();
    Response response;

    @When("the user wants to update an existing announcement")
    public void the_user_wants_to_update_an_existing_announcement() {
        requestBody.setText("Updated text");
        requestBody.setGroupId(0);

    }
    @When("provides the announcement ID and updated information")
    public void provides_the_announcement_id_and_updated_information() {
        response = RestAssured.given()
                .auth().oauth2(AuthorizationToken.getToken())
                .header("Origin", "https://codewiser.studymate.us")
                .header("Referer", "https://codewiser.studymate.us")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .param("id", announcementId)
                .param("active", active)
                .put(Config.getProperty("studyMateUrl") + "api/announcements/" + announcementId);

    }
    @Then("verify that the announcement is successfully updated.")
    public void verify_that_the_announcement_is_successfully_updated() {
        System.out.println(response.statusCode());
        response.prettyPrint();
        if (response.statusCode()==200){
            System.out.println("Announcement successfully updated");
        }
        else{
            System.out.println("Failed");
        }

    }

}
