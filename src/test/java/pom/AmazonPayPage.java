package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPayPage {
	
	@FindBy(xpath="//h1[text()='Scan & Pay']")
	private WebElement scanNPay;
	
	public AmazonPayPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	public String validatePage() {
		return scanNPay.getText();	
		
	}

}
