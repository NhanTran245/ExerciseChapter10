package testcases;

import helper.BrowserUtils;
import helper.Constant;
import helper.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Fixed_TestBase {
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser) throws Exception {
        DriverUtils.initDriver(browser);
        BrowserUtils.navigateTo(Constant.URL);
        BrowserUtils.maximize();

    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.close();

    }
}

