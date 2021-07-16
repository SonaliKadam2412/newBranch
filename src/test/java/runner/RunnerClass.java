package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\91812\\git\\SeleniumFrameWork\\src\\test\\resources\\Instagram.feature", tags = {"@Test"}, plugin = {"pretty", "html:target/cucumber-html-report",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml"}, glue = {"step_definition.Step_Definition"}


)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
