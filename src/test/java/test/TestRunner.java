package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					features = "Features"
					,glue = "test"
					,tags = "@Regression"
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}