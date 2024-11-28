package pageobjects;

import dataobjects.User;
import helper.Constant;
import helper.ElementUtils;
import org.openqa.selenium.By;

public class PasswordResetPage extends BasePage{
    private By pwChangeForm = By.xpath("//div[@id = 'content']/form/fieldset/legend[text() = 'Password Change Form']");
    private By newPWTextBox = By.xpath("//input[@id = 'newPassword']");
    private By confirmPWTextBox = By.xpath("//input[@id = 'confirmPassword']");
    private By resetTokenTextBox = By.xpath("//input[@id = 'resetToken']");
    private By resetPWBtn = By.xpath("//input[@type = 'submit']");
    public PasswordResetPage() {
        pageTitle = "Safe Railway - Password Reset";
    }

    public Boolean isPWChangeFormExist() {
        return ElementUtils.isElementExists(pwChangeForm, Constant.ELEMENT_WAIT_TIMEOUT);
    }

    public void inputNewPW (User user) {
        ElementUtils.findElement(newPWTextBox).sendKeys(password);
        ElementUtils.findElement(confirmPWTextBox).sendKeys(confirmPW);
        ElementUtils.scrollToElement(resetPWBtn);
        ElementUtils.findElement(resetPWBtn).click();
    }


}
