package helper;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.DriverUtils.driver;

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

    public static void switchToNewTab(String url) {
        Logger.log("Switch to new tab, navigate to:" + url);
        DriverUtils.driver.get().switchTo().newWindow(WindowType.TAB);
        DriverUtils.driver.get().get(url); // Open the web mail tab
    }

    public static String saveWindowHandle() {
        String saveWindowHandle = DriverUtils.driver.get().getWindowHandle();
        return saveWindowHandle;
    }

    public static void navigateNewURL(String url) {
        Logger.log("Navigate to" + url);
        DriverUtils.driver.get().get(url);
    }

}
