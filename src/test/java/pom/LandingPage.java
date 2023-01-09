package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	private WebDriver driver;
	private Actions actions;
	
	@FindBy(xpath="//span[text()='Hello, sign in']")
	private WebElement helloSignInLink;
	
	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement accountsAndListsLink;
	
	@FindBy(linkText="Create a Wish List")
	private WebElement createAWishListLink;
		
	@FindBy(xpath="(//span[text()='Sign in'])[1]")
	private WebElement signInBtn;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(xpath="//input[@value='Go']")
	private WebElement goBtn;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		this.driver = driver;
	}	
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void hoverOverHelloSignInLInk() {		
		actions.moveToElement(helloSignInLink).build().perform();
	}
	
	public void clickOnSignInBtn() {
		signInBtn.click();
	}
	
	public void hoverOverAccountsAndListsLink() {		
		actions.moveToElement(accountsAndListsLink).build().perform();
	}
	
	public void clickOnCreateAWishListLink() {
		createAWishListLink.click();
	}	
	
	public void enterTextInSearchBox(String text) {
		searchBox.sendKeys(text);
	}
	
	public void clickOnGoBtn() {
		goBtn.click();
	}	

}
