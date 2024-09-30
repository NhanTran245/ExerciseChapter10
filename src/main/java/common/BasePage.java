package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utils.DriverManagement;

import static utils.DriverManagement.driver;

public class BasePage {

    protected String sTabMenu = "//li//a[span[text() = '%s']]";

    public WebElement getTabElement(String tab) {
        By byTab = By.xpath(String.format(this.sTabMenu,tab));
        return driver.findElement(byTab);
    }

    public void navigateTabPage(String tab) {
        getTabElement(tab).click();
    }


}
