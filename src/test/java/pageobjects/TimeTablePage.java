package pageobjects;

//import common.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import utils.SeleniumHelper;
//
//import static helper.DriverUtils.driver;

import dataobjects.BookTicketInformation;
import helper.ElementUltis;
import org.openqa.selenium.By;

public class TimeTablePage extends BasePage {
    private String sBookTicket = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s']]]//a[text() = 'book ticket']";
    private String sCheckPrice = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s']]]//a[text() = 'heck price']";
//    protected String sBookTicket = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s']]]//a[text() = 'book ticket']";
//    protected String sCheckPrice = "//tr[td[text() = '%s' and following-sibling::td[text() = '%s']]]//a[text() = 'check price']";
//
    public TimeTablePage() {
    pageTitle = "Safe Railway - Train Timetable";
}

    public void clickBookTicket(BookTicketInformation bookTicketInformation) {
    By bookTicketBtn = By.xpath(String.format(sBookTicket,bookTicketInformation));
    ElementUltis.scrollToElement(bookTicketBtn);
    ElementUltis.findElement(bookTicketBtn).click();
    }


    public void clickCheckPrice(BookTicketInformation bookTicketInformation) {
        By checkPriceBtn = By.xpath(String.format(sCheckPrice,bookTicketInformation));
        ElementUltis.scrollToElement(checkPriceBtn);
        ElementUltis.findElement(checkPriceBtn).click();
    }
//    protected WebElement getBookTicketElement(String departStation, String arriveStation) {
//        By bookTicketBtn = By.xpath(String.format(sBookTicket,departStation, arriveStation));
//        return driver.findElement(bookTicketBtn);
//    }
//
//    public BookTicketPage clickBookTicket(String departStation, String arriveStation) {
//        WebElement bookTicketBtn = this.getBookTicketElement(departStation, arriveStation);
//        SeleniumHelper.scrollToElement(bookTicketBtn);
//        bookTicketBtn.click();
//        return new BookTicketPage();
//    }
//
//    protected WebElement getCheckPriceElement(String departStation, String arriveStation) {
//        By checkPriceBtn = By.xpath(String.format(sCheckPrice,departStation, arriveStation));
//        return driver.findElement(checkPriceBtn);
//    }
//
//    public TicketPricePage clickCheckPrice(String departStation, String arriveStation) {
//        SeleniumHelper.scrollToElement(getCheckPriceElement(departStation,arriveStation));
//        this.getCheckPriceElement(departStation,arriveStation).click();
//        return new TicketPricePage();
//    }
}
