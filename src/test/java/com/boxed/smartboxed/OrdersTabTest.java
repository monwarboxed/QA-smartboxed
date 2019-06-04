package com.boxed.smartboxed;

import annotations.NeedsLogout;
import org.testng.annotations.Test;
import pages.AllOrdersPage;

/**
 * Created by monwarjalil on 11/5/18.
 */
public class OrdersTabTest extends AbstractTest {

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testClickViewOrderPage() throws InterruptedException {
        homePage = loginPage.signInUser();
        viewOrdersPage = homePage.header.navigateToViewOrdersPage();
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testClickAllOrderPage() throws InterruptedException {
        homePage = loginPage.signInUser();
        allOrdersPage = homePage.header.navigateToAllOrdersPage();
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testClickSmartBoxedShipmentPage() throws InterruptedException {
        homePage = loginPage.signInUser();
        smartBoxedShipmentPage = homePage.header.navigateToSmartBoxedShipmentPage();
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testEasyPostOrders() throws InterruptedException {
        homePage = loginPage.signInUser();
        allOrdersPage = homePage.header.navigateToAllOrdersPage();
        allOrdersPage = allOrdersPage.selectOpenOrder();

    }

}
