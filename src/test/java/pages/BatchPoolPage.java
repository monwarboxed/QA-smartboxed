package pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/13/18.
 */
public class BatchPoolPage extends AbstractPage {

    public Header header = new Header();

    public void verifyPresence() {
        wait.until(visibilityOfElementLocated(batchPoolPageBodySection));
    }

    By batchPoolPageBodySection = By.cssSelector("body > div.container");

    By gidFilterFieldLocator = By.id("gid-search");

    By newPoolButtonLocator = By.id("createNewBatchPool");

    By newHigherPriorityOnlyPoolLocator = By.id("createNewHighPriorityBatchPool");

    By newCartPoolLocator = By.id("createNewBulkBatchPool");

    public void verifyComponentPresence() throws InterruptedException {
        wait.until(visibilityOfElementLocated(gidFilterFieldLocator));
        Thread.sleep(2000);
        wait.until(visibilityOfElementLocated(newPoolButtonLocator));
        wait.until(visibilityOfElementLocated(newHigherPriorityOnlyPoolLocator));
        wait.until(visibilityOfElementLocated(newCartPoolLocator));
    }


}
