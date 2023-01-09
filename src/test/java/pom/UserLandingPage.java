package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLandingPage {
	
	private Actions actions;

	@FindBy(id="nav-link-accountList-nav-line-1")
	private WebElement userText;
	
	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement accountsAndListsLink;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement signOutLink;
	
	public UserLandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}	
	
	public boolean validateSuccessfulLogin() {
		return userText.getText().contains("Hello");
	}
	
	public void hoverOverAccountsAndListsLink() {
		actions.moveToElement(accountsAndListsLink).build().perform();
	}
	
	public void clickOnSignOutLink() {
		signOutLink.click();
	}

}
