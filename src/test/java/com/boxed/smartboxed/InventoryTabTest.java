package com.boxed.smartboxed;

import annotations.NeedsLogout;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by monwarjalil on 11/5/18.
 */

    public class InventoryTabTest extends AbstractTest{

    @NeedsLogout
    @Test(groups = {"samples"})
    public void testFilterInventoryItem () throws InterruptedException {
        homePage = loginPage.signInUser();
        inventoryItemPage = homePage.header.navigateToInventoryItemPage();
        inventoryItemPage.queryInventory();

    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testOpenInventoryItemPage () throws InterruptedException {
        homePage = loginPage.signInUser();
        inventoryItemPage = homePage.header.navigateToInventoryItemPage();
    }

    @NeedsLogout
    @Test(groups = {"samples"})
    public void testCopyToClipboard () throws InterruptedException {
        homePage = loginPage.signInUser();
        inventoryItemPage = homePage.header.navigateToInventoryItemPage();
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testWareHouseInventoriesPage () throws InterruptedException {
        homePage = loginPage.signInUser();
        warehouseInventoriesPage = homePage.header.navigateToWarehouseInventories();
        warehouseInventoriesPage.testVerifyFilterGidsFiled();
        warehouseInventoriesPage.testVerifyFilterTableGids();
    }

    @NeedsLogout
    @Test(groups = {"samples"})
    public void testFilterWarehouseInventories () throws InterruptedException {
        homePage = loginPage.signInUser();
        warehouseInventoriesPage = homePage.header.navigateToWarehouseInventories();
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testOpenPurchaseOrderPage() throws InterruptedException {
        homePage = loginPage.signInUser();
        purchaseOrdersPage = homePage.header.navigateToPurchaseOrdersPage();
        purchaseOrdersPage.verifyFieldsPresence();

    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testOpenCycleCountsPage() throws InterruptedException {
        homePage = loginPage.signInUser();
        cycleCountsPage = homePage.header.navigateToCycleCountPage();
        cycleCountsPage.testVerifyCycleCountButtons();
    }

}
