package Pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverManagement.driver;

public class LoginPage extends BasePage {
    protected By usernameTextBox = By.xpath("//input[@id = 'username']");
    protected By pwTextBox = By.xpath("//input[@id = 'password']");
    protected By loginBtn = By.xpath("//input[@type = 'submit']");
    protected By welcomeMessage = By.xpath("//div[@class='account']");
    protected By errorMessage = By.xpath("//p[@class = 'message error LoginForm']");
    protected By forgotPWlink = By.xpath("//a[text() = 'Forgot Password page']");

    //Methods
    public HomePage loginAccount(String username, String password) { //nen tra ve 1 page cu  the//
        driver.findElement(usernameTextBox).sendKeys(username);
        driver.findElement(pwTextBox).sendKeys(password);
        driver.findElement(loginBtn).click();

        return new HomePage();
    }

    public WebElement getWelcomeMessage() {
        WebElement welcomeMess = driver.findElement(welcomeMessage);
        return welcomeMess;
    }

    public WebElement getErrorMessage() {
        WebElement errorMess = driver.findElement(errorMessage);
        return errorMess;
    }

    public String getWarningMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public ForgotPasswordPage clickForgotPasswordPage() {
        driver.findElement(forgotPWlink).click();

        return new ForgotPasswordPage();
    }

}
