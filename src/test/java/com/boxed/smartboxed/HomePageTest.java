package com.boxed.smartboxed;


import annotations.NeedsLogout;
import org.testng.annotations.Test;

/**
 * Created by monwarjalil on 11/7/18.
 */
    public class HomePageTest extends AbstractTest{

         @NeedsLogout
         @Test(groups = {"smoke"})
         public void verifyDashboardComponent() throws InterruptedException {
             homePage = loginPage.signInUser();
             homePage.verifyDimensionLocator();
             homePage.verifyOrderSummaryLocator();
         }
}
