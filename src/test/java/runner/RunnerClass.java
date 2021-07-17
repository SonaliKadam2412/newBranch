package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Instagram.feature"
        ,glue = {"step_definition"}
        ,monochrome = true
        ,plugin = {"html:target/Report/cucumber-html-report", "json:target/Report/cucumber-json-report.json" }
)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
