package pageobjects;

//import common.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import utils.SeleniumHelper;
//import static helper.DriverUtils.driver;

import dataobjects.User;
import helper.Constant;
import helper.ElementUtils;
import helper.Logger;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private By usernameTextBox = By.xpath("//input[@id = 'email']");
    private By passwordTextBox = By.xpath("//input[@id = 'password']");
    private By confirmTextBox = By.xpath("//input[@id = 'confirmPassword']");
    private By pidTextBox = By.xpath("//input[@id = 'pid']");
    private By registerBtn = By.xpath("//input[@type = 'submit']");
    private By errorMessage = By.xpath("//p[@class = 'message error']");
    private By errorMessPw = By.xpath("//label[@for = 'password' and @class = 'validation-error']");
    private By errorMessPID = By.xpath("//label[@for = 'pid' and @class = 'validation-error']");

    public RegisterPage() {
        pageTitle = "Safe Railway - Register an Account";
    }

    public void registerAccount (User user) {
        Logger.log("Register account");
        waitForPageLoad();
        ElementUtils.waitForElementExists(registerBtn, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.scrollToElement(registerBtn);

        ElementUtils.findElement(usernameTextBox).sendKeys(user.getEmail());
        ElementUtils.findElement(passwordTextBox).sendKeys(user.getPassword());
        ElementUtils.findElement(confirmTextBox).sendKeys(user.getPassword());
        ElementUtils.findElement(pidTextBox).sendKeys(user.getPid());
        ElementUtils.findElement(registerBtn).click();
    }

    public String getErrorMessage() {
        try {
            return ElementUtils.findElement(errorMessage).getText().trim();
        }
        catch (Exception e) {
            return "";
        }
    }

    public  String getPwErrorMessage() {
        try {
            return ElementUtils.findElement(errorMessPw).getText().trim();
        }
        catch (Exception e) {
            return "";
        }
    }

    public  String getPIDErrorMessage() {
        try {
            return ElementUtils.findElement(errorMessPID).getText().trim();
        }
        catch (Exception e) {
            return "";
        }
    }
//    protected By usernameTextBox = By.xpath("//input[@id = 'email']");
//    protected By passwordTextBox = By.xpath("//input[@id = 'password']");
//    protected By confirmTextBox = By.xpath("//input[@id = 'confirmPassword']");
//    protected By pidTextBox = By.xpath("//input[@id = 'pid']");
//    protected By registerBtn = By.xpath("//input[@type = 'submit']");
//    protected By errorMessage = By.xpath("//p[@class = 'message error']");
//    protected By errorMessPw = By.xpath("//label[@for = 'password' and @class = 'validation-error']");
//    protected By errorMessPID = By.xpath("//label[@for = 'pid' and @class = 'validation-error']");
//    protected By header = By.xpath("//h1");
//    protected By successMessage = By.xpath("//div[@id = 'content']/h1");
//    protected By confirmMessage = By.xpath("//div[@id = 'content']/p");
//
//    //Methods
//    public RegisterPage registerAccount(String username, String password, String pid) {
//
//        driver.findElement(usernameTextBox).sendKeys(username);
//        driver.findElement(passwordTextBox).sendKeys(password);
//        driver.findElement(confirmTextBox).sendKeys(password);
//        driver.findElement(pidTextBox).sendKeys(pid);
//
//        WebElement registerbtn = driver.findElement(registerBtn);
//        SeleniumHelper.scrollToElement(registerbtn);
//        registerbtn.click();
//        return new RegisterPage();
//    }
//
//    public WebElement getErrorMessage() {
//        WebElement errorMess = driver.findElement(errorMessage);
//        return errorMess;
//    }
//
//    public WebElement getErrorMessPW() {
//        WebElement errorMessPW = driver.findElement(errorMessPw);
//        return errorMessPW;
//    }
//
//    public WebElement getErrorMessPID() {
//        WebElement errorMessPid = driver.findElement(errorMessPID);
//        return errorMessPid;
//    }
//
//    public WebElement getHeaderRegisterPage() {
//        WebElement headerRegisterPage = driver.findElement(header);
//        return headerRegisterPage;
//    }
//
//    public String getSuccessMess() {
//        return driver.findElement(successMessage).getText();
//    }
//
//    public String getConfirmMess() {
//        return driver.findElement(confirmMessage).getText();
//
//    }

}
