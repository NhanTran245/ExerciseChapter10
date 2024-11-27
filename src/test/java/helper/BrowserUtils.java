package helper;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

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

    public static void waitForNewTab(String currentTab, int timeoutInSecond) {
        Logger.log("Wait for new tab");
        WebDriverWait wait = new WebDriverWait(DriverUtils.driver.get(), Duration.ofSeconds(timeoutInSecond));
        // Chờ cho đến khi có ít nhất 2 tab mở
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(DriverUtils.driver) {
                return driver.get().getWindowHandles().size() > 1;
            }
        });
    }

    public static void switchToNewTab(String currentTab) {
        Logger.log("Switch to new tab, navigate to:" + currentTab);
        Set<String> allTabs = driver.get().getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(currentTab)) {
                driver.get().switchTo().window(tab);  // Chuyển sang tab mới
                break;
            }
        }
    }

}
