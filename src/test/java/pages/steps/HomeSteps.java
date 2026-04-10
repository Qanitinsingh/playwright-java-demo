package pages.steps;

import pages.methods.HomePageMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import java.util.Map;

public class HomeSteps {

    @Given("User is on the {string} in Chrome")
    public void user_is_on_the_in_chrome(String url) {
        HomePageMethods.launchBrowser(url);
    }

    @When("User clicks on the Novice Link")
    public void user_clicks_on_the_novice_link() {
        HomePageMethods.clickNoviceLink();
    }

    @And("I click on Basic form present under Practice Form Option")
    public void practice_form() {
        HomePageMethods.clickPracticeForm();
        HomePageMethods.clickBasicForm();
    }

    @And("I Switch to Iframe")
    public void switch_iframe() {
        HomePageMethods.switchToIframe();
    }

    @And("User fills the form with following details")
    public void user_fills_the_form_with_following_details(DataTable dataTable) {

        Map<String, String> formData = dataTable.asMap(String.class, String.class);

        HomePageMethods.enterUsername(formData.get("Username"));
        HomePageMethods.enterPassword(formData.get("Password"));
        HomePageMethods.enterComments(formData.get("Comments"));
        HomePageMethods.selectGender();
        HomePageMethods.selectSkills();
        HomePageMethods.selectExperience(formData.get("Experience"));

        String tools = formData.get("AutomationTools");
        if (tools != null && !tools.isEmpty()) {
            HomePageMethods.selectAutomationTools(tools.split(","));
        }

        HomePageMethods.uploadResume(formData.get("ResumePath"));
    }

    @And("I click on submit button")
    public void click_submit_button() {
        HomePageMethods.clickSubmit();
    }

    @Then("Form should be submitted successfully")
    public void form_should_be_submitted_successfully() {
        System.out.println("Form has been submitted successfully");
    }
}