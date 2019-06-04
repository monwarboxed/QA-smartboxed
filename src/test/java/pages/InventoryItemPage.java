package pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 12/3/18.
 */
public class InventoryItemPage extends AbstractPage {

    public InventoryItemPage() {
        verifyPresence();
    }

    public Header header = new Header();

    By bodySectionLocator = By.xpath("/html//h3[.='Inventory']");

    public void verifyPresence() {wait.until(visibilityOfElementLocated(bodySectionLocator));}

    By gidFieldLocator = By.cssSelector("[placeholder='gid']");

    By nameFieldLocator = By.cssSelector("[placeholder='Name']");

    By extendedNameFieldLocator = By.cssSelector("[placeholder='Extended Name']");

    By sidFieldLocator = By.cssSelector("[placeholder='sid']");

    By copyToClipboard = By.xpath("//*[@id=\"search\"]/div/div[5]/div/input");

    By searchgidfieldLocator = By.cssSelector("#flt0_inventoryTable");

    public void queryInventory() throws InterruptedException {
        type(gidFieldLocator,"8");
        type(nameFieldLocator,"Bounty Paper Towels");
        type(extendedNameFieldLocator,"12 Count Print");
        Thread.sleep(5000);
    }

    public Boolean getstring() throws InterruptedException {
        Thread.sleep(2000);
//        return elementBy(searchgidfieldLocator).
        return true;

    }

}
