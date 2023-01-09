package test;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LandingPage;
import pom.Navigation;
import pom.ProductDetailsPage;
import pom.ProductListPage;

public class MobileSearchAndAddToCartTest extends Driver {
	
	private Navigation navigation;
	private LandingPage landingPage;
	private ProductListPage productListPage;
	private ProductDetailsPage productDetailsPage;
	
	@When("User navigates to page {string}")
	public void user_navigates_to_page(String string) {
		navigation = new Navigation(driver);
		navigation.navigateToURL(string);
	}

	@When("He searches for {string}")
	public void he_searches_for(String string) {
		landingPage = new LandingPage(driver);
		landingPage.enterTextInSearchBox(string);
		landingPage.clickOnGoBtn();
	}

	@When("Validates the results displayed")
	public void validates_the_results_displayed() {
		productListPage = new ProductListPage(driver);
		Assert.assertTrue(productListPage.getTextFromResultsDisplayedText().contains("results for"));	    
	}

	@When("Selects Avg. Customer Review as {string}")
	public void selects_avg_customer_review_as(String string) {
		productListPage.clickOnFourStarAndUpLink();	    
	}

	@When("Selects the first mobile that appears")
	public void selects_the_first_mobile_that_appears() {
		productListPage.clickOnFirstProduct();	    
	}

	@When("Validates the change in the title, whether it is relevant to the selected mobile")
	public void validates_the_change_in_the_title_whether_it_is_relevant_to_the_selected_mobile() {
		productListPage.switchToNewTabOpened();
		productDetailsPage = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsPage.verifyPageTitleContainsProductName());
	}

	@When("Plays the mobile video")
	public void plays_the_mobile_video() throws InterruptedException {
		productDetailsPage.playVideo();
		Thread.sleep(5000); // let the video play for 5 seconds
		productDetailsPage.closeVideo();		
	}

	@When("Validates the mobile price")
	public void validates_the_mobile_price(){		
		String price = productDetailsPage.getProductPrice();
		int partOfPrice = Integer.parseInt(price.substring(2, 3));
		boolean validatePrice = false;
		if(partOfPrice>0) {
			validatePrice = true;
		}
		Assert.assertTrue(validatePrice);
	}

	@When("Clicks on {string}")
	public void clicks_on(String string) throws InterruptedException {
		productDetailsPage.clickOnSelectYourAddressLink();
	}

	@When("Waits for the pop up {string} to appear")
	public void waits_for_the_pop_up_to_appear(String string) {
		productDetailsPage.waitForAddressPopUpToAppear();
	}

	@When("Enters the pincode {string}")
	public void enters_the_pincode(String string) {		
		productDetailsPage.enterPinCode(string);
	}

	@When("Clicks on the Apply button")
	public void clicks_on_the_apply_button() {
		productDetailsPage.clickOnApplyBtn();
	}

	@When("Validates the change in the delivery location, It should display as {string}")
	public void validates_the_change_in_the_delivery_location_it_should_display_as(String string) {
		String text = productDetailsPage.getTextFromDeliverTo();
		Assert.assertTrue(string.contains(text));
	}

	@When("Clicks on the sponsored link under Compare with similar items")
	public void clicks_on_the_sponsored_link_under_compare_with_similar_items() {
		productDetailsPage.switchToSponseredLinkIFrame();
		productDetailsPage.clickOnSponseredLink();
	}

	@When("Verifies that a new window is opened with the mobile details")
	public void verifies_that_a_new_window_is_opened_with_the_mobile_details() {
	    int expectedSize = 3;
		int actualSize = productDetailsPage.getNumberOfWindowOpened();
		Assert.assertEquals(actualSize, expectedSize);
	}

	@When("Navigates to the new window and close it")
	public void navigates_to_the_new_window_and_close_it() {
		productDetailsPage.navigateToNewWindow();
		productDetailsPage.closeNewWindow();
	}

	@When("Navigates back to the previous window")
	public void navigates_back_to_the_previous_window() {
		productDetailsPage.navigateBackToPreviousWindow();
	}

	@When("Clicks on Add to Cart")
	public void clicks_on_add_to_cart() {
		productDetailsPage.clickOnAddToCartBtn();
	}

	@When("Waits for the window to be displayed")
	public void waits_for_the_window_to_be_displayed() {
		productDetailsPage.waitForAddToCartSuccessWindow();
	}

	@Then("He validates the {string} message")
	public void he_validates_the_message(String string) {
	    String actualMsg = productDetailsPage.getTextFromAddedToCartMsg();
	    Assert.assertTrue(string.equals(actualMsg));
	}

	@Then("Closes the {string} window")
	public void closes_the_window(String string) {
		productDetailsPage.closeAddedToCartWindow();
	}

	@Then("Scrolls the page downwards until {string} are displayed")
	public void scrolls_the_page_downwards_until_are_displayed(String string) throws InterruptedException {
		productDetailsPage.scrollPageDownUntilTechnicalDetails();
		Thread.sleep(2000); // let the scroll be visible during execution
	}

}
