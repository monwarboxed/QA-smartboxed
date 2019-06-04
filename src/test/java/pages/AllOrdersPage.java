package pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 3/21/19.
 */
public class AllOrdersPage extends AbstractPage {

    public Header header = new Header();

    public AllOrdersPage() {
        verifyPresence();
    }

    public void verifyPresence() {
        wait.until(visibilityOfElementLocated(AllOrdersPageBodySectionLocator));
    }

    By AllOrdersPageBodySectionLocator = By.cssSelector("body > div.container");

    By LastButtonSelector = By.cssSelector("#order-pagination > li:nth-child(13) > a");

    public AllOrdersPage selectOpenOrder() {
        click(wait.until(visibilityOfElementLocated(LastButtonSelector)));
        return new AllOrdersPage();
    }
}
