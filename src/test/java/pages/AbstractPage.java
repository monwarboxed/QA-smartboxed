package pages;

import com.boxed.smartboxed.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by monwarjalil on 11/1/18.
 */
public class AbstractPage {

    protected WebDriver driver = AbstractTest.driver;

    protected Actions actions = new Actions(driver);

    protected WebDriverWait wait = new WebDriverWait(driver,15);

    protected  WebElement elementBy(By locator) {
        return driver.findElement(locator);
    }

    protected void type(WebElement element, String input) {
        element.sendKeys(input);
    }

    protected void type (By locator, String input) {
        type(elementBy(locator), input);
    }

    protected void click(WebElement element) { element.click();}
}

