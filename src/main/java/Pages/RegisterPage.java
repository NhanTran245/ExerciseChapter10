package Pages;

import common.BasePage;
import common.MailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumHelper;

import java.util.Set;

import static utils.DriverManagement.driver;

public class RegisterPage extends BasePage {
    protected By usernameTextBox = By.xpath("//input[@id = 'email']");
    protected By passwordTextBox = By.xpath("//input[@id = 'password']");
    protected By confirmTextBox = By.xpath("//input[@id = 'confirmPassword']");
    protected By pidTextBox = By.xpath("//input[@id = 'pid']");
    protected By registerBtn = By.xpath("//input[@type = 'submit']");
    protected By errorMessage = By.xpath("//p[@class = 'message error']");
    protected By errorMessPw = By.xpath("//label[@for = 'password' and @class = 'validation-error']");
    protected By errorMessPID = By.xpath("//label[@for = 'pid' and @class = 'validation-error']");
    protected By header = By.xpath("//h1");
    protected By successMessage = By.xpath("//div[@id = 'content']/h1");
    protected By confirmMessage = By.xpath("//div[@id = 'content']/p");

    //Methods
    public RegisterPage registerAccount(String username, String password, String pid) {

        driver.findElement(usernameTextBox).sendKeys(username);
        driver.findElement(passwordTextBox).sendKeys(password);
        driver.findElement(confirmTextBox).sendKeys(password);
        driver.findElement(pidTextBox).sendKeys(pid);

        WebElement registerbtn = driver.findElement(registerBtn);
        SeleniumHelper.scrollToElement(registerbtn);
        registerbtn.click();
        return new RegisterPage();
    }

    public WebElement getErrorMessage() {
        WebElement errorMess = driver.findElement(errorMessage);
        return errorMess;
    }

    public WebElement getErrorMessPW() {
        WebElement errorMessPW = driver.findElement(errorMessPw);
        return errorMessPW;
    }

    public WebElement getErrorMessPID() {
        WebElement errorMessPid = driver.findElement(errorMessPID);
        return errorMessPid;
    }

    public WebElement getHeaderRegisterPage() {
        WebElement headerRegisterPage = driver.findElement(header);
        return headerRegisterPage;
    }

    public String getSuccessMess() {
        return driver.findElement(successMessage).getText();
    }

    public String getConfirmMess() {
        return driver.findElement(confirmMessage).getText();

    }

}
