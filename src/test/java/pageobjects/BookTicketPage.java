package pageobjects;

import dataobjects.BookTicketInformation;
import helper.Constant;
import helper.DateTimeUtils;
import helper.ElementUtils;
import helper.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumHelper;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//import static helper.DriverUtils.driver;

public class BookTicketPage extends BasePage {

    private By departDateDropDown = By.xpath("//select[@name ='Date']");
    private By ticketAmountDropDown = By.xpath("//select[@name ='TicketAmount']");
    private By departStationDropDown = By.xpath("//select[@name = 'DepartStation']");
    private By selectedDepartStation = By.xpath("//select[@name = 'DepartStation']/option[@selected = 'selected']");
    private By arriveStationDropDown = By.xpath("//select[@name = 'ArriveStation']");
    private By selectedArriveStation = By.xpath("//select[@name = 'ArriveStation']/option[@selected = 'selected']");
    private By seatTypeDropDown = By.xpath("//select[@name = 'SeatType']");
    private By bookTicketBtn = By.xpath("//input[@type='submit']");
    private By successMessage = By.xpath("//h1");
    private String BookTicketRow = "//tr[@class = 'TableSmallHeader']/following-sibling::tr/td";

    public BookTicketPage() {
        pageTitle = "Safe Railway - Book Ticket";
    }

