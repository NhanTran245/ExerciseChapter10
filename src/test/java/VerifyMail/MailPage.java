package VerifyMail;

import helper.BrowserUtils;
import helper.Constant;
import helper.ElementUtils;
import helper.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pageobjects.BasePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static helper.DriverUtils.driver;

public class MailPage extends BasePage {
    private By editEmailBtn = By.xpath("//span[@id = 'inbox-id']");
    private By emailTextBox = By.xpath("//span/input[@type = 'text']");
    private By saveBtn = By.xpath("//span/button[@class = 'save button small']");
    private By domainEmail = By.xpath("//select[@id = 'gm-host-select']");
    private By emailBody = By.xpath("//div[@class = 'email_body']");
    private By emailConfirm = By.xpath("//tr[contains(@class, 'mail_row')]/td[@class = 'td3' and contains(text(), 'Please confirm your account')]");
    private By emailResetPW = By.xpath("//tr[contains(@class, 'mail_row')]/td[@class = 'td3' and contains(text(), 'Please reset your password')]");
    private By link = By.xpath("//div[@class = 'email_body']/a");
    private By emailSubject = By.xpath("//h3[@class = 'email_subject']");
    private By AliasCheckBox = By.xpath("//input[@id = 'use-alias']");
    private String token; // Bien luu token
    private String clickLink; // Bien luu link

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

    public void clickConfirmEmail() {
        Logger.log("Click Email to confirm your account");
        ElementUtils.waitForLoadElement(emailConfirm, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.findElement(emailConfirm).click(); //click email confirm

//        ElementUtils.waitForLoadElement(emailBody, Constant.ELEMENT_WAIT_TIMEOUT);
//
//        Logger.log("Get email content");
//        String emailContent = ElementUtils.findElement(emailBody).getText();
//
//        Logger.log("Extract reset link from email content");
//        String resetLink = extractLinkFromEmail(emailContent); // Trích xuất reset link từ email
//
//        Logger.log("Extracted Reset Link: " + resetLink);
//
//        // Mở reset link trong trình duyệt
//        driver.get().navigate().to(resetLink);

        // Lưu lại handle hiện tại của tab
        String currentTab = driver.get().getWindowHandle();

        Logger.log("Click confirm link");
        ElementUtils.waitForElementClickable(link, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.scrollToElement(emailSubject);
        ElementUtils.findElement(link).click(); //click Token link

        // Chờ tab mới mở ra và chuyển sang tab đó
        BrowserUtils.waitForNewTab(currentTab, Constant.ELEMENT_WAIT_TIMEOUT);
        BrowserUtils.switchToNewTab(currentTab);
    }

    public void clickResetPWEmail() {
        Logger.log("Click Reset PW Email");
        ElementUtils.waitForLoadElement(emailResetPW, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.findElement(emailResetPW).click(); // click email reset PW

        // Lưu lại handle hiện tại của tab
        String currentTab = driver.get().getWindowHandle();

        ElementUtils.waitForLoadElement(emailBody, Constant.ELEMENT_WAIT_TIMEOUT);

        Logger.log("Get email content");
        String emailContent = ElementUtils.findElement(emailBody).getText();

        Logger.log("Extract token from email content");
        this.token = extractTokenFromEmail(emailContent); // Lấy token từ email
        Logger.log("Extracted Token: " + token);

//        Logger.log("Extract reset link from email content");
//        String resetLink = extractLinkFromEmail(emailContent); // Trích xuất reset link từ email
//
//        Logger.log("Extracted Reset Link: " + resetLink);
//
//        // Mở reset link trong trình duyệt
//        driver.get().navigate().to(resetLink);

        Logger.log("Click reset PW link");
        ElementUtils.waitForElementClickable(link, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.scrollToElement(emailSubject);
        ElementUtils.findElement(link).click(); //click Token link

//         Chờ tab mới mở ra và chuyển sang tab đó
        BrowserUtils.waitForNewTab(currentTab, Constant.ELEMENT_WAIT_TIMEOUT);
        BrowserUtils.switchToNewTab(currentTab);
    }
// Phương thức phụ trợ để trích xuất token từ nội dung email
    private String extractTokenFromEmail(String emailContent) {
        // Regex để tìm token
        String regex = "The token is: ([a-zA-Z0-9+/=]+)\\.";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailContent);

        // Nếu tìm thấy token, trả về token
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new RuntimeException("Token not found in the email content!");
        }
    }
// Phương thức phụ trợ để trích xuất reset link từ nội dung email
    private String extractLinkFromEmail(String emailContent) {
        // Regex để tìm URL
        String regex = "http[s]?://[\\w./?=&]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailContent);

        // Trả về URL đầu tiên tìm thấy
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new RuntimeException("Reset link not found in the email content!");
        }
    }
    public String getToken() {
        return token;
    }
}
