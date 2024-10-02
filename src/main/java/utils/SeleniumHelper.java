package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverManagement.driver;

public class SeleniumHelper {
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitToLoadElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitToLoadDropdown(By dropdownLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Đợi cho dropdown cũ không còn tồn tại
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(dropdownLocator)));
    }

    public static void acceptAlert() {
        // Chờ cho Alert xuất hiện
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Chuyển sang Alert và nhấn "OK"
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public static void closeCurrentTab() {
        driver.close();
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }




//    public static void getFirstOptionDropdown (WebElement element) {
//        WebElement dropdownElement = element;
//        Select dropdown = new Select(dropdownElement);
//        WebElement selectedOption = dropdown.getFirstSelectedOption();
//    };
}
