package helper;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {
    public static void navigateTo (String url) {
        Logger.log("Navigate to " + url);
        DriverUtils.driver.get().get(url);
    }

    public static void maximize() {
        Logger.log("Maximize browser");
        DriverUtils.driver.get().manage().window().maximize();
    }

    public static void close() {
        Logger.log("Close browser");
        DriverUtils.driver.get().quit();
    }

    public static void waitForTitle(String title, int timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(DriverUtils.driver.get(), Duration.ofSeconds(timeoutInSecond));
        wait.until(ExpectedConditions.titleIs(title));
    }

}
