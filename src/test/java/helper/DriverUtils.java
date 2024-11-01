package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtils {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static void initDriver(String browser) throws Exception {
        Logger.log("Create " + browser);
        switch (browser) {
            case ("chrome"): {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver.set(new ChromeDriver());
                break;
            }
            case ("firefox"): {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver.set(new FirefoxDriver());
                break;
            }
            default:
                var message = "Browser " + browser + " was not support";
                Logger.log(message);
                throw new Exception(message);
        }

    }
}
