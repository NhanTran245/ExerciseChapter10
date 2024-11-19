package pageobjects;

//import common.BasePage;
//import org.openqa.selenium.By;
//
//import static helper.DriverUtils.driver;

import helper.Constant;
import helper.ElementUtils;
import helper.Logger;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By welcomeMessage = By.xpath("//div[@class='account']");
    private By createAccLink = By.xpath("//a[text() = 'create an account']");
    public HomePage() {
        pageTitle = "Safe Railway";
    }

    public String getWellcomeMessage() {
        waitForPageLoad();
        ElementUtils.isElementExists(welcomeMessage, Constant.ELEMENT_WAIT_TIMEOUT);
        return ElementUtils.findElement(welcomeMessage).getText();
    }

//    protected By createAccLink = By.xpath("//a[text() = 'create an account']");
//
    public void clickCreateAccLink() {
        Logger.log("Click Create an account link");
        waitForPageLoad();
        ElementUtils.isElementExists(createAccLink, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.findElement(createAccLink).click();
    }

}