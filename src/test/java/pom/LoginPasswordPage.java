package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPasswordPage {
	
	@FindBy(id="ap_password")
	private WebElement passwordTextBox;
	
	@FindBy(id="signInSubmit")
	private WebElement loginBtn;
	
	@FindBy(xpath="//span[@class='a-list-item']")
	private WebElement invalidPasswordError;
	
	public LoginPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	public void enterPassword(String email) {
		passwordTextBox.sendKeys(email);		
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}

	public String getInvalidPasswordErrorText() {
		return invalidPasswordError.getText();
	}
}
