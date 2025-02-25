package StepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features/leaf.feature",glue = {"StepDefinition"},snippets = CucumberOptions.SnippetType.CAMELCASE, monochrome =true,
        plugin = {"pretty", "html:target/cucumber-reports.html"})
public class Runnerclass extends AbstractTestNGCucumberTests {


}
