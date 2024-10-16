package pageobjects;

import helper.BrowserUtils;
import helper.Constant;
import helper.ElementUltis;
import helper.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        ElementUltis.waitForElementClickable(locator, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUltis.findElement(locator).click();
    }

    public void waitForPageLoad() {
        BrowserUtils.waitForTitle(pageTitle, Constant.PAGE_WAIT_TIMEOUT);
    }

    public Boolean ísMenuExists (String menu, int timeoutInSeconds) {
        var locator = getMenuLocator(menu);
        return ElementUltis.isElementExists(locator, timeoutInSeconds);
    }

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
