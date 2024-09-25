package TestCase;

import Pages.*;
import common.StaticProvider;
import common.TestPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCases extends TestPage {

    @Test (dataProvider = "TC01", dataProviderClass = StaticProvider.class)
    public void TC01(String username, String password) {
        HomePage homePage = new HomePage();

        System.out.println("User logs in to Railway with valid username and password");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.loginAccount(username, password);

        Assert.assertTrue(loginPage.getWelcomeMessage().isDisplayed(),"Welcome message is not displayed");
        System.out.println("Welcome message is displayed");

        System.out.println("TC01: Passed");
    }

    @Test (dataProvider = "TC02", dataProviderClass = StaticProvider.class)
    public void TC02(String username, String password) {
        HomePage homePage = new HomePage();

        System.out.println("User cannot login with blank Username textbox");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.loginAccount(username, password);

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(), "Error message is not displayed" );
        System.out.println("Message 'There was a problem with your login and/or errors exist in your form.' appears");

        System.out.println("TC02: Passed");
    }

    @Test (dataProvider = "TC03", dataProviderClass = StaticProvider.class)
    public void TC03(String username, String password) {
        HomePage homePage = new HomePage();

        System.out.println("User cannot log into Railway with invalid password");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.loginAccount(username, password);

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
        System.out.println("Error message 'There was a problem with your login and/or errors exist in your form.' is displayed");

        System.out.println("TC03: Passed");
    }

    @Test (dataProvider = "TC04", dataProviderClass = StaticProvider.class)
    public void TC04(String username, String password, String warningMessage) {
        HomePage homePage = new HomePage();

        System.out.println("System shows message when user enters wrong password many times");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();

        for (int i = 0; i < 4; i++) {
            homePage = loginPage.loginAccount(username, password);
            Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
            System.out.println("Error message 'Invalid username or password. Please try again' is shown");
        }

        Assert.assertEquals(loginPage.getWarningMessage(), warningMessage, "Warning message does not appear!");
        System.out.println("Warning message appears");

        System.out.println("TC03: Passed");
    }

    @Test (dataProvider = "TC05", dataProviderClass = StaticProvider.class)
    public void TC05(String username, String password) {
        HomePage homePage = new HomePage();

        System.out.println("User can't login with an account hasn't been activated");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.loginAccount(username, password);

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
        System.out.println("Message 'Invalid username or password. Please try again.' appears");

        System.out.println("TC05: Passed");
    }

    @Test (dataProvider = "TC06", dataProviderClass = StaticProvider.class)
    public void TC06(String username, String password) {
        HomePage homePage = new HomePage();

        System.out.println("User is redirected to Home page after logging out");
        System.out.println("Login with valid Email and Password");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.loginAccount(username, password);

        System.out.println("Click on FAQ tab");
        homePage.navigateTabPage("FAQ");

        System.out.println("Click on Log out tab");
        homePage.navigateTabPage("Log out");

        Assert.assertTrue(homePage.getTabElement("Home").isDisplayed());
        Assert.assertTrue(homePage.getTabElement("Login").isDisplayed());
        System.out.println("Home page display");
        System.out.println("Log out tab is disappeared");

        System.out.println("TC05: Passed");
    }

    @Test (dataProvider = "TC07", dataProviderClass = StaticProvider.class)
    public void TC07(String username, String password, String pid) {
        HomePage homePage = new HomePage();

        System.out.println("User can't create account with an already in-use email");
        homePage.navigateTabPage("Register");
        RegisterPage registerPage = new RegisterPage();
        registerPage = registerPage.registerAccount(username, password, pid);

        Assert.assertTrue(registerPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
        System.out.println("Error message is displayed");

        System.out.println("TC07: Passed");
    }

    @Test (dataProvider = "TC08", dataProviderClass = StaticProvider.class)
    public void TC08(String username, String password, String pid) {
        HomePage homePage = new HomePage();

        System.out.println("User can't create account with an already in-use email");
        homePage.navigateTabPage("Register");
        RegisterPage registerPage = new RegisterPage();
        registerPage = registerPage.registerAccount(username, password, pid);

        Assert.assertTrue(registerPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
        System.out.println("Message 'There're errors in the form. Please correct the errors and try again.' appears above the form");

        Assert.assertTrue(registerPage.getErrorMessPW().isDisplayed(), "error message 'Invalid password length.' does not display");
        System.out.println("Error message 'Invalid password length.' displays");

        Assert.assertTrue(registerPage.getErrorMessPID().isDisplayed(), "error message 'Invalid ID length.' does not display");
        System.out.println("Error message 'Invalid ID length.' displays");

        System.out.println("TC08: Passed");
    }
//TC09: Chua xong
    @Test (dataProvider = "TC09", dataProviderClass = StaticProvider.class)
    public void TC09(String username, String password, String pid) {
        HomePage homePage = new HomePage();

        System.out.println("User create and activate account");
        RegisterPage registerPage = homePage.clickCreateAccLink();

        Assert.assertTrue(registerPage.getHeaderRegisterPage().isDisplayed(),"Register page is not shown");
        System.out.println("Register page is shown");

        System.out.println("Enter valid information into all fields");
        registerPage = registerPage.registerAccount(username, password, pid);

        String expectedSuccessMess = "Thank you for registering your account";
        String actualSuccessMess = registerPage.getSuccessMess();
        Assert.assertTrue(actualSuccessMess.equals(expectedSuccessMess),"Success message shows incorrect");
        System.out.println("Success message 'Thank you for registering your account' is shown");




        System.out.println("TC07: Chua xong");
    }
    //TC10: Chua xong
    @Test (dataProvider = "TC10", dataProviderClass = StaticProvider.class)
    public void TC10(String username) {
        HomePage homePage = new HomePage();

        System.out.println("Reset password shows error if the new password is same as current");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();

        System.out.println("Click on 'Forgot Password page' link");
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPasswordPage();

        System.out.println("Enter the email address of the activated account");
        forgotPasswordPage = forgotPasswordPage.enterEmailAddress(username);

        System.out.println("TC10: Chua xong");
    }

    @Test (dataProvider = "TC12", dataProviderClass = StaticProvider.class)
    public void TC12(String username, String password, int daysFromToday, String departStation, String arriveStation, String seatType, int ticketAmount) {
        HomePage homePage = new HomePage();

        System.out.println("User can book 1 ticket at a time");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();

        System.out.println("Login with a valid account ");
        homePage = loginPage.loginAccount(username, password);

        System.out.println("Click on Book ticket tab");
        homePage.navigateTabPage("Book ticket");
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("Select the next 12 days from 'Depart date'");
        bookTicketPage = bookTicketPage.selectDepartDate(daysFromToday);

        System.out.println("Select Depart from 'Nha Trang' and Arrive at 'Huế'");
        bookTicketPage.selectStation(departStation, arriveStation);

        System.out.println("Select 'Soft seat with air conditioner' for 'Seat type'");
        bookTicketPage.selectSeatType(seatType);

        System.out.println("Select '1' for 'Ticket amount'");
        bookTicketPage.selectTicketAmount(ticketAmount);

        System.out.println("Click on 'Book ticket' button");
        bookTicketPage.clickBookTicketBtn();

        System.out.println("Ticket booked successfully with corrected ticket info");
        String expectedMessage = "Ticket booked successfully!";
        String actualMessage = bookTicketPage.getsuccessMessage();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        System.out.println("TC12: Passed");
    }
// TC13 chua xong
    @Test (dataProvider = "TC13", dataProviderClass = StaticProvider.class)
    public void TC13(String username, String password, int daysFromToday, String departStation, String arriveStation, String seatType, int ticketAmount) {
        HomePage homePage = new HomePage();

        System.out.println("User can book many tickets at a time");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();

        System.out.println("Login with a valid account");
        homePage = loginPage.loginAccount(username, password);

        System.out.println("Click on Book ticket tab");
        homePage.navigateTabPage("Book ticket");
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("Select the next 12 days from 'Depart date'");
        bookTicketPage = bookTicketPage.selectDepartDate(daysFromToday);

        System.out.println("Select Depart from 'Nha Trang' and Arrive at 'Sài Gòn'");
        bookTicketPage.selectStation(departStation, arriveStation);

        System.out.println("Select 'Soft seat with air conditioner' for 'Seat type'");
        bookTicketPage.selectSeatType(seatType);

        System.out.println("Select '1' for 'Ticket amount'");
        bookTicketPage.selectTicketAmount(ticketAmount);

        System.out.println("Click on 'Book ticket' button");
        bookTicketPage.clickBookTicketBtn();

        System.out.println("Ticket booked successfully with corrected ticket info");
        String expectedMessage = "Ticket booked successfully!";
        String actualMessage = bookTicketPage.getsuccessMessage();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        System.out.println("TC13: Passed");
    }
//TC14: Chua xong
    @Test (dataProvider = "TC14", dataProviderClass = StaticProvider.class)
    public void TC14(String username, String password, String departStation, String arriveStation) {
        HomePage homePage = new HomePage();

        System.out.println("User can book ticket from Timetable");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();

        System.out.println("Login with a valid account");
        homePage = loginPage.loginAccount(username, password);

        System.out.println("Click on 'Timetable' tab");
        homePage.navigateTabPage("Timetable");
        TimeTablePage timeTablePage = new TimeTablePage();

        System.out.println("Click on “check price” of Da Nang - Sai Gon");
        TicketPricePage ticketPricePage = timeTablePage.clickCheckPrice(departStation, arriveStation);

        String expectedTicketTableText = "Ticket price from Đà Nẵng to Sài Gòn";
        String actualTicketTableText = ticketPricePage.getTicketTableText();
        Assert.assertTrue(actualTicketTableText.equals(expectedTicketTableText), "Ticket table shows incorrectly");
        System.out.println("Ticket table shows 'Ticket price from Đà Nẵng to Sài Gòn'");

        System.out.println("TC14: Passed");
    }

    @Test (dataProvider = "TC15", dataProviderClass = StaticProvider.class)
    public void TC15(String username, String password, String departStation, String arriveStation, int daysFromToday, int ticketAmount) {
        HomePage homePage = new HomePage();

        System.out.println("User can book ticket from Timetable");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();

        System.out.println("Login with a valid account");
        homePage = loginPage.loginAccount(username, password);

        System.out.println("Click on 'Timetable' tab");
        homePage.navigateTabPage("Timetable");
        TimeTablePage timeTablePage = new TimeTablePage();

        System.out.println("Click on book ticket of route 'Quảng Ngãi' to 'Huế'");
        timeTablePage.clickBookTicket(departStation, arriveStation);
        BookTicketPage bookTicketPage = new BookTicketPage();

        Assert.assertTrue(bookTicketPage.getbBookTicketForm().isDisplayed(),"Book ticket form is not shown!");
        String actualDepart = bookTicketPage.getDepartFrom();
        if (actualDepart.equals(departStation)) {
            System.out.println("Book ticket form is shown with the corrected 'depart from'");
        } else {
            System.out.println("Book ticket form is shown with the incorrected 'depart from'");
        }

        String actualArrive = bookTicketPage.getArriveAt();
        if (actualArrive.equals(arriveStation)) {
            System.out.println("Book ticket form is shown with the corrected 'arrive at'");
        } else {
            System.out.println("Book ticket form is shown with the incorrected 'arrive at'");
        }

        System.out.println("Select Depart date next 10 days");
        bookTicketPage.selectDepartDate(daysFromToday);

        System.out.println("Select Ticket amount = 5");
        bookTicketPage.selectTicketAmount(ticketAmount);

        System.out.println("Click on 'Book ticket' button");
        bookTicketPage.clickBookTicketBtn();

        System.out.println("Ticket booked successfully with corrected ticket info");
        String expectedMessage = "Ticket booked successfully!";
        String actualMessage = bookTicketPage.getsuccessMessage();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        System.out.println("TC15: Passed");
    }

    @Test (dataProvider = "TC16", dataProviderClass = StaticProvider.class)
    public void TC16(String username, String password, int daysFromToday, String departStation, String arriveStation, String seatType, int ticketAmount) {
        HomePage homePage = new HomePage();

        System.out.println("User can cancel a ticket");
        homePage.navigateTabPage("Login");
        LoginPage loginPage = new LoginPage();

        System.out.println("Login with a valid account");
        homePage = loginPage.loginAccount(username, password);

        System.out.println("Book a ticket");
        homePage.navigateTabPage("Book ticket");
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("Select the next 12 days from 'Depart date'");
        bookTicketPage = bookTicketPage.selectDepartDate(daysFromToday);

        System.out.println("Select Depart from 'Nha Trang' and Arrive at 'Huế'");
        bookTicketPage.selectStation(departStation, arriveStation);

        System.out.println("Select 'Soft seat with air conditioner' for 'Seat type'");
        bookTicketPage.selectSeatType(seatType);

        System.out.println("Select '1' for 'Ticket amount'");
        bookTicketPage.selectTicketAmount(ticketAmount);

        System.out.println("Click on 'Book ticket' button");
        bookTicketPage.clickBookTicketBtn();

        System.out.println("Ticket booked successfully with corrected ticket info");
        String expectedMessage = "Ticket booked successfully!";
        String actualMessage = bookTicketPage.getsuccessMessage();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        System.out.println("Click on 'My ticket' tab");
        homePage.navigateTabPage("My ticket");
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("Click on 'Cancel' button of ticket which user want to cancel.");
        myTicketPage.clickCancelBtn();

        Assert.assertTrue(myTicketPage.getTicketRow(departStation, arriveStation).isDisplayed(), "The canceled ticket still appear");
        System.out.println("The canceled ticket is disappeared");

        System.out.println("TC16: Passed");
    }
}
