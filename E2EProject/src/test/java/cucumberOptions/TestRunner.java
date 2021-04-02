package cucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/Login.feature", glue = "stepDefinition")
//"features" = The path to the feature file and "glue" the 

public class TestRunner extends AbstractTestNGCucumberTests{

}




