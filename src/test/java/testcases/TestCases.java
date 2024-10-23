package testcases;

//import common.MailPage;
import common.StaticProvider;
import dataobjects.Menu;
import dataobjects.User;
import helper.Constant;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.*;
import utils.SeleniumHelper;


public class TestCases extends TestBase {

    @Test
    public void TC001() {
        var user = new User("h1uv4c9ktg@email2u.shop", "123456789");
        var expectedMessage = "Wellcome " + user.getEmail();

//        1. Navigate to QA Railway Website

//        2. Click on "Login" tab
        HomePage homePage = new HomePage();
        homePage.selectMenu(Menu.LOGIN.toString());
//        3. Enter valid Email and Password

//        4. Click on "Login" button
        LoginPage loginPage = new LoginPage();
        loginPage.login(user);

//        VP: User is logged into Railway.
        Assert.assertTrue(homePage.ísMenuExists(Menu.LOGOUT.toString(), Constant.ELEMENT_WAIT_TIMEOUT));

//        VP: Welcome user message is displayed. "Wellcome message is not displayed"
        Assert.assertEquals(homePage.getWellcomeMessage(),expectedMessage);
    }
    @DataProvider (name = "loginTestData", parallel = true)
    public Object [][] createData002(){
            return new Object [][]{
                    {new User(null, "123456789"), "There was a problem with your login and/or errors exist in your form."},
                    {new User("h1uv4c9ktg@email2u.shop", "12345678"), "There was a problem with your login and/or errors exist in your form."}
                };
    }

