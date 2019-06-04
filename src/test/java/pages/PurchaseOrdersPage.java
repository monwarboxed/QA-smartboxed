package pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 12/20/18.
 */
public class PurchaseOrdersPage extends AbstractPage {
    public PurchaseOrdersPage() {verifyPresence();}

    public Header header = new Header();

    By purchaseOrdersSectionLocator = By.cssSelector("body > div.container > h3");

    By gidFieldLocator = By.cssSelector("#gid-search");

    By vendorP0NumberFieldLocator = By.cssSelector("#vendor-po-search");

    By searchFieldLocator = By.xpath("//div[@id='purchaseOrderTable_filter']//input[@type='search']");

    By filterActionButtonLocator = By.cssSelector("body > div:nth-child(3) > div.row > div:nth-child(1) > button");

    public void verifyPresence() {wait.until(visibilityOfElementLocated(purchaseOrdersSectionLocator));}

    public void verifyFieldsPresence() throws InterruptedException{
        wait.until(visibilityOfElementLocated(gidFieldLocator));
        Thread.sleep(2000);
        wait.until(visibilityOfElementLocated(vendorP0NumberFieldLocator));
        wait.until(visibilityOfElementLocated(searchFieldLocator));
        wait.until(visibilityOfElementLocated(filterActionButtonLocator));
    }

}
