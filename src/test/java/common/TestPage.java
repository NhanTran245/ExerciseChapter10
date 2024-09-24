package common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import utils.DriverManagement;

import java.util.concurrent.TimeUnit;

import static utils.DriverManagement.driver;

public class TestPage {

    @DataProvider(name = "Driver")
    public Object[][] createData() {
        return new Object[][] {
                {"ChromeDriver()"},
                {"FirefoxDriver()"}
        };
    }

    @BeforeMethod
    public void beforeTest() {
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
