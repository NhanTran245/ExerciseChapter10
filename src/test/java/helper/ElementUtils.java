package helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtils
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
        WebElement element = ElementUtils.findElement(locator);
        ((JavascriptExecutor) DriverUtils.driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForElementNotExists(By locator, int timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(DriverUtils.driver.get(), Duration.ofSeconds(timeoutInSecond));

        // Đợi cho dropdown cũ không còn tồn tại
        wait.until(ExpectedConditions.stalenessOf(ElementUtils.findElement(locator)));
    }

    public static void acceptAlert(int timeoutInSecond) {
        // Chờ cho Alert xuất hiện
        WebDriverWait wait = new WebDriverWait(DriverUtils.driver.get(), Duration.ofSeconds(timeoutInSecond));
        wait.until(ExpectedConditions.alertIsPresent());

        // Chuyển sang Alert và nhấn "OK"
        Alert alert = DriverUtils.driver.get().switchTo().alert();
        alert.accept();
    }

}
