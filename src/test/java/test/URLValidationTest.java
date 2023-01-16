package test;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LandingPage;
import pom.Navigation;

public class URLValidationTest extends Driver {
	
	private Navigation navigation;
	private LandingPage landingPage;
		
	@Given("Browser is opened")
	public void browser_is_opened() {
		//Browser is opening as part of before hook in BaseTest		   
	}

	@When("User enter the URL as {string}")
	public void user_enter_the_url_as(String string) {
		navigation = new Navigation(driver);
		navigation.navigateToURL(string);					   
	}

	@Then("URL is redirected to {string}")
	public void url_is_redirected_to(String string) {
		landingPage = new LandingPage(driver);
		String actualURL = landingPage.getUrl();
		Assert.assertEquals(actualURL, string);
		
	}
	
	@Then("Page title is {string}")
	public void page_tile_is(String string) {
		String actualTitle = landingPage.getTitle();
		Assert.assertEquals(actualTitle, string);			    
	}

}
