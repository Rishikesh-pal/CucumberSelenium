package appfeatures;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import qa.DriverFactory;
import utility.ConfigLoader;

import java.io.IOException;

public class HomePageSteps {
    HomePage homePage=new HomePage(DriverFactory.getDriver());
    @Given("I am at home page")
    public void i_am_at_home_page() throws IOException {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigLoader.readConfigData("url"));
    }

    @Then("page title should have {string}")
    public void page_title_should_have(String expectedTitle) {
        Assert.assertEquals(homePage.fetchTitle(), expectedTitle);
    }

    @Then("I should see signin link on page")
    public void i_should_see_signin_link_on_page() {
        Assert.assertTrue(homePage.isSignInDisplaying());
    }

    @When("I search for text {string}")
    public void i_search_for_text(String product) {
        homePage.searchProduct(product);
    }

    @Then("I should navigate to results page")
    public void i_should_navigate_to_results_page() {

        int count = homePage.getResultsCount();

        boolean isGreaterThan1= count>1;

        Assert.assertTrue(isGreaterThan1);
    }
}
