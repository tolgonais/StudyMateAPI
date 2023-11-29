package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.Config;


public class DeleteAnnouncementSteps {

    Response response;
    int id  = 205;

    @When("the user wants to delete an existing announcement")
    public void the_user_wants_to_delete_an_existing_announcement() {
      response = RestAssured.given()
                .auth().oauth2(AuthorizationToken.getToken())
                .header("Origin", "https://codewiser.studymate.us")
                .param("id", id)
                .delete(Config.getProperty("studyMateUrl") + "api/announcements/" + id);
    }
    @Then("verify that the announcement is successfully deleted.")
    public void verify_that_the_announcement_is_successfully_deleted() {
        System.out.println(response.statusCode());
        response.prettyPrint();
        if (response.statusCode()==200){
            System.out.println("Announcement deleted");
        }
        else{
            System.out.println("Failed");
        }
    }
}
