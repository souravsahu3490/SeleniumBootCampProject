package test;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.AmazonPayPage;
import pom.LandingPage;
import pom.Navigation;
import pom.NewReleasesPage;
import pom.WishListPage;

public class NavigateAndValidatePageTest extends Driver {
	
	private Navigation navigation;
	private LandingPage landingPage;
	private WishListPage wishListPage;
	private AmazonPayPage amazonPayPage;
	private NewReleasesPage newReleasesPage;
	
	@When("User navigates to page {string} with url as {string}")
	public void user_navigates_to_page_with_url_as(String string, String string2) {		
		navigation = new Navigation(driver);
		navigation.navigateToURL(string2);	
		if (string.equals("Accounts and Lists - Create a Wish List")) {
			landingPage = new LandingPage(driver);
			landingPage.hoverOverAccountsAndListsLink();
			landingPage.clickOnCreateAWishListLink();			
		}
	}

	@Then("The page {string} must open without any issue")
	public void the_page_must_open_without_any_issue(String string) {
		
		switch(string) {
		
			case "Accounts and Lists - Create a Wish List":
				wishListPage = new WishListPage(driver);
				String expectedText = "Your Lists";
				String actualText = wishListPage.validatePage();
				Assert.assertEquals(actualText, expectedText);
				break;	
				
			case "Amazon Pay":
				amazonPayPage = new AmazonPayPage(driver);
				String expectedAPText = "Scan & Pay";
				String actualAPText = amazonPayPage.validatePage();
				Assert.assertEquals(actualAPText, expectedAPText);
				break;
				
			case "New Releases":
				newReleasesPage = new NewReleasesPage(driver);
				String expectedNRText = "Amazon Hot New Releases";
				String actualNRText = newReleasesPage.validatePage();
				Assert.assertEquals(actualNRText, expectedNRText);
		}
		
			    
	}

}
