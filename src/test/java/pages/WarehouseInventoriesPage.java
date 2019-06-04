package pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 12/7/18.
 */
public class WarehouseInventoriesPage extends AbstractPage {
    public WarehouseInventoriesPage() {verifyPresence();}

    public Header header = new Header();

    By warehouseInventoryMenuLocator = By.cssSelector("body");

    public void verifyPresence() {wait.until(visibilityOfElementLocated(warehouseInventoryMenuLocator));}

    By filerByGidsField = By.cssSelector("#gid-search");

    By filterByTableGids = By.cssSelector("#inventoryTable > thead > tr.fltrow");

    public void testVerifyFilterGidsFiled() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(visibilityOfElementLocated(filerByGidsField));
    }

    public void testVerifyFilterTableGids() throws InterruptedException {
        wait.until(visibilityOfElementLocated(filterByTableGids));
    }

    public void testFiltersByGids() throws InterruptedException {

    }

}
