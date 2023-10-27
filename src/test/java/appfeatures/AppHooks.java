package appfeatures;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import qa.DriverFactory;
import utility.ConfigLoader;

import java.io.IOException;
import java.util.Objects;

public class AppHooks {
    DriverFactory driverFactory;
    WebDriver driver;

    @Before
    public void launchBrowser() throws IOException {
        driverFactory = new DriverFactory();
        /*
        To run in headless mode
         */

        String headless = System.getProperty("headless");
        if (Objects.equals(headless, "true")){
            System.out.println("running with UI mode");
        }else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("headless");
        }

        /*
        To take input from cli we have to use the following method
         */
        String configBrowser  = ConfigLoader.readConfigData("browser");
        String mavenCommandBrowser = System.getProperty("clibrowser");
        if(mavenCommandBrowser!=null){
            configBrowser = mavenCommandBrowser;
        }
        driver = driverFactory.initBrowser(configBrowser);
        driver.manage().window().maximize();
    }

    @After(order = 2)
    public void tearDown(Scenario scenario){
        /* Detail info regarding Scenerio interface
          https://priyank-it.medium.com/cucumber-scenario-interface-usage-148b465dd51 */
        if (scenario.isFailed()) {
            /*To get clear name of the scenario that has been failed using this method
             if not then will display scenario name with garbage value making it hard to understand */
            String nameOfScenario = scenario.getName().replace(" ","_");
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver; // Typecasting to driver type
            byte[] source = takesScreenshot.getScreenshotAs(OutputType.BYTES); //In cucumber taken screenshot is stored in byte array so storing it accordingly
            scenario.attach(source , "image/png", nameOfScenario); //attach method of scenario
        }
    }

    @After(order = 1)
    public void closingBrowser()
    {
        driver.quit();
    }

}
