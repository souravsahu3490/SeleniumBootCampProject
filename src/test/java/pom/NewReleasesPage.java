package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewReleasesPage {
	
	@FindBy(id="zg_banner_text")
	private WebElement hotNewReleases;
	
	public NewReleasesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	public String validatePage() {
		return hotNewReleases.getText();
		
	}

}
