package pageobjects;

//import common.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import utils.SeleniumHelper;
//
//import static helper.DriverUtils.driver;

import helper.Constant;
import helper.ElementUtils;
import org.openqa.selenium.By;

public class MyTicketPage extends BasePage {
    private By firstCancelBtn = By.xpath("(//td/input[@value = 'Cancel'])[1]");
    private String sTicketRow = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s']]]";

    public MyTicketPage clickCancelBtn() {
        ElementUtils.scrollToElement(firstCancelBtn);
        ElementUtils.findElement(firstCancelBtn).click();
        ElementUtils.acceptAlert(Constant.ELEMENT_WAIT_TIMEOUT);
        return new  MyTicketPage();
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
