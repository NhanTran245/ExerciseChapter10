package pageobjects;

import dataobjects.User;
import helper.Constant;
import helper.ElementUtils;
import helper.Logger;
import org.openqa.selenium.By;

public class PasswordResetPage extends BasePage{
    private By pwChangeForm = By.xpath("//div[@id = 'content']/form/fieldset/legend[text() = 'Password Change Form']");
    private By newPWTextBox = By.xpath("//input[@id = 'newPassword']");
    private By confirmPWTextBox = By.xpath("//input[@id = 'confirmPassword']");
    private By resetTokenTextBox = By.xpath("//input[@id = 'resetToken']");
    private By resetPWBtn = By.xpath("//input[@type = 'submit']");
    private By errorMessage = By.xpath("//p[contains(@class, 'message')]");
    private By errorMessageConfirmPW = By.xpath("//label[@for = 'confirmPassword' and @class = 'validation-error']");

    public PasswordResetPage() {
        pageTitle = "Safe Railway - Password Reset";
    }

    public Boolean isPWChangeFormExist() {
        return ElementUtils.isElementExists(pwChangeForm, Constant.ELEMENT_WAIT_TIMEOUT);
    }

    public void inputNewPW (User user) {
        Logger.log("Enter new password");
        waitForPageLoad();
        ElementUtils.waitForElementExists(resetPWBtn, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.scrollToElement(resetPWBtn);

        ElementUtils.findElement(newPWTextBox).sendKeys(user.getPassword());
        if (user.getPid() == null) {
            ElementUtils.findElement(confirmPWTextBox).sendKeys(user.getPassword());
        } else {ElementUtils.findElement(confirmPWTextBox).sendKeys(user.getPid());}
        ElementUtils.findElement(resetPWBtn).click();
    }

    public String getResetToken() {
        try {
            ElementUtils.waitForLoadElement(resetTokenTextBox, Constant.ELEMENT_WAIT_TIMEOUT);
            return ElementUtils.findElement(resetTokenTextBox).getAttribute("value");
        }
        catch (Exception e) {
            return "";
        }

    }

    public String getErrorMessage() {
        try {
            return ElementUtils.findElement(errorMessage).getText().trim();
        }
        catch (Exception e) {
            return "";
        }

    }
    public String getErrorMessageConfirmPW() {
        try {
            return ElementUtils.findElement(errorMessageConfirmPW).getText().trim();
        }
        catch (Exception e) {
            return "";
        }

    }
}
