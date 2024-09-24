package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverManagement.driver;

public class SeleniumHelper {
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

//    public static void waitToLoadElement(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement refreshedElement = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(element));
//    }

    public static void acceptAlert() {
        // Chờ cho Alert xuất hiện
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Chuyển sang Alert và nhấn "OK"
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
