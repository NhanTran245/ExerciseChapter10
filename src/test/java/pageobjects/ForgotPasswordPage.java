package pageobjects;

//import common.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import utils.SeleniumHelper;
//
//import static helper.DriverUtils.driver;

public class ForgotPasswordPage extends BasePage {

//    protected By emailTextBox = By.xpath("//input[@id= 'email']");
//    protected By sendBtn = By.xpath("//input[@type= 'submit']");
//    protected By pwChangeForm = By.xpath("//div[@id = 'content']/form/fieldset/legend[text() = 'Password Change Form']");
//    protected By newPWTextBox = By.xpath("//input[@id = 'newPassword']");
//    protected By confirmPWTextBox = By.xpath("//input[@id = 'confirmPassword']");
//    protected By resetTokenTextBox = By.xpath("//input[@id = 'resetToken']");
//    protected By resetPWBtn = By.xpath("//input[@type = 'submit']");
//    protected By errorMessage = By.xpath("//p[contains(@class, 'message')]");
//    protected By errorMessageConfirmPW = By.xpath("//label[@for = 'confirmPassword' and @class = 'validation-error']");
//
//
//    public ForgotPasswordPage enterEmailAddress(String email) {
//
//        driver.findElement(emailTextBox).sendKeys(email);
//        SeleniumHelper.scrollToElement(driver.findElement(sendBtn));
//        driver.findElement(sendBtn).click();
//
//        return new ForgotPasswordPage();
//    }
//    public WebElement getPWChangeForm() {
//        WebElement changePWForm =  driver.findElement(pwChangeForm);
//        return changePWForm;
//    }
//
//    public WebElement getResetPWToken() {
//        WebElement resetPWToken = driver.findElement(resetTokenTextBox);
//        return resetPWToken;
//    }
//
//    public void inputNewPW (String password, String confirmPW) {
//        driver.findElement(newPWTextBox).sendKeys(password);
//        driver.findElement(confirmPWTextBox).sendKeys(confirmPW);
//        SeleniumHelper.scrollToElement(driver.findElement(resetPWBtn));
//        driver.findElement(resetPWBtn).click();
//    }
//
//    public String getErrorMessage() {
//        return driver.findElement(errorMessage).getText();
//    }
//
//    public  String getErrorMessageConfirmPW() {
//        return driver.findElement(errorMessageConfirmPW).getText();
//    }

}
