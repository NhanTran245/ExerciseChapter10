package common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManagement;

import java.util.concurrent.TimeUnit;

import static utils.DriverManagement.driver;

public class TestPage {

//    @DataProvider(name = "Driver")
//    public Object[][] createData() {
//        return new Object[][] {
//                {"ChromeDriver()"},
//                {"FirefoxDriver()"}
//        };
//    }

    @BeforeMethod
    public void beforeTest() {

        String browser = "chrome"; // Có thể thay đổi thành "firefox" để sử dụng Firefox

//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManagement.driver.get("http://saferailway.somee.com/"); // Open the application
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
