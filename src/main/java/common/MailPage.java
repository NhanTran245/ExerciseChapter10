package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utils.DriverManagement;

import static utils.DriverManagement.driver;

public class MailPage {

    protected By emailTextBox = By.xpath("//input[@type = 'email']");
    protected By nextBtn = By.xpath("//span[text() = 'Next']");
    protected  By passwordTextBox = By.xpath("//input[@type = 'password']");
    public void navigateToWebMail() {
        driver.switchTo().newWindow(WindowType.TAB);
        DriverManagement.driver.get("https://accounts.google.com/"); // Open the application
    }

    public void loginWebMail() {

    }
}
