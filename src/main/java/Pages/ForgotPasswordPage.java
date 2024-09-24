package Pages;

import common.BasePage;
import org.openqa.selenium.By;

import static utils.DriverManagement.driver;

public class ForgotPasswordPage extends BasePage {

    protected By emailTextBox = By.xpath("//input[@id= 'email']");
    protected By sendBtn = By.xpath("//input[@type= 'submit']");

    public ForgotPasswordPage enterEmailAddress(String email) {

        driver.findElement(emailTextBox).sendKeys(email);
        driver.findElement(sendBtn).click();

        return new ForgotPasswordPage();
    }

}
