package pageobjects;

//import common.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import utils.SeleniumHelper;
//
//import static helper.DriverUtils.driver;

import dataobjects.BookTicketInformation;
import helper.Constant;
import helper.ElementUtils;
import helper.Logger;
import org.openqa.selenium.By;

public class MyTicketPage extends BasePage {
    private By firstCancelBtn = By.xpath("(//td/input[@value = 'Cancel'])[1]");
    private String sTicketRow = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s']]]";

    public void clickCancelBtn() {
        Logger.log("Cancel ticket");
        ElementUtils.scrollToElement(firstCancelBtn);
        ElementUtils.findElement(firstCancelBtn).click();
        ElementUtils.acceptAlert(Constant.ELEMENT_WAIT_TIMEOUT);
    }
    public Boolean isTicketRowExist(BookTicketInformation bookTicketInformation) {
        By ticketRow = By.xpath(String.format(sTicketRow, bookTicketInformation));
        return ElementUtils.isElementExists(ticketRow, Constant.ELEMENT_WAIT_TIMEOUT);
    }
//    protected By firstCancelBtn = By.xpath("(//td/input[@value = 'Cancel'])[1]");
//    protected String sTicketRow = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s']]]";
//
//    public MyTicketPage clickCancelBtn() {
//        SeleniumHelper.scrollToElement(driver.findElement(firstCancelBtn));
//        driver.findElement(firstCancelBtn).click();
//        SeleniumHelper.acceptAlert();
//        return new  MyTicketPage();
//    }
//
//    public WebElement getTicketRow(String departStation, String arriveStation) {
//        By ticketRow = By.xpath(String.format(sTicketRow, departStation, arriveStation));
//        return driver.findElement(ticketRow);
//    }
}
