package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	
	@FindBy(xpath="//div[@role='heading']")
	private WebElement yourLists;
	
	public WishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	public String validatePage() {
		return yourLists.getText();	
		
	}

}
