package pageobjects;

import helper.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import static helper.DriverUtils.driver;

//import static helper.DriverUtils.driver;

public class BasePage {

    protected String pageTitle;

    private String xpathMenu = "//li//a[span[text() = '%s']]";

    private By getMenuLocator(String menu) {
        return By.xpath(String.format(xpathMenu, menu));
    }

    public void selectMenu (String menu) {
        Logger.log("Select menu " + menu);
        var locator = getMenuLocator(menu);
        ElementUtils.waitForElementClickable(locator, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.findElement(locator).click();
    }

    public void waitForPageLoad() {
        BrowserUtils.waitForTitle(pageTitle, Constant.PAGE_WAIT_TIMEOUT);
    }

    public Boolean isMenuExists (String menu, int timeoutInSeconds) {
        var locator = getMenuLocator(menu);
        return ElementUtils.isElementExists(locator, timeoutInSeconds);
    }


//    public Boolean isMenuNotExits (String menu, int timeoutInSeconds) {
//        var locator = getMenuLocator(menu);
//        WebDriverWait wait = new WebDriverWait(DriverUtils.driver.get(), Duration.ofSeconds(timeoutInSeconds));
//        wait.until(ExpectedConditions.stalenessOf(ElementUtils.findElement(locator)));
//    }

//    protected String sTabMenu = "//li//a[span[text() = '%s']]";
//
//    public WebElement getTabElement(String tab) {
//        By byTab = By.xpath(String.format(this.sTabMenu,tab));
//        return driver.findElement(byTab);
//    }
//
//    public void navigateTabPage(String tab) {
//        getTabElement(tab).click();
//    }



}
