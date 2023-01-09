package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test.Driver;

public class ManageBrowser extends Driver {
	
	private ReadProperties readProperties;
	private String browser;
	private String url;
	
	public ManageBrowser() {
		readProperties = new ReadProperties();
	}
	
	public void openBrowser() {
		
		browser = readProperties.readProperty("browser");		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}	
	}

	public void navigateToURL() {
		url = readProperties.readProperty("url");
		driver.get(url);
	}
	
	public void navigateToURL(String url) {
		driver.get(url);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void quitBrowser() {
		driver.quit();
	}
}
