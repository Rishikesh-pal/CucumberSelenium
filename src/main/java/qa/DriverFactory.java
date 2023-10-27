package qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;

    public WebDriver initBrowser(String browser) {
        /* This is used if we have to explicitly open browser as well as need the driver instance
         */
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        /* This is used only to have the instance wherever required
        This is taken static asif we have to use only instace no need
        to create object amd to prevent memory as well
         */
        return driver;
    }

}
