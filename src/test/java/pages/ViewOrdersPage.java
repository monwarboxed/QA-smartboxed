package pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/27/18.
 */
public class ViewOrdersPage extends AbstractPage {
    public ViewOrdersPage() {verifyPresence();}

    public Header header = new Header();

    By BodySection = By.cssSelector("body > div.header > h4");

    public void verifyPresence() {wait.until(visibilityOfElementLocated(BodySection));}

}
