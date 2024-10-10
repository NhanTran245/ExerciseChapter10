package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class SeleniumHelper {
//    public static void scrollToElement(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    }
//
//    public static void waitToLoadElement(By element) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//    }
//
//    public static void waitToLoadDropdown(By dropdownLocator) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Đợi cho dropdown cũ không còn tồn tại
//        wait.until(ExpectedConditions.stalenessOf(driver.findElement(dropdownLocator)));
//    }
//
//    public static void acceptAlert() {
//        // Chờ cho Alert xuất hiện
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        // Chuyển sang Alert và nhấn "OK"
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//    }
//
//    public static void refreshPage() {
//        driver.navigate().refresh();
//    }
//
//    public static void navigateBackToOriginalWindow(String originalWindow) {
//        driver.switchTo().window(originalWindow);
//    }
//
//    public static String saveWindownHandle() {
//        String originalWindow = driver.getWindowHandle();
//        return originalWindow;
//    }
//
//    public static void switchTab(String originalWindow) {
//        Set<String> allWindows = driver.getWindowHandles();
//
//        for (String windowHandle : allWindows) {
//            if (!windowHandle.equals(originalWindow)) { // neu tab hien tai hong phai tab original(goc) thi chuyen sang tab moi
//                driver.switchTo().window(windowHandle);
//                break;  // Sau khi chuyển sang tab moi thì thoát khỏi vòng lặp
//            }
//        }
//    }
//
//    public static void switchWindow(int tabIndex, String originalWindow) {
//        Set<String> allWindows = driver.getWindowHandles();
//        List<String> windowList = new ArrayList<>(allWindows);  // Chuyển Set thành List để có thể truy cập theo chỉ mục
//
//        if (tabIndex < windowList.size()) {
//            driver.switchTo().window(windowList.get(tabIndex));
//
//        } else {
//            System.out.println("Tab index " + tabIndex + " is out of bounds.");
//        }
//    }

}
