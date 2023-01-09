package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListPage {
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	@FindBy(xpath="(//div[@class='a-section a-spacing-small a-spacing-top-small']//child::span)[1]")
	private WebElement resultsDisplayedText;
	
	@FindBy(xpath="//i[@class='a-icon a-icon-star-medium a-star-medium-4']")
	private WebElement fourStarAndUpLink;
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement firstProduct;	
	
	
	public ProductListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
		this.driver = driver;
	}	
	
	public String getTextFromResultsDisplayedText() {
		return resultsDisplayedText.getText();		
	}
	
	public void clickOnFourStarAndUpLink() {
		fourStarAndUpLink.click();	
	}

	public void clickOnFirstProduct() {		
		wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
		firstProduct.click();
	}
	
	public void switchToNewTabOpened() {
		for(String winHandle: driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

}
