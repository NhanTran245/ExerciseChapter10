package Pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverManagement.driver;

public class TimeTablePage extends BasePage {
    protected String sCheckPrice = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s']]]//a[text() = 'check price']";

    protected WebElement getCheckPriceElement(String departStation, String arriveStation) {
        By checkPrice = By.xpath(String.format(sCheckPrice,departStation, arriveStation));
        return driver.findElement(checkPrice);
    }

    public TicketPricePage clickCheckPrice(String departStation, String arriveStation) {
        this.getCheckPriceElement(departStation,arriveStation).click();
        return new TicketPricePage();
    }
}
