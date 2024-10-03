package Pages;

import common.BasePage;
import common.MailPage;
import org.openqa.selenium.By;
import utils.SeleniumHelper;

import java.util.Set;

import static utils.DriverManagement.driver;

public class HomePage extends BasePage {

    protected By createAccLink = By.xpath("//a[text() = 'create an account']");

    public RegisterPage clickCreateAccLink() {
        driver.findElement(createAccLink).click();
        return new RegisterPage();
    }

    public void navigateBackToOriginalWindow (String originalWindow) {
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


}
