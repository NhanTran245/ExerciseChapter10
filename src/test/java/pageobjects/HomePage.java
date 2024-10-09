package pageobjects;

import common.BasePage;
import org.openqa.selenium.By;

import static helper.DriverUtils.driver;

public class HomePage extends BasePage {

    protected By createAccLink = By.xpath("//a[text() = 'create an account']");

    public RegisterPage clickCreateAccLink() {
        driver.findElement(createAccLink).click();
        return new RegisterPage();
    }

}