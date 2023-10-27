package appfeatures;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@target/failedrun.txt"},
        glue = {"appfeatures"},
        plugin = {"pretty",
                "html:target/cucumber-reports/reports.html",
//                "rerun:target/failedrun.txt"
        }
)
public class MagnetoFailedRunnerTest extends AbstractTestNGCucumberTests {
}
