package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utils.DriverManagement;
import utils.SeleniumHelper;

import static utils.DriverManagement.driver;

public class MailPage extends BasePage {

    protected By domainEmail = By.xpath("//select[@id = 'gm-host-select']");
    protected By emailFree = By.xpath("//span[@id = 'email-widget']");
    protected By emailConfirm = By.xpath("//tr[contains(@class, 'mail_row')]/td[@class = 'td3' and contains(text(), 'Please confirm your account')]");
    protected By confirmLink = By.xpath("//div[@class = 'email_body']/a[@href]");

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

    public void confirmEmail() {
        SeleniumHelper.waitToLoadElement(emailConfirm);
        SeleniumHelper.refreshPage();
        driver.findElement(emailConfirm).click();
        SeleniumHelper.scrollToElement(driver.findElement(confirmLink));
        driver.findElement(confirmLink).click();

    }
}
