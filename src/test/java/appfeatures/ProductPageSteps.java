package appfeatures;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductPage;
import qa.DriverFactory;

public class ProductPageSteps {

    ProductPage productPage = new ProductPage(DriverFactory.getDriver());

    @When("I click on Men")
    public void i_click_on_men() {
        productPage.clickOnSection();
    }

    @Then("I should redirect to section")
    public void i_should_redirect_to_section() {
        Assert.assertTrue(productPage.sectionInfo());
    }

    @When("I select the product")
    public void i_select_the_product() {
       productPage.clickOnSection();
    }

    @Then("Product page should display")
    public void product_page_should_display() {
       boolean isDisplay = productPage.sectionInfo();
        Assert.assertTrue(isDisplay);
    }

    @When("I select size and color")
    public void i_select_size_and_color() {
        productPage.selectSize();
    }

    @When("Click on add to cart")
    public void click_on_add_to_cart() {
        productPage.clickOnAddToCart();
    }

    @Then("I should see message contains {string}")
    public void i_should_see_message_contains(String words) {
        String confirmMessage = productPage.fetchMessage();
        Assert.assertTrue(confirmMessage.contains(words));
    }

}
