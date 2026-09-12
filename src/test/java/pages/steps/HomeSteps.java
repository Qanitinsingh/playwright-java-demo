package pages.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.methods.HomePageMethods;

public class HomeSteps {
    public static Page page;

    public HomeSteps() {
       page = Hooks.getPage();
    }

    @Given("the user opens the {string} page")
    public void the_user_opens_the_page(String url) {
        HomePageMethods.launchBrowserAndNavigateToHomePage(page,url);
    }

    @Then("the user verifies all left-sidebar menu items one by one")
    public void the_user_verifies_all_left_sidebar_menu_items_one_by_one() {
        HomePageMethods.verifyLeftSidebarMenuItemsOneByOne(page);
    }
    @Then("the browser is closed")
    public void the_browser_is_closed() {
        HomePageMethods.closeBrowser(page);
    }
}
