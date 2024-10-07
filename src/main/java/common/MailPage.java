package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utils.DriverManagement;
import utils.SeleniumHelper;

import static utils.DriverManagement.driver;

public class MailPage extends BasePage {

    protected By editEmailBtn = By.xpath("//span[@id = 'inbox-id']");
    protected By emailTextBox = By.xpath("//span/input[@type = 'text']");
    protected By saveBtn = By.xpath("//span/button[@class = 'save button small']");
    protected By domainEmail = By.xpath("//select[@id = 'gm-host-select']");
    protected By useAliasChecBox = By.xpath("//input[@id = 'use-alias']");
    protected By emailFree = By.xpath("//span[@id = 'email-widget']");
    protected By emailConfirm = By.xpath("//tr[contains(@class, 'mail_row')]/td[@class = 'td3' and contains(text(), 'Please confirm your account')]");
    protected By emailResetPW = By.xpath("//tr[contains(@class, 'mail_row')]/td[@class = 'td3' and contains(text(), 'Please reset your password')]");
    protected By tokenLink = By.xpath("//div[@class = 'email_body']/a[@href]");
    protected By emailSubject = By.xpath("//h3[@class = 'email_subject']");

    public static void navigateToWebMail() {
        driver.switchTo().newWindow(WindowType.TAB);
        DriverManagement.driver.get("https://www.guerrillamail.com/inbox"); // Open the application
    }

    public String getMailFree(String email) {
        //get email
        driver.findElement(editEmailBtn).click();
        driver.findElement(emailTextBox).sendKeys(email );
        driver.findElement(saveBtn).click();

        //Get domain
        WebElement domainEmailtext = driver.findElement(domainEmail);
        Select selectdomainEmail = new Select(domainEmailtext);
        selectdomainEmail.selectByVisibleText("spam4.me");

        //Uncheck to uer alias checkbox
        driver.findElement(useAliasChecBox).click();

        return driver.findElement(emailFree).getText();
    }

    public void confirmEmail() {
        SeleniumHelper.refreshPage();
        SeleniumHelper.waitToLoadElement(emailConfirm);
        driver.findElement(emailConfirm).click(); //click emal confirm

        SeleniumHelper.scrollToElement(driver.findElement(emailSubject));
        driver.findElement(tokenLink).click(); //click Token link
    }

    public void resetPw() {
        SeleniumHelper.refreshPage();

        SeleniumHelper.waitToLoadElement(emailResetPW);
        driver.findElement(emailResetPW).click(); // click email reset PW

        SeleniumHelper.scrollToElement(driver.findElement(emailSubject));
        SeleniumHelper.waitToLoadElement(tokenLink);

        driver.findElement(tokenLink).click(); //click Token link
    }
}
