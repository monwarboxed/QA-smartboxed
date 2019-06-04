package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/6/18.
 */
public class Header extends AbstractPage{
    public Header() {
        PageFactory.initElements(driver, this);
        verifyPresence();
    }

    public void verifyPresence() {wait.until(visibilityOfElementLocated(HeaderSectionLocator));}

    By HeaderSectionLocator = By.cssSelector("body > div.header > div");

    By SignOutLinkLocator = By.cssSelector("body > div.header > div > div > div > ul:nth-child(2) > li > a");

    By SmartBoxedLogoLocator = By.className("navbar-brand");

    By UsersLinkLocator = By.linkText("Users");

    By ConfigsLinkLocator = By.linkText("Configs");

    By BatchPoolsLinkLocator = By.linkText("Batch pools");

    By UserDetailsLinkLocator = By.cssSelector("body > div.header > div > div > div > ul:nth-child(3) > li > a");

    By InventoryMenuLocator = By.cssSelector("#inventoryMenu");

    By InventoryItemLocator = By.linkText("Inventory Items");

    By PurchaseOrderLocator = By.linkText("Purchase Orders");

    By SuperAdministratorLocator = By.cssSelector(".text-right");

    By WareHouseSelectorLocator = By.cssSelector("#warehouse-select");

    By nationalSelectorLocator = By.cssSelector("#warehouse-select > option:nth-child(1)");

    By cheyenneSelectorLocator = By.cssSelector("#warehouse-select > option:nth-child(4)");

    By labsSelectorLocator = By.cssSelector("#warehouse-select > option:nth-child(8)");

    By WareHouseInventoriesPageLocator = By.linkText("Warehouse Inventories");

    By OrderMenuLocator = By.cssSelector("#ordersMenu");

    By ViewOrderLocator = By.linkText("View Order");

    By AllOrderLocator = By.linkText("All Orders");

    By SmartBoxedShipmentSelector = By.linkText("Smartboxed Shipments");

    By CycleCountSelector = By.linkText("Cycle Counts");

    @FindBy(css = "#inventoryMenu")
    private WebElement inventory;

    @FindBy(css = "#ordersMenu")
    private WebElement orders;

    public LoginPage signOut() {
      click(wait.until(visibilityOfElementLocated(SignOutLinkLocator)));
      return new LoginPage();
    }

    public HomePage smartBoxedLogo() {
        click(wait.until(visibilityOfElementLocated(SmartBoxedLogoLocator)));
        return new HomePage();
    }

    public UserTabPage navigateToUserTabPage() {
        click(wait.until(visibilityOfElementLocated(UsersLinkLocator)));
        return new UserTabPage();
    }

    public ConfigPages navigateToConfigPage() {
        click(wait.until(visibilityOfElementLocated(ConfigsLinkLocator)));
        return new ConfigPages();
    }

    public BatchPoolPage navigateToBatchPoolPage() {
        click(wait.until(visibilityOfElementLocated(BatchPoolsLinkLocator)));
        return new BatchPoolPage();
    }

    public UserDetailsPage navigateToUserDetailsPage() {
        click(wait.until(visibilityOfElementLocated(UserDetailsLinkLocator)));
        return new UserDetailsPage();
    }

    public void hoverOnInventoryTab() throws InterruptedException {
        Actions action  = new Actions(driver);

        System.out.println("inventory " + inventory.getSize());
        action.moveToElement(inventory).perform();
    }

    public void hoverOnOrderTab() throws  InterruptedException {
        System.out.println("orders" + orders.getSize());
        actions.moveToElement(orders).perform();
    }

    public InventoryItemPage navigateToInventoryItemPage() throws InterruptedException {
        click(wait.until(visibilityOf(inventory)));
        Thread.sleep(2000);
        click(wait.until(visibilityOfElementLocated(InventoryItemLocator)));
        return new InventoryItemPage();
    }

    public WarehouseInventoriesPage navigateToWarehouseInventories() throws InterruptedException {
        click(wait.until(visibilityOf(inventory)));
        Thread.sleep(2000);
        click(wait.until(visibilityOfElementLocated(WareHouseInventoriesPageLocator)));
        return new WarehouseInventoriesPage();
    }

    public PurchaseOrdersPage navigateToPurchaseOrdersPage() throws InterruptedException {
        click(wait.until(visibilityOf(inventory)));
        Thread.sleep(2000);
        click(wait.until(visibilityOfElementLocated(PurchaseOrderLocator)));
        return new PurchaseOrdersPage();
    }

    public void SwitchToDifferentWareHouses() throws InterruptedException {
        click(wait.until(visibilityOfElementLocated(WareHouseSelectorLocator)));
        click(wait.until(visibilityOfElementLocated(nationalSelectorLocator)));
        click(wait.until(visibilityOfElementLocated(cheyenneSelectorLocator)));
        click(wait.until(visibilityOfElementLocated(labsSelectorLocator)));

    }

    public ViewOrdersPage navigateToViewOrdersPage() throws InterruptedException {
        click(wait.until(visibilityOfElementLocated(OrderMenuLocator)));
        Thread.sleep(2000);
        click(wait.until(visibilityOfElementLocated(ViewOrderLocator)));
        Thread.sleep(2000);
        return new ViewOrdersPage();
    }

    public AllOrdersPage navigateToAllOrdersPage() throws InterruptedException {
        click(wait.until(visibilityOfElementLocated(OrderMenuLocator)));
        click(wait.until(visibilityOfElementLocated(AllOrderLocator)));
        return new AllOrdersPage();
    }

    public SmartBoxedShipmentPage navigateToSmartBoxedShipmentPage() throws InterruptedException {
        click(wait.until(visibilityOfElementLocated(OrderMenuLocator)));
        Thread.sleep(2000);
        click(wait.until(visibilityOfElementLocated(SmartBoxedShipmentSelector)));
        return new SmartBoxedShipmentPage();
    }

    public CycleCountsPage navigateToCycleCountPage() throws InterruptedException {
        click(wait.until(visibilityOfElementLocated(InventoryMenuLocator)));
        Thread.sleep(2000);
        click(wait.until(visibilityOfElementLocated(CycleCountSelector)));
        return new CycleCountsPage();
    }





}
