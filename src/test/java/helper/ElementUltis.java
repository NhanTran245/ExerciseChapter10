package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUltis
{
    public static WebElement findElement (By locator) {
        return DriverUtils.driver.get().findElement(locator);
    }

    public static List<WebElement> findElements (By locator) {
        return DriverUtils.driver.get().findElements(locator);
    }

    public static void waitForElementExists (By locator, int timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(DriverUtils.driver.get(), Duration.ofSeconds(timeoutInSecond));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementClickable (By locator, int timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(DriverUtils.driver.get(), Duration.ofSeconds(timeoutInSecond));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean isElementExists (By locator, int timeoutForSecond) {
        try {
            waitForElementExists(locator, timeoutForSecond);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public static void scrollToElement(By locator) {
        WebElement element = ElementUltis.findElement(locator);
        ((JavascriptExecutor) DriverUtils.driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