    public void bookTicket(BookTicketInformation bookTicketInformation) {
        Logger.log("Book ticket");
        waitForPageLoad();
        ElementUtils.waitForElementExists(bookTicketBtn, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUtils.scrollToElement(bookTicketBtn);

        if (bookTicketInformation.getDepartDate() != null) {
            Logger.log("Select Depart Date");
            Select selectDate = new Select(ElementUtils.findElement(departDateDropDown));
            selectDate.selectByVisibleText(bookTicketInformation.getDepartDate());
        } else {
            Logger.log("Skip select Depart Date");
        }

        boolean isFirstSelectionDepartStation = false; // global variable
        if (bookTicketInformation.getDepartStation() != null || !ElementUtils.isElementExists(selectedDepartStation, Constant.ELEMENT_WAIT_TIMEOUT)) {
            Logger.log("Select Depart Station");
            Select selectDepartStation = new Select(ElementUtils.findElement(departStationDropDown));
            String actualDepartValue = selectDepartStation.getFirstSelectedOption().getText();
            isFirstSelectionDepartStation = bookTicketInformation.getDepartStation().equals(actualDepartValue);
            if (!isFirstSelectionDepartStation) {
                selectDepartStation.selectByVisibleText(bookTicketInformation.getDepartStation());
            }
        } else {
            Logger.log("Skip select Depart Station");
        }

        if (bookTicketInformation.getArriveStation() != null || !ElementUtils.isElementExists(selectedArriveStation, Constant.ELEMENT_WAIT_TIMEOUT)) {
            Logger.log("Select Arrive Station");

            if (!isFirstSelectionDepartStation) {
                ElementUtils.waitForElementNotExists(arriveStationDropDown, Constant.ELEMENT_WAIT_TIMEOUT);
            }
            Select selectArriveStation = new Select(ElementUtils.findElement(arriveStationDropDown));
            String actualArriveValue = selectArriveStation.getFirstSelectedOption().getText();
            if (!bookTicketInformation.getArriveStation().equals(actualArriveValue)) {
                Logger.log("actualArriveValue" + actualArriveValue);
                Logger.log("Select Arrive Station:" + bookTicketInformation.getArriveStation());
                selectArriveStation.selectByVisibleText(bookTicketInformation.getArriveStation());
            }
        } else {
            Logger.log("Skip select Arrive Station");
        }

        if (bookTicketInformation.getSeatType() != null) {
            Logger.log("Select Seat type");
            Select selectSeatType = new Select(ElementUtils.findElement(seatTypeDropDown));
            selectSeatType.selectByVisibleText(bookTicketInformation.getSeatType());
        } else {
            Logger.log("Skip select Seat type");
        }

        if (bookTicketInformation.getTicketAmount() != 1) {
            Logger.log("Select Ticket Amount");
            Select selectAmount = new Select(ElementUtils.findElement(ticketAmountDropDown));
            selectAmount.selectByValue(String.valueOf(bookTicketInformation.getTicketAmount()));
        } else {
            Logger.log("Skip select Ticket Amount");
        }
        ElementUtils.findElement(bookTicketBtn).click();
    }


    public String getSuccessMessage() {
        try {
            return ElementUtils.findElement(successMessage).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
    public int getBookedTicketAmount(BookTicketInformation bookTicketInformation) {
        return bookTicketInformation.getTicketAmount();
    }

    public void compareTicketInformationRow(BookTicketInformation bookTicketInformation) {
        Logger.log("Get the ticket information");
        List<WebElement> ticketInfoElements = ElementUtils.findElements(By.xpath(String.format(BookTicketRow)));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        LocalDate actualDepartDate;
        try {
            actualDepartDate = LocalDate.parse(ticketInfoElements.get(3).getText(), formatter);
        } catch (Exception e) {
            Logger.log("Lỗi định dạng ngày tháng: " + ticketInfoElements.get(3).getText());
            return;
        }
        LocalDate expectedDepartDate = LocalDate.parse(bookTicketInformation.getDepartDate(), formatter);

        String actualDepartStation = ticketInfoElements.get(0).getText();
        String actualArriveStation = ticketInfoElements.get(1).getText();
        String actualSeatType = ticketInfoElements.get(2).getText();
        int actualTicketAmount = Integer.parseInt(ticketInfoElements.get(6).getText());
        Logger.log("Compare the ticket information");
        if (expectedDepartDate.equals(actualDepartDate)) {
            Logger.log("Expected Depart Date: " + bookTicketInformation.getDepartDate() + ", Actual: " + actualDepartDate);
        }
        if (bookTicketInformation.getDepartStation().equals(actualDepartStation)) {
            Logger.log("Expected Depart Station: " + bookTicketInformation.getDepartStation() + ", Actual: " + actualDepartStation);
        }
        if (bookTicketInformation.getArriveStation().equals(actualArriveStation)) {
            Logger.log("Expected Arrive Station: " + bookTicketInformation.getArriveStation() + ", Actual: " + actualArriveStation);
        }
        if ((bookTicketInformation.getSeatType() != null && bookTicketInformation.getSeatType().equals(actualSeatType)))  {
                Logger.log("Expected Seat Type: " + bookTicketInformation.getSeatType() + ", Actual: " + actualSeatType);
        } else if (bookTicketInformation.getSeatType() == null) {
            Logger.log("Expected Seat Type: Default, Actual: " + actualSeatType);
        }
        if (bookTicketInformation.getTicketAmount() == actualTicketAmount) {
            Logger.log("Expected Ticket Amount: " + bookTicketInformation.getTicketAmount() + ", Actual: " + actualTicketAmount);
        }
        Logger.log("Ticket information display correctly");

    }
    public String getDepartFrom() {
        try {
            return ElementUtils.findElement(selectedDepartStation).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public String getArriveAt() {
        try {
            return ElementUtils.findElement(selectedArriveStation).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

}



//    // Elements
//    protected By departDateDropDown = By.xpath("//select[@name ='Date']");
//    protected By ticketAmountDropDown = By.xpath("//select[@name ='TicketAmount']");
//    protected By departStationDropDown = By.xpath("//select[@name = 'DepartStation']");
//    protected By departStationValue = By.xpath("//select[@name = 'DepartStation']/option[@selected = 'selected']");
//    protected By arriveStationDropDown = By.xpath("//select[@name = 'ArriveStation']");
//    protected By arriveStationValue = By.xpath("//select[@name = 'ArriveStation']/option[@selected = 'selected']");
//    protected By seatTypeDropDown = By.xpath("//select[@name = 'SeatType']");
//    protected By bookTicketBtn = By.xpath("//input[@type='submit']");
//    protected By confirmText = By.xpath("//h1");
//    protected By bookTicketForm = By.xpath("//form[@method = 'post']");
//
//    //Methods
//    public BookTicketPage selectDepartDate(int daysFromToday) {
//        LocalDate departDate = LocalDate.now().plusDays(daysFromToday);
//        String formattedDate = departDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
//        Select selectDate = new Select(driver.findElement(departDateDropDown));
//        selectDate.selectByVisibleText(formattedDate);
//
//        return new BookTicketPage();
//    }
//
//    public void selectTicketAmount(int amount) {
//        Select selectAmount = new Select(driver.findElement(ticketAmountDropDown));
//        selectAmount.selectByValue(String.valueOf(amount));
//    }
//
//    public void clickBookTicketBtn() {
//        WebElement bookTicketbtn = driver.findElement(bookTicketBtn);
//        SeleniumHelper.scrollToElement(bookTicketbtn);
//        bookTicketbtn.click();
//    }
//
//    public String getsuccessMessage() {
//        return driver.findElement(confirmText).getText();
//    }
//
//    public void selectStation(String departFromStation, String arriveAtStation) {
//        Select selectDepartStation = new Select(driver.findElement(departSationDropDown));
//        selectDepartStation.selectByVisibleText(departFromStation);
//
//        SeleniumHelper.scrollToElement(driver.findElement(bookTicketBtn));
//        SeleniumHelper.waitToLoadDropdown(arriveStationDropDown);
//
//        Select selectArriveStation = new Select(driver.findElement(arriveStationDropDown));
//        String actualValue = selectArriveStation.getFirstSelectedOption().getText();
//
//
//        if(arriveAtStation.equals(actualValue)) {
//
//            selectArriveStation.getFirstSelectedOption();
//
//        }
//        else{
//            selectArriveStation.selectByVisibleText(arriveAtStation);
//        }
//    }
//
//    public void selectSeatType(String seatType) {
//        Select selectSeatType= new Select(driver.findElement(seatTypeDropDown));
//        selectSeatType.selectByVisibleText(seatType);
//    }
//
//    public WebElement getbBookTicketForm() {
//        WebElement bookticketForm = driver.findElement(bookTicketForm);
//        return bookticketForm;
//    }
//
//    public String getDepartFrom() {
//        return driver.findElement(departStationValue).getText();
//    }
//
//    public String getArriveAt() {
//        return driver.findElement(arriveStationValue).getText();
//    }