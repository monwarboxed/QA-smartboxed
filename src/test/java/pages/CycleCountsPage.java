package pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 1/2/19.
 */
public class CycleCountsPage extends AbstractPage{

    public Header header = new Header();

    public void verifyPresence() {
        wait.until(visibilityOfElementLocated(CycleCountsPageBodySectionLocator));
    }

    By CycleCountsPageBodySectionLocator = By.cssSelector("body > div.container");

    By CreateCycleCountbuttonLocator = By.cssSelector("body > div.container > p > a");

    By ViewDiscrenpanciesLocator = By.linkText("View Discrepancies");


    public void testVerifyCycleCountButtons() throws InterruptedException {
        wait.until(visibilityOfElementLocated(CreateCycleCountbuttonLocator));
        wait.until(visibilityOfElementLocated(ViewDiscrenpanciesLocator));
    }

}
