package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInEmailPage {
	

	@FindBy(id="ap_email")
	private WebElement emailTextBox;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	@FindBy(xpath="//h1[@class='a-spacing-small']")
	private WebElement loginLabel;
	
	@FindBy(xpath="//span[@class='a-list-item']")
	private WebElement invalidEmailError;
	
	public LogInEmailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);		
	}
	
	public void clickOnContinueBtn() {
		continueBtn.click();
	}
	
	public String getLoginLabel() {
		return loginLabel.getText();
	}
	
	public String getInvalidEmailErrorText() {
		return invalidEmailError.getText();
	}

}
