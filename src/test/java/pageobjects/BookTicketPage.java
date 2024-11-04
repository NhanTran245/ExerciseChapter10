package pageobjects;

import dataobjects.BookTicketInformation;
import helper.Constant;
import helper.DateTimeUtils;
import helper.ElementUltis;
import helper.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumHelper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//import static helper.DriverUtils.driver;

public class BookTicketPage extends BasePage{

    private By departDateDropDown = By.xpath("//select[@name ='Date']");
    private By ticketAmountDropDown = By.xpath("//select[@name ='TicketAmount']");
    private By departStationDropDown = By.xpath("//select[@name = 'DepartStation']");
    private By departStationValue = By.xpath("//select[@name = 'DepartStation']/option[@selected = 'selected']");
    private By arriveStationDropDown = By.xpath("//select[@name = 'ArriveStation']");
    private By arriveStationValue = By.xpath("//select[@name = 'ArriveStation']/option[@selected = 'selected']");
    private By seatTypeDropDown = By.xpath("//select[@name = 'SeatType']");
    private By bookTicketBtn = By.xpath("//input[@type='submit']");

    public BookTicketPage() {
        pageTitle = "Safe Railway - Book Ticket";
    }

    public void bookTicket(BookTicketInformation bookTicketInformation, String patter) {
        Logger.log("Book ticket");
        waitForPageLoad();
        ElementUltis.waitForElementExists(bookTicketBtn, Constant.ELEMENT_WAIT_TIMEOUT);
        ElementUltis.scrollToElement(bookTicketBtn);

        if (departDateDropDown != null) {
            Select selectDate = new Select(ElementUltis.findElement(departDateDropDown));
            selectDate.selectByVisibleText(DateTimeUtils.getDateFromTodayString(daysFromToday, pattern));
        }
        if (departStationDropDown != null) {
            Select selectDepartStation = new Select(ElementUltis.findElement(departStationDropDown));
            selectDepartStation.selectByVisibleText(departFromStation);
        }
        if (arriveStationDropDown != null) {
            ElementUltis.waitForElementClickable(arriveStationDropDown, Constant.ELEMENT_WAIT_TIMEOUT);
            Select selectArriveStation = new Select(ElementUltis.findElement(arriveStationDropDown));
            String actualValue = selectArriveStation.getFirstSelectedOption().getText();

                if(arriveAtStation.equals(actualValue)) {

                    selectArriveStation.getFirstSelectedOption();

                }
                else{
                    selectArriveStation.selectByVisibleText(arriveAtStation);
                }

                }
        if (seatType != null) {
            Select selectSeatType= new Select(ElementUltis.findElement(seatTypeDropDown));
            selectSeatType.selectByVisibleText(seatType);
        }
        if (ticketAmountDropDown != null) {
            Select selectAmount = new Select(ElementUltis.findElement(ticketAmountDropDown));
        selectAmount.selectByValue(String.valueOf(amount));
        }
    }

    public void selectDepartDate(int daysFromToday, String pattern) {
        Logger.log("Select Depart Date");
        waitForPageLoad();
        Select selectDate = new Select(ElementUltis.findElement(departDateDropDown));
        selectDate.selectByVisibleText(DateTimeUtils.getDateFromTodayString(daysFromToday, pattern));

    }

//    // Elements
//    protected By departDateDropDown = By.xpath("//select[@name ='Date']");
//    protected By ticketAmountDropDown = By.xpath("//select[@name ='TicketAmount']");
//    protected By departSationDropDown = By.xpath("//select[@name = 'DepartStation']");
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
}
