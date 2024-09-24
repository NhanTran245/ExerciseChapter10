package Pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumHelper;

import static utils.DriverManagement.driver;

public class MyTicketPage extends BasePage {
    protected By firstCancelBtn = By.xpath("(//td/input[@value = 'Cancel'])[1]");
    protected String sTicketRow = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s']]]";

    public MyTicketPage clickCancelBtn() {
        driver.findElement(firstCancelBtn).click();
        SeleniumHelper.acceptAlert();
        return new  MyTicketPage();
    }

    public WebElement getTicketRow(String departStation, String arriveStation) {
        By ticketRow = By.xpath(String.format(sTicketRow, departStation, arriveStation));
        return driver.findElement(ticketRow);
    }
}
