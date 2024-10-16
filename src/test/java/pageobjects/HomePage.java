package pageobjects;

//import common.BasePage;
//import org.openqa.selenium.By;
//
//import static helper.DriverUtils.driver;

import helper.Constant;
import helper.DriverUtils;
import helper.ElementUltis;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By welcomeMessage = By.xpath("//div[@class='account']");
    public HomePage() {
        pageTitle = "Safe Railway";
    }

    public String getWellcomeMessage() {
        waitForPageLoad();
        ElementUltis.isElementExists(welcomeMessage, Constant.ELEMENT_WAIT_TIMEOUT);
        return ElementUltis.findElement(welcomeMessage).getText();
    }

//    protected By createAccLink = By.xpath("//a[text() = 'create an account']");
//
//    public RegisterPage clickCreateAccLink() {
//        driver.findElement(createAccLink).click();
//        return new RegisterPage();
//    }

}