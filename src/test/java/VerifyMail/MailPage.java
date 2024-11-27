package VerifyMail;

import helper.BrowserUtils;
import helper.Constant;
import helper.ElementUtils;
import helper.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pageobjects.BasePage;

import static helper.DriverUtils.driver;

public class MailPage extends BasePage {
    private By editEmailBtn = By.xpath("//span[@id = 'inbox-id']");
    private By emailTextBox = By.xpath("//span/input[@type = 'text']");
    private By saveBtn = By.xpath("//span/button[@class = 'save button small']");
    private By domainEmail = By.xpath("//select[@id = 'gm-host-select']");
    private By emailConfirm = By.xpath("//tr[contains(@class, 'mail_row')]/td[@class = 'td3' and contains(text(), 'Please confirm your account')]");
    private By emailResetPW = By.xpath("//tr[contains(@class, 'mail_row')]/td[@class = 'td3' and contains(text(), 'Please reset your password')]");
    private By tokenLink = By.xpath("//div[@class = 'email_body']/a");
    private By emailSubject = By.xpath("//h3[@class = 'email_subject']");
    private By AliasCheckBox = By.xpath("//input[@id = 'use-alias']");

    public MailPage() {
        pageTitle = "✉ Guerrilla Mail - Disposable Temporary E-Mail Address";
    }
    public void getMailFree(String email) {
        Logger.log("Create email free");
        waitForPageLoad();
        //get email
        ElementUtils.findElement(editEmailBtn).click();
        ElementUtils.findElement(emailTextBox).sendKeys(email);
        ElementUtils.findElement(saveBtn).click();

        //Get domainEmail
        Select selectDomainEmail = new Select(ElementUtils.findElement(domainEmail));
        selectDomainEmail.selectByVisibleText(Constant.DOMAIN_EMAIL);
    }

    public void confirmEmail() {
        Logger.log("Confirm your account");
        ElementUtils.waitForLoadElement(emailConfirm, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.findElement(emailConfirm).click(); //click email confirm

        // Lưu lại handle hiện tại của tab
        String currentTab = driver.get().getWindowHandle();

        Logger.log("Click confirm link");
        ElementUtils.waitForElementClickable(tokenLink, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.scrollToElement(emailSubject);
        ElementUtils.findElement(tokenLink).click(); //click Token link
    }
}