    @Test (dataProvider = "loginTestData")
    public void TC002(User user, String expectedMessage) {

//        1. Navigate to QA Railway Website

//        2. Click on "Login" tab
        HomePage homePage = new HomePage();
        homePage.selectMenu(Menu.LOGIN.toString());
//        3. Enter valid Email and Password

//        4. Click on "Login" button
        LoginPage loginPage = new LoginPage();
        loginPage.login(user);

//        VP: User doesn't type any words into "Username" textbox but enter valid information into "Password" textbox

//        VP: Welcome user message is displayed. "Wellcome message is not displayed"
        Assert.assertEquals(loginPage.getErrorMessage(),expectedMessage);
    }

//    @Test (dataProvider = "TC01", dataProviderClass = StaticProvider.class)
//    public void TC01(String username, String password) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User logs in to Railway with valid username and password");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//        homePage = loginPage.loginAccount(username, password);
//
//        Assert.assertTrue(loginPage.getWelcomeMessage().isDisplayed(),"Welcome message is not displayed");
//        System.out.println("Welcome message is displayed");
//
//        System.out.println("TC01: Passed");
//    }
//
//    @Test (dataProvider = "TC02", dataProviderClass = StaticProvider.class)
//    public void TC02(String username, String password) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User cannot login with blank Username textbox");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//        homePage = loginPage.loginAccount(username, password);
//
//        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(), "Error message is not displayed" );
//        System.out.println("Message 'There was a problem with your login and/or errors exist in your form.' appears");
//
//        System.out.println("TC02: Passed");
//    }
//
//    @Test (dataProvider = "TC03", dataProviderClass = StaticProvider.class)
//    public void TC03(String username, String password) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User cannot log into Railway with invalid password");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//        homePage = loginPage.loginAccount(username, password);
//
//        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
//        System.out.println("Error message 'There was a problem with your login and/or errors exist in your form.' is displayed");
//
//        System.out.println("TC03: Passed");
//    }
//
//    @Test (dataProvider = "TC04", dataProviderClass = StaticProvider.class)
//    public void TC04(String username, String password, String warningMessage) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("System shows message when user enters wrong password many times");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//
//        for (int i = 0; i < 4; i++) {
//            homePage = loginPage.loginAccount(username, password);
//            Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
//            System.out.println("Error message 'Invalid username or password. Please try again' is shown");
//        }
//
//        Assert.assertEquals(loginPage.getWarningMessage(), warningMessage, "Warning message does not appear!");
//        System.out.println("Warning message appears");
//
//        System.out.println("TC03: Passed");
//    }
//
//    @Test (dataProvider = "TC05", dataProviderClass = StaticProvider.class)
//    public void TC05(String username, String password) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User can't login with an account hasn't been activated");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//        homePage = loginPage.loginAccount(username, password);
//
//        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
//        System.out.println("Message 'Invalid username or password. Please try again.' appears");
//
//        System.out.println("TC05: Passed");
//    }
//
//    @Test (dataProvider = "TC06", dataProviderClass = StaticProvider.class)
//    public void TC06(String username, String password) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User is redirected to Home page after logging out");
//        System.out.println("Login with valid Email and Password");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//        homePage = loginPage.loginAccount(username, password);
//
//        System.out.println("Click on FAQ tab");
//        homePage.navigateTabPage("FAQ");
//
//        System.out.println("Click on Log out tab");
//        homePage.navigateTabPage("Log out");
//
//        Assert.assertTrue(homePage.getTabElement("Home").isDisplayed());
//        Assert.assertTrue(homePage.getTabElement("Login").isDisplayed());
//        System.out.println("Home page display");
//        System.out.println("Log out tab is disappeared");
//
//        System.out.println("TC05: Passed");
//    }
//
//    @Test (dataProvider = "TC07", dataProviderClass = StaticProvider.class)
//    public void TC07(String username, String password, String pid) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User can't create account with an already in-use email");
//        homePage.navigateTabPage("Register");
//        RegisterPage registerPage = new RegisterPage();
//        registerPage = registerPage.registerAccount(username, password, pid);
//
//        Assert.assertTrue(registerPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
//        System.out.println("Error message is displayed");
//
//        System.out.println("TC07: Passed");
//    }
//
//    @Test (dataProvider = "TC08", dataProviderClass = StaticProvider.class)
//    public void TC08(String username, String password, String pid) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User can't create account with an already in-use email");
//        homePage.navigateTabPage("Register");
//        RegisterPage registerPage = new RegisterPage();
//        registerPage = registerPage.registerAccount(username, password, pid);
//
//        Assert.assertTrue(registerPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
//        System.out.println("Message 'There're errors in the form. Please correct the errors and try again.' appears above the form");
//
//        Assert.assertTrue(registerPage.getErrorMessPW().isDisplayed(), "error message 'Invalid password length.' does not display");
//        System.out.println("Error message 'Invalid password length.' displays");
//
//        Assert.assertTrue(registerPage.getErrorMessPID().isDisplayed(), "error message 'Invalid ID length.' does not display");
//        System.out.println("Error message 'Invalid ID length.' displays");
//
//        System.out.println("TC08: Passed");
//    }
//
//    @Test (dataProvider = "TC09", dataProviderClass = StaticProvider.class)
//    public void TC09(String email, String password, String pid, int index) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User create and activate account");
//        RegisterPage registerPage = homePage.clickCreateAccLink();
//
//        Assert.assertTrue(registerPage.getHeaderRegisterPage().isDisplayed(),"Register page is not shown");
//        System.out.println("Register page is shown");
//
//
//        System.out.println("Enter valid information into all fields");
//
//        String railWayWindow = SeleniumHelper.saveWindownHandle(); // Save handle of Railway
//        MailPage mailPage = new MailPage();
//        MailPage.navigateToWebMail();
//        String username = mailPage.getMailFree(email);
//        SeleniumHelper.navigateBackToOriginalWindow(railWayWindow); //Back to Railway
//
//        registerPage = registerPage.registerAccount(username, password, pid);
//        String expectedSuccessMess = "Thank you for registering your account";
//        String actualSuccessMess = registerPage.getSuccessMess();
//        Assert.assertEquals(actualSuccessMess, expectedSuccessMess,"Success message shows incorrect");
//        System.out.println("Success message 'Thank you for registering your account' is shown");
//
//        SeleniumHelper.switchTab(railWayWindow);
//
//        String emailFreeWeb = SeleniumHelper.saveWindownHandle(); // Save handle of EmailFree Web
//
//        mailPage.confirmEmail();
//        SeleniumHelper.switchWindow(index, emailFreeWeb); //Switch to new tab
//
//        String expectedConfirmMessage = "Registration Confirmed! You can now log in to the site.";
//        String actualConfirmMessage = registerPage.getConfirmMess();
//        Assert.assertEquals(actualConfirmMessage, expectedConfirmMessage, "Confirm message does not display");
//        System.out.println("Message 'Registration Confirmed! You can now log in to the site' is shown");
//
//        System.out.println("TC09: Passed");
//    }
//
//    @Test (dataProvider = "TC10", dataProviderClass = StaticProvider.class)
//    public void TC10(String username, String email, String password, String confirmPW, int index) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("Reset password shows error if the new password is same as current");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//
//        System.out.println("Click on 'Forgot Password page' link");
//        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPasswordPage();
//
//        System.out.println("Enter the email address of the activated account");
//        forgotPasswordPage = forgotPasswordPage.enterEmailAddress(username);
//
//        MailPage mailPage = new MailPage();
//        MailPage.navigateToWebMail();
//        String emailFreeWeb = SeleniumHelper.saveWindownHandle(); // Save handle of EmailFree Web
//
//        mailPage.getMailFree(email);
//        mailPage.resetPw();
//        SeleniumHelper.switchWindow(index, emailFreeWeb); //Switch to new tab
//
//        Assert.assertTrue(forgotPasswordPage.getPWChangeForm().isDisplayed(), "Password Change form is not shown"); // verify PW change form display
//        Assert.assertTrue(forgotPasswordPage.getResetPWToken().isDisplayed(), "The reset password token is not show"); // Verify reset pw token
//        System.out.println("Password Change form is shown with the reset password token");
//
//        forgotPasswordPage.inputNewPW(password, confirmPW);
//
//        String expectedErrorMessage = "The new password cannot be the same with the current password";
//        String actualErrorMessage = forgotPasswordPage.getErrorMessage();
//        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message 'The new password cannot be the same with the current password' is NOT shown");
//        System.out.println("Error message 'The new password cannot be the same with the current password' is shown");
//
//        System.out.println("TC10: Passed");
//    }
//
//    @Test (dataProvider = "TC11", dataProviderClass = StaticProvider.class)
//    public void TC11(String username, String email, String password, String confirmPW, int index) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("Reset password shows error if the new password is same as current");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//
//        System.out.println("Click on 'Forgot Password page' link");
//        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPasswordPage();
//
//        System.out.println("Enter the email address of the activated account");
//        forgotPasswordPage = forgotPasswordPage.enterEmailAddress(username);
//
//        MailPage mailPage = new MailPage();
//        MailPage.navigateToWebMail();
//        String emailFreeWeb = SeleniumHelper.saveWindownHandle(); // Save handle of EmailFree Web
//
//        mailPage.getMailFree(email);
//        mailPage.resetPw();
//
//        SeleniumHelper.switchWindow(index,emailFreeWeb);
//        Assert.assertTrue(forgotPasswordPage.getPWChangeForm().isDisplayed(), "Password Change form is not shown"); // verify PW change form display
//        Assert.assertTrue(forgotPasswordPage.getResetPWToken().isDisplayed(), "The reset password token is not show"); // Verify reset pw token
//        System.out.println("Password Change form is shown with the reset password token");
//
//        forgotPasswordPage.inputNewPW(password, confirmPW);
//
//        String expectedErrorMessage = "Could not reset password. Please correct the errors and try again.";
//        String actualErrorMessage = forgotPasswordPage.getErrorMessage();
//        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message 'Could not reset password. Please correct the errors and try again.' is NOT shown");
//        System.out.println("Error message 'Could not reset password. Please correct the errors and try again.' displays above the form.");
//
//        String expectedErrorMessageConfirmPW = "The password confirmation did not match the new password.";
//        String actualErrorMessageConfirmPW = forgotPasswordPage.getErrorMessageConfirmPW();
//        Assert.assertEquals(actualErrorMessageConfirmPW, expectedErrorMessageConfirmPW, "Error message 'The password confirmation did not match the new password.' is NOT shown");
//        System.out.println("Error message 'The password confirmation did not match the new password.' displays next to the confirm password field.");
//
//        System.out.println("TC11: Passed");
//    }
//
//    @Test (dataProvider = "TC12", dataProviderClass = StaticProvider.class)
//    public void TC12(String username, String password, int daysFromToday, String departStation, String arriveStation, String seatType, int ticketAmount) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User can book 1 ticket at a time");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//
//        System.out.println("Login with a valid account ");
//        homePage = loginPage.loginAccount(username, password);
//
//        System.out.println("Click on Book ticket tab");
//        homePage.navigateTabPage("Book ticket");
//        BookTicketPage bookTicketPage = new BookTicketPage();
//
//        System.out.println("Select the next 12 days from 'Depart date'");
//        bookTicketPage = bookTicketPage.selectDepartDate(daysFromToday);
//
//        System.out.println("Select Depart from 'Nha Trang' and Arrive at 'Huế'");
//        bookTicketPage.selectStation(departStation, arriveStation);
//
//        System.out.println("Select 'Soft seat with air conditioner' for 'Seat type'");
//        bookTicketPage.selectSeatType(seatType);
//
//        System.out.println("Select '1' for 'Ticket amount'");
//        bookTicketPage.selectTicketAmount(ticketAmount);
//
//        System.out.println("Click on 'Book ticket' button");
//        bookTicketPage.clickBookTicketBtn();
//
//        System.out.println("Ticket booked successfully with corrected ticket info");
//        String expectedMessage = "Ticket booked successfully!";
//        String actualMessage = bookTicketPage.getsuccessMessage();
//
//        Assert.assertEquals(actualMessage, expectedMessage, "Message 'Ticket booked successfully!' does not display");
//        System.out.println("Message 'Ticket booked successfully!' displays");
//
//        System.out.println("TC12: Passed");
//    }
//
//    @Test (dataProvider = "TC13", dataProviderClass = StaticProvider.class)
//    public void TC13(String username, String password, int daysFromToday, String departStation, String arriveStation, String seatType, int ticketAmount) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User can book many tickets at a time");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//
//        System.out.println("Login with a valid account");
//        homePage = loginPage.loginAccount(username, password);
//
//        System.out.println("Click on Book ticket tab");
//        homePage.navigateTabPage("Book ticket");
//        BookTicketPage bookTicketPage = new BookTicketPage();
//
//        System.out.println("Select the next 12 days from 'Depart date'");
//        bookTicketPage = bookTicketPage.selectDepartDate(daysFromToday);
//
//        System.out.println("Select Depart from 'Nha Trang' and Arrive at 'Sài Gòn'");
//        bookTicketPage.selectStation(departStation, arriveStation);
//
//        System.out.println("Select 'Soft seat with air conditioner' for 'Seat type'");
//        bookTicketPage.selectSeatType(seatType);
//
//        System.out.println("Select '1' for 'Ticket amount'");
//        bookTicketPage.selectTicketAmount(ticketAmount);
//
//        System.out.println("Click on 'Book ticket' button");
//        bookTicketPage.clickBookTicketBtn();
//
//        System.out.println("Ticket booked successfully with corrected ticket info");
//        String expectedMessage = "Ticket booked successfully!";
//        String actualMessage = bookTicketPage.getsuccessMessage();
//
//        Assert.assertEquals(actualMessage, expectedMessage, "Message 'Ticket booked successfully!' does not display");
//        System.out.println("Message 'Ticket booked successfully!' displays");
//
//        System.out.println("TC13: Passed");
//    }
//
//    @Test (dataProvider = "TC14", dataProviderClass = StaticProvider.class)
//    public void TC14(String username, String password, String departStation, String arriveStation) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User can check price of ticket from Timetable");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//
//        System.out.println("Login with a valid account");
//        homePage = loginPage.loginAccount(username, password);
//
//        System.out.println("Click on 'Timetable' tab");
//        homePage.navigateTabPage("Timetable");
//        TimeTablePage timeTablePage = new TimeTablePage();
//
//        System.out.println("Click on “check price” of Da Nang - Sai Gon");
//        TicketPricePage ticketPricePage = timeTablePage.clickCheckPrice(departStation, arriveStation);
//
//        String expectedTicketTableText = "Ticket price from Đà Nẵng to Sài Gòn";
//        String actualTicketTableText = ticketPricePage.getTicketTableText();
//        Assert.assertEquals(actualTicketTableText, expectedTicketTableText, "Ticket table shows incorrectly");
//        System.out.println("Ticket table shows 'Ticket price from Đà Nẵng to Sài Gòn'");
//
//        ticketPricePage.compareValues();
//        System.out.println("TC14: Passed");
//    }
//
//    @Test (dataProvider = "TC15", dataProviderClass = StaticProvider.class)
//    public void TC15(String username, String password, String departStation, String arriveStation, int daysFromToday, int ticketAmount) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User can book ticket from Timetable");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//
//        System.out.println("Login with a valid account");
//        homePage = loginPage.loginAccount(username, password);
//
//        System.out.println("Click on 'Timetable' tab");
//        homePage.navigateTabPage("Timetable");
//        TimeTablePage timeTablePage = new TimeTablePage();
//
//        System.out.println("Click on book ticket of route 'Quảng Ngãi' to 'Huế'");
//        timeTablePage.clickBookTicket(departStation, arriveStation);
//        BookTicketPage bookTicketPage = new BookTicketPage();
//
//        Assert.assertTrue(bookTicketPage.getbBookTicketForm().isDisplayed(),"Book ticket form is not shown!");
//
//        String actualDepart = bookTicketPage.getDepartFrom();
//        Assert.assertEquals(actualDepart, departStation, "Book ticket form is shown with the incorrect 'depart from'");
//        System.out.println("Book ticket form is shown with the corrected 'depart from'");
//
//        String actualArrive = bookTicketPage.getArriveAt();
//        Assert.assertEquals(actualArrive, arriveStation, "Book ticket form is shown with the incorrect 'arrive at'");
//        System.out.println("Book ticket form is shown with the corrected 'arrive at'");
//
//        System.out.println("Select Depart date next 10 days");
//        bookTicketPage.selectDepartDate(daysFromToday);
//
//        System.out.println("Select Ticket amount = 5");
//        bookTicketPage.selectTicketAmount(ticketAmount);
//
//        System.out.println("Click on 'Book ticket' button");
//        bookTicketPage.clickBookTicketBtn();
//
//        System.out.println("Ticket booked successfully with corrected ticket info");
//        String expectedMessage = "Ticket booked successfully!";
//        String actualMessage = bookTicketPage.getsuccessMessage();
//
//        Assert.assertEquals(actualMessage, expectedMessage, "Message 'Ticket booked successfully!' displays. Ticket information display incorrectly");
//        System.out.println("Message 'Ticket booked successfully!' displays. Ticket information display correctly");
//
//        System.out.println("TC15: Passed");
//    }
//
//    @Test (dataProvider = "TC16", dataProviderClass = StaticProvider.class)
//    public void TC16(String username, String password, int daysFromToday, String departStation, String arriveStation, String seatType, int ticketAmount) {
//        HomePage homePage = new HomePage();
//
//        System.out.println("User can cancel a ticket");
//        homePage.navigateTabPage("Login");
//        LoginPage loginPage = new LoginPage();
//
//        System.out.println("Login with a valid account");
//        homePage = loginPage.loginAccount(username, password);
//
//        System.out.println("Book a ticket");
//        homePage.navigateTabPage("Book ticket");
//        BookTicketPage bookTicketPage = new BookTicketPage();
//
//        System.out.println("Select the next 12 days from 'Depart date'");
//        bookTicketPage = bookTicketPage.selectDepartDate(daysFromToday);
//
//        System.out.println("Select Depart from 'Nha Trang' and Arrive at 'Huế'");
//        bookTicketPage.selectStation(departStation, arriveStation);
//
//        System.out.println("Select 'Soft seat with air conditioner' for 'Seat type'");
//        bookTicketPage.selectSeatType(seatType);
//
//        System.out.println("Select '1' for 'Ticket amount'");
//        bookTicketPage.selectTicketAmount(ticketAmount);
//
//        System.out.println("Click on 'Book ticket' button");
//        bookTicketPage.clickBookTicketBtn();
//
//        System.out.println("Ticket booked successfully with corrected ticket info");
//        String expectedMessage = "Ticket booked successfully!";
//        String actualMessage = bookTicketPage.getsuccessMessage();
//
//        Assert.assertEquals(actualMessage, expectedMessage, "Message 'Ticket booked successfully!' does not displays");
//        System.out.println("Message 'Ticket booked successfully!' display");
//
//        System.out.println("Click on 'My ticket' tab");
//        homePage.navigateTabPage("My ticket");
//        MyTicketPage myTicketPage = new MyTicketPage();
//
//        System.out.println("Click on 'Cancel' button of ticket which user want to cancel.");
//        myTicketPage.clickCancelBtn();
//
//        Assert.assertTrue(myTicketPage.getTicketRow(departStation, arriveStation).isDisplayed(), "The canceled ticket still appear");
//        System.out.println("The canceled ticket is disappeared");
//
//        System.out.println("TC16: Passed");
//    }
}
