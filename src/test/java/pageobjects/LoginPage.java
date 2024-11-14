package pageobjects;

//import common.BasePage;
import dataobjects.User;
import helper.Constant;
import helper.ElementUtils;
import helper.Logger;
import org.openqa.selenium.By;

//import static helper.DriverUtils.driver;

public class LoginPage extends BasePage {

    private By usernameTextBox = By.xpath("//input[@id = 'username']");
    private By pwTextBox = By.xpath("//input[@id = 'password']");
    private By loginBtn = By.xpath("//input[@type = 'submit']");
    private By errorMessage = By.xpath("//p[@class = 'message error LoginForm']");

    public LoginPage() {
        pageTitle = "Safe Railway - Login";
    }

    public void login (User user) {
        Logger.log("Login user");
        waitForPageLoad();
        ElementUtils.waitForElementExists(loginBtn, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.scrollToElement(loginBtn);

        if (user.getEmail() != null) {
            var element = ElementUtils.findElement(usernameTextBox);
            element.clear();
            element.sendKeys(user.getEmail());
        }

        if (user.getPassword() != null) {
            var element = ElementUtils.findElement(pwTextBox);
            element.clear();
            element.sendKeys(user.getPassword());
        }
        ElementUtils.findElement(loginBtn).click();
    }

    public String getErrorMessage() {
        try {
            return ElementUtils.findElement(errorMessage).getText().trim();
        }
        catch (Exception e) {
            return "";
        }

    }

//    protected By usernameTextBox = By.xpath("//input[@id = 'username']");
//    protected By pwTextBox = By.xpath("//input[@id = 'password']");
//    protected By loginBtn = By.xpath("//input[@type = 'submit']");
//    protected By welcomeMessage = By.xpath("//div[@class='account']");
//    protected By errorMessage = By.xpath("//p[@class = 'message error LoginForm']");
//    protected By forgotPWlink = By.xpath("//a[text() = 'Forgot Password page']");
//
//    //Methods
//    public HomePage loginAccount(String username, String password) { //nen tra ve 1 page cu  the//
//        driver.findElement(usernameTextBox).sendKeys(username);
//        driver.findElement(pwTextBox).sendKeys(password);
//        SeleniumHelper.scrollToElement(driver.findElement(loginBtn));
//        driver.findElement(loginBtn).click();
//
//        return new HomePage();
//    }
//
//    public WebElement getWelcomeMessage() {
//        WebElement welcomeMess = driver.findElement(welcomeMessage);
//        return welcomeMess;
//    }
//
//    public WebElement getErrorMessage() {
//        WebElement errorMess = driver.findElement(errorMessage);
//        return errorMess;
//    }
//
//    public String getWarningMessage() {
//        return driver.findElement(errorMessage).getText();
//    }
//
//    public ForgotPasswordPage clickForgotPasswordPage() {
//        driver.findElement(forgotPWlink).click();
//
//        return new ForgotPasswordPage();
//    }

}
