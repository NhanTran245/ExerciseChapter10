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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MyTicketPage extends BasePage {
    private By firstCancelBtn = By.xpath("(//td/input[@value = 'Cancel'])[1]");
    private String sTicketRow = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s'] and following-sibling::td[text() = '%s']]]";
    private By filterDepartStation = By.xpath("//select[@name = 'FilterDpStation']");
    private By applyBtn = By.xpath("//input[@type = 'submit']");
    private By filterStatus = By.xpath("//select[@name = 'FilterStatus']");
    private By departStationRow = By.xpath("//table[@class = 'MyTable']/tbody/tr[@class = 'OddRow']/td[2]");
    private By errorMessage = By.xpath("//div[@class = 'error message']");

    public MyTicketPage() {
        pageTitle = "Safe Railway - My Ticket";
    }

    public void clickCancelBtn() {
        Logger.log("Cancel ticket");
        waitForPageLoad();
        ElementUtils.scrollToElement(firstCancelBtn);
        ElementUtils.findElement(firstCancelBtn).click();
        ElementUtils.acceptAlert(Constant.ELEMENT_WAIT_TIMEOUT);
    }
    public Boolean isTicketRowExist(BookTicketInformation bookTicketInformation) {
        By ticketRow = By.xpath(String.format(sTicketRow, bookTicketInformation));
        return ElementUtils.isElementExists(ticketRow, Constant.ELEMENT_WAIT_TIMEOUT);
    }

    public void selectStatus(String status) {
        if (status != null) {
            Logger.log("Select Status filter");
            Select selectStatus = new Select(ElementUtils.findElement(filterStatus));
            selectStatus.selectByVisibleText(status);
        } else {
            Logger.log("Skip filter Depart Station");
        }
    }

    public void selectBookedDepartStation(BookTicketInformation bookTicketInformation) {
        if (bookTicketInformation.getDepartStation() != null) {
            Logger.log("Select Depart Station filter");
            Select selectDepartStation = new Select(ElementUtils.findElement(filterDepartStation));
            selectDepartStation.selectByVisibleText(bookTicketInformation.getDepartStation());
        } else {
            Logger.log("Skip filter Depart Station");
        }
    }
    public void clickApplyButton() {
        ElementUtils.findElement(applyBtn).click();
    }
    public void filterDepartStation(BookTicketInformation bookTicketInformation) {
        Logger.log("Filter ticket from Depart Station");
        waitForPageLoad();
        this.selectBookedDepartStation(bookTicketInformation);
        this.clickApplyButton();
    }
    // Get all rows from the filtered table
    public List<WebElement> getDepartStationRows() {
        WebElement tableBody = ElementUtils.findElement(departStationRow);
        return tableBody.findElements(By.tagName("td"));
    }

    public void filterStatus(String status) {
        Logger.log("Filter ticket from Status");
        waitForPageLoad();
        this.selectStatus(status);
        this.clickApplyButton();
    }

    public String getErrorMessage() {
        return ElementUtils.findElement(errorMessage).getText();
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
