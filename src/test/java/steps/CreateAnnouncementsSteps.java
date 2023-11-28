package steps;

import com.github.javafaker.Faker;
import entities.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Config;

public class CreateAnnouncementsSteps {

    RequestBody requestBody = new RequestBody();
    Response response;
    Faker faker = new Faker();

    @Given("the user is on the Announcement page")
    public void the_user_is_on_the_announcement_page() {

    }
    @When("the user creates a new announcement")
    public void the_user_creates_a_new_announcement() {
        for(int i = 1; i < 10; i++){
        String text = faker.lorem().sentence();
        requestBody.setText(text);
            System.out.println("Created announcements: ");
            System.out.println(text);
        }
    }
    @When("provides all the information")
    public void provides_all_the_information() {
        response = RestAssured.given()
                .auth().oauth2(AuthorizationToken.getToken())
                .contentType(ContentType.JSON)
                .body(requestBody)
                .header("Origin", "https://codewiser.studymate.us")
                .header("Referer", "https://codewiser.studymate.us")
                .post(Config.getProperty("studyMateUrl")+"api/announcements");
    }
    @Then("verify that new announcement has been created.")
    public void verify_that_new_announcement_has_been_created() {
        System.out.println(response.statusCode());
        response.prettyPrint();
        if(response.statusCode()==200){
            System.out.println("Announcements successfully created");
        }
        else{
            System.out.println("Failed");
        }

    }




}
