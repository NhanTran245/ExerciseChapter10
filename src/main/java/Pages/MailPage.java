package Pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utils.DriverManagement;

import static utils.DriverManagement.driver;

public class MailPage extends BasePage {

    protected By domainEmail = By.xpath("//select[@id = 'gm-host-select']");
    protected By emailFree = By.xpath("//span[@id = 'email-widget']");

    public static void navigateToWebMail() {
        driver.switchTo().newWindow(WindowType.TAB);
        DriverManagement.driver.get("https://www.guerrillamail.com/inbox"); // Open the application
    }

    public String getMailFree() {

        WebElement domainEmailtext = driver.findElement(domainEmail);
        Select selectdomainEmail = new Select(domainEmailtext);
        selectdomainEmail.selectByVisibleText("spam4.me");
        return driver.findElement(emailFree).getText();
    }

    public static void confirmEmail() {

    }

    public static void closeCurrentTab() {
        driver.close();
    }

    //    public void navigateToWebMail() {
//        driver.switchTo().newWindow(WindowType.TAB);
//        DriverManagement.driver.get("https://accounts.google.com/"); // Open the application
//    }
//
//    public void loginWebMail() {
//        this.navigateToWebMail();
//
//
//    }

    //    protected By emailTextBox = By.xpath("//input[@type = 'email']");
//    protected By nextBtn = By.xpath("//span[text() = 'Next']");
//    protected  By passwordTextBox = By.xpath("//input[@type = 'password']");

//    public void loginWebMail(String email, String password) {
//        this.navigateToWebMail();
//        driver.findElement(emailTextBox).sendKeys(email);
//        driver.findElement(passwordTextBox).sendKeys(password);
//        driver.findElement(nextBtn).click();
//
//    }
}
