package Pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverManagement.driver;

public class TicketPricePage extends BasePage {
    protected String sBookTicket = "//td[text() = '%s']/following-sibling::td/a";

    protected WebElement getBookTicket(String seatType) {
        By bookTicket = By.xpath(String.format(sBookTicket,seatType));
        return driver.findElement(bookTicket);
    }

    public BookTicketPage bookTicket(String seatType) {
        this.getBookTicket(seatType).click();
        return new BookTicketPage();
    }
}
