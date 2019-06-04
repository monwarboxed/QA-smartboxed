package pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 3/23/19.
 */
public class SmartBoxedShipmentPage extends AbstractPage {

    public Header header = new Header();

    By BodySection = By.cssSelector("body");

    public void verifyPresence() {wait.until(visibilityOfElementLocated(BodySection));}


}
