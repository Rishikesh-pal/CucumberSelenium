package appfeatures;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/appfeatures",
        glue = "appfeatures",
        plugin = {"pretty", "html:target/cucumber-reports/report.html","rerun:target/failedrun.txt"},
        tags = "@regression"
)
public class MagnetoRunnerTest extends AbstractTestNGCucumberTests {
}
