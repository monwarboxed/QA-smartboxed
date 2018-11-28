package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/6/18.
 */
public class HomePage extends AbstractPage{

    public HomePage() {
        verifyPresence();
    }

    public Header header = new Header();

    By bodySectionLocator = By.cssSelector("body > div.container > div.smartboxed-home > h1.text-left > a > font");

    public void verifyPresence() {wait.until(visibilityOfElementLocated(bodySectionLocator));}

    By orderSummaryLocator = By.className("col-lg-6");

    By dimensionLocator = By.id("box-dimensions");

    public void verifyOrderSummaryLocator() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(visibilityOfElementLocated(orderSummaryLocator));
    }

    public void verifyDimensionLocator() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(visibilityOfElementLocated(dimensionLocator));
    }



}
