package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
	
	private WebDriverWait wait;
	private WebDriver driver;
	private JavascriptExecutor js;
	
	@FindBy(id="productTitle")
	private WebElement productName;
	
	@FindBy(xpath="//li[contains(@class, 'videoBlockDarkIngress')]")
	private WebElement videoThumbnail;
	
	@FindBy(xpath="//button[@aria-label='Close']")
	private WebElement videoCloseBtn;
	
	@FindBy(xpath="(//span[@class='a-price-whole'])[5]")
	private WebElement productPrice;
	
	@FindBy(id="glow-ingress-line2")
	private WebElement selectYourAddress;
	
	@FindBy(id="GLUXZipUpdateInput")
	private WebElement pinCodeTextBox;
	
	@FindBy(xpath="//input[@aria-labelledby='GLUXZipUpdate-announce']")
	private WebElement applyBtn;
	
	@FindBy(xpath="//span[contains(text(), 'Deliver to') and @id='glow-ingress-line1']")
	private WebElement deliverToText;
	
	@FindBy(id="ape_Detail_hero-quick-promo_Desktop_iframe")
	private WebElement sponseredLinkIFrame;
	
	@FindBy(xpath="//a[@class='ad-link absolute z-20 top-0 left-0 right-0 bottom-0']")
	private WebElement sponseredLink;	
	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	private WebElement addedToCartMsg;
	
	@FindBy(id="attach-close_sideSheet-link")
	private WebElement closeAddedToCartWindowLink;
	
	@FindBy(xpath="//h1[text()='Technical Details']")
	private WebElement technicalDetailsLabel;
	
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
		js = (JavascriptExecutor) driver;
		this.driver = driver;
	}	
	
	public boolean verifyPageTitleContainsProductName() {
		String productNameText = productName.getText();
		String pageTitle = driver.getTitle();
		return pageTitle.contains(productNameText);
	}
	
	public void playVideo() {
		videoThumbnail.click();
	}
	
	public void closeVideo() {
		videoCloseBtn.click();
	}
	
	public String getProductPrice() {
		return productPrice.getText();
	}
	
	public void clickOnSelectYourAddressLink() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(selectYourAddress));
		Thread.sleep(2000); //since explicit wait is not working here that's why used this hard wait
		selectYourAddress.click();	
	}
	
	public void waitForAddressPopUpToAppear() {
		wait.until(ExpectedConditions.visibilityOf(pinCodeTextBox));
	}
	
	public void enterPinCode(String pinCode) {
		pinCodeTextBox.sendKeys(pinCode);
	}
	
	public void clickOnApplyBtn() {
		applyBtn.click();
	}
	
	public String getTextFromDeliverTo() {
		wait.until(ExpectedConditions.visibilityOf(deliverToText));
		return deliverToText.getText();		
	}
	
	public void switchToSponseredLinkIFrame() {
		wait.until(ExpectedConditions.visibilityOf(sponseredLinkIFrame));
		driver.switchTo().frame(sponseredLinkIFrame);
	}
	
	public void clickOnSponseredLink() {
		//sponseredLink.click();
		js.executeScript("arguments[0].click();", sponseredLink); //sometime regular click is not working that's why used JavascriptExecutor click
	}
	
	public int getNumberOfWindowOpened() {
		return driver.getWindowHandles().size();
	}
	
	public void navigateToNewWindow() {
		for(String winHandle: driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public void closeNewWindow() {
		driver.close();		
	}
	
	public void navigateBackToPreviousWindow() {
		for(String winHandle: driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public void clickOnAddToCartBtn() {
		addToCartBtn.click();
	}
	
	public void waitForAddToCartSuccessWindow() {
		wait.until(ExpectedConditions.visibilityOf(addedToCartMsg));
	}
	
	public String getTextFromAddedToCartMsg() {
		return addedToCartMsg.getText();
	} 
	
	public void closeAddedToCartWindow() {
		closeAddedToCartWindowLink.click();
	}
	
	public void scrollPageDownUntilTechnicalDetails() {
		js.executeScript("arguments[0].scrollIntoView(true);", technicalDetailsLabel);
	}	

}
