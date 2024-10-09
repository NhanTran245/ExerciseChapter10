package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import helper.DriverUtils;

import java.util.concurrent.TimeUnit;

import static helper.DriverUtils.driver;

public class TestBase {

//    @DataProvider(name = "Driver")
//    public Object[][] createData() {
//        return new Object[][] {
//                {"ChromeDriver()"},
//                {"FirefoxDriver()"}
//        };
//    }

    @BeforeMethod
    public void beforeTest() {

//        String browser = "chrome"; // Có thể thay đổi thành "firefox" để sử dụng Firefox
//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverUtils.driver.get("http://saferailway.somee.com/"); // Open the application
    }

    public void setup() {

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    public void teardown() {

    }
}
