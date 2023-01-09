package pom;

import org.openqa.selenium.WebDriver;

public class Navigation {
	
	WebDriver driver;
	
	public Navigation(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void navigateToURL(String url) {
		driver.get(url);
	}
}
