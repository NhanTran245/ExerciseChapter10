package Pages;

import common.BasePage;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static utils.DriverManagement.driver;

public class HomePage extends BasePage {

    protected By createAccLink = By.xpath("//a[text() = 'create an account']");

    public RegisterPage clickCreateAccLink() {
        driver.findElement(createAccLink).click();
        return new RegisterPage();
    }

    public void navigateBackToOriginalWindow(String originalWindow) {
        driver.switchTo().window(originalWindow);
    }

    public String saveWindownHandle() {
        String originalWindow = driver.getWindowHandle();
        return originalWindow;
    }

    public void switchWindow(String originalWindow) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) { // neu tab hien tai hong phai tab original(goc) thi chuyen sang tab moi
                driver.switchTo().window(windowHandle);
                break;  // Sau khi chuyển sang tab moi thì thoát khỏi vòng lặp
            }
        }
    }

    public void windowTest(String originalWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(allWindows);  // Chuyển Set thành List để có thể truy cập theo chỉ mục

        // Đảm bảo có ít nhất 2 tab
        if (windowList.size() > 1) {
            // Đóng tab đầu tiên
            driver.switchTo().window(windowList.get(0));  // Chuyển sang tab đầu tiên
            driver.close();  // Đóng tab đầu tiên

            // Chuyển sang tab thứ hai (index = 1)
            driver.switchTo().window(windowList.get(1));  // Chuyển sang tab thứ 2
        }
    }

    public void switchTest(int tabIndex, String originalWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(allWindows);  // Chuyển Set thành List để có thể truy cập theo chỉ mục

        if (tabIndex < windowList.size()) {
            driver.switchTo().window(windowList.get(tabIndex));
        } else {
            System.out.println("Tab index " + tabIndex + " is out of bounds.");
        }
    }

}