package test;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LandingPage;
import pom.LogInEmailPage;
import pom.LoginPasswordPage;
import pom.UserLandingPage;
import utils.ManageBrowser;

public class ValidInvalidLoginTest extends Driver {

	private ManageBrowser manageBrowser;
	private LandingPage landingPage;
	private LogInEmailPage logInEmailPage;
	private LoginPasswordPage loginPasswordPage;
	private UserLandingPage userLandingPage;
	
	
	@Given("User is on Amazon landing page")
	public void user_is_on_amazon_landing_page() {
		manageBrowser = new ManageBrowser();
		manageBrowser.navigateToURL();		
	}

	@When("He hovers over Hello, Sign in")
	public void he_hovers_over_hello_sign_in() {
		landingPage = new LandingPage(driver);
		landingPage.hoverOverHelloSignInLInk();	    
	}

	@When("Clicks on Sign in button")
	public void clicks_on_sign_in_button() {
		landingPage.clickOnSignInBtn();	    
	}

	@When("Provides the valid email {string} in the text box")
	public void provides_the_valid_email_in_the_text_box(String string) {
		logInEmailPage = new LogInEmailPage(driver);
		logInEmailPage.enterEmail(string);	    
	}

	@When("Clicks on the Continue button")
	public void clicks_on_the_continue_button() {
		logInEmailPage.clickOnContinueBtn();	    
	}

	@When("Provides the valid password {string} in the text box")
	public void provides_the_valid_password_in_the_text_box(String string) {
		loginPasswordPage = new LoginPasswordPage(driver);
		loginPasswordPage.enterPassword(string);	    
	}

	@When("Clicks on Login button")
	public void clicks_on_login_button() {
		loginPasswordPage.clickOnLoginBtn();	    
	}

	@Then("He is successfully able to login")
	public void he_is_successfully_able_to_login() {
		userLandingPage = new UserLandingPage(driver);	
		Assert.assertTrue(userLandingPage.validateSuccessfulLogin());
	}

	@Then("He hovers over Account and Lists")
	public void he_hovers_over_account_and_lists() {
		userLandingPage.hoverOverAccountsAndListsLink();
	    
	}

	@Then("Clicks on Sign Out link")
	public void clicks_on_sign_out_link() {
		userLandingPage.clickOnSignOutLink();
	}

	@Then("Login page appears")
	public void login_page_appears() {
		Assert.assertTrue(logInEmailPage.getLoginLabel().contains("Login"));		
	}
	
	@When("Provides the invalid email {string} in the text box")
	public void provides_the_invalid_email_in_the_text_box(String string) {
		logInEmailPage = new LogInEmailPage(driver);
		logInEmailPage.enterEmail(string);	
	}

	@Then("He gets an error message in the same email page as {string}")
	public void he_gets_an_error_message_in_the_same_email_page_as(String string) {
	    Assert.assertTrue(logInEmailPage.getInvalidEmailErrorText().contains(string));
	}

	@When("Provides the invalid password {string} in the text box")
	public void provides_the_invalid_password_in_the_text_box(String string) {
		loginPasswordPage = new LoginPasswordPage(driver);
		loginPasswordPage.enterPassword(string);
	}

	@Then("He gets an error message in the same password page as {string} or {string}")
	public void he_gets_an_error_message_in_the_same_password_page_as(String string, String string2) {
		boolean errorTextMatch = false;
		String actualErrorText = loginPasswordPage.getInvalidPasswordErrorText();
		
		if (actualErrorText.contains(string) || actualErrorText.contains(string2)) {
			errorTextMatch = true;
		}
		
		Assert.assertTrue(errorTextMatch);	   
	}
	
}
