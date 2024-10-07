package Pages;

import common.BasePage;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static utils.DriverManagement.driver;

public class HomePage extends BasePage {

    protected By createAccLink = By.xpath("//a[text() = 'create an account']");

    public RegisterPage clickCreateAccLink() {
        driver.findElement(createAccLink).click();
        return new RegisterPage();
    }

}