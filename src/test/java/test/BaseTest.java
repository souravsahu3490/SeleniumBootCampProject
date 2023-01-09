package test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ManageBrowser;

public class BaseTest extends Driver {
	
		
	@Before
	public void setUpBrowser(Scenario scenario) {
		ManageBrowser manageBrowser = new ManageBrowser();
		manageBrowser.openBrowser();	
		driver = manageBrowser.getDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
