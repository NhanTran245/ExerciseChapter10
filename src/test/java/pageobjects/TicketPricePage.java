package pageobjects;

//import common.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import java.util.List;
//
//import static helper.DriverUtils.driver;

public class TicketPricePage extends BasePage {
//    protected String sBookTicket = "//td[text() = '%s']/following-sibling::td/a";
//    protected By ticketTableText = By.xpath("//tr[th[text() = 'Ticket price from Đà Nẵng to Sài Gòn']]");
//    protected String sCheckInforPrice = "//tbody/tr/th[@class='RowHeader']/following-sibling::td[%s]";
//
//    protected WebElement getBookTicket(String seatType) {
//        By bookTicket = By.xpath(String.format(sBookTicket,seatType));
//        return driver.findElement(bookTicket);
//    }
//
//    public BookTicketPage bookTicket(String seatType) {
//        this.getBookTicket(seatType).click();
//        return new BookTicketPage();
//    }
//
//    public String getTicketTableText() {
//        return driver.findElement(ticketTableText).getText();
//    }
//
//    public void compareValues () {
//
//        System.out.println("Price for each seat:");
//
//        for (int i = 1; i <=6; i++) {
//            List <WebElement> elements = driver.findElements(By.xpath(String.format(sCheckInforPrice, i)));
//
//            if (elements.size() >= 2) {
//                String seatValue = elements.get(0).getText();
//                String priceValue = elements.get(1).getText();
//
//                System.out.println(seatValue + " = " + priceValue);
//            } else {
//                System.out.println("Missing value");
//
//            }
//        }
//
//
//    }
}
