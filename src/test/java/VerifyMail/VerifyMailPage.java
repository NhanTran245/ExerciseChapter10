package VerifyMail;

import helper.Constant;
import helper.DriverUtils;
import helper.ElementUtils;
import helper.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import pageobjects.BasePage;

import static helper.DriverUtils.driver;

public class VerifyMailPage extends BasePage {
    private By editEmailBtn = By.xpath("//span[@id = 'inbox-id']");
    private By emailTextBox = By.xpath("//span/input[@type = 'text']");
    private By saveBtn = By.xpath("//span/button[@class = 'save button small']");
    private  By domainEmail = By.xpath("//select[@id = 'gm-host-select']");
    private By emailFree = By.xpath("//span[@id = 'email-widget']");
    private By emailConfirm = By.xpath("//tr[contains(@class, 'mail_row')]/td[@class = 'td3' and contains(text(), 'Please confirm your account')]");
    private By emailResetPW = By.xpath("//tr[contains(@class, 'mail_row')]/td[@class = 'td3' and contains(text(), 'Please reset your password')]");
    private By tokenLink = By.xpath("//div[@class = 'email_body']/a[@href]");
    private By emailSubject = By.xpath("//h3[@class = 'email_subject']");

    public static void navigateToWebMail() {
        driver.get().switchTo().newWindow(WindowType.TAB);
        driver.get().get(Constant.URL_WEB_MAIL); // Open the application
    }

    public void getMailFree(String email) {
        Logger.log("Create email free");
        //get email
        ElementUtils.findElement(editEmailBtn).click();
        ElementUtils.findElement(emailTextBox).sendKeys(email);
        ElementUtils.findElement(saveBtn).click();
    }

    public void confirmEmail() {
        ElementUtils.waitForLoadElement(emailConfirm, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.findElement(emailConfirm).click(); //click email confirm

        ElementUtils.scrollToElement(emailSubject);
        ElementUtils.findElement(tokenLink).click(); //click Token link
    }
}
