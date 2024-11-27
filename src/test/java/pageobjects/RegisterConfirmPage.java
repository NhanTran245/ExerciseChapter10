package pageobjects;

import helper.ElementUtils;
import org.openqa.selenium.By;

public class RegisterConfirmPage extends BasePage{
    private By confirmMessage = By.xpath("//div[@id = 'content']/p");

    public RegisterConfirmPage() {
        pageTitle = "Safe Railway - Registration Confirmation Page";
    }

    public String getConfirmMessage() {
        try {
            return ElementUtils.findElement(confirmMessage).getText().trim();
        }
        catch (Exception e) {
            return "";
        }
    }
}
