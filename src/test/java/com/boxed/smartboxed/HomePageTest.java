package com.boxed.smartboxed;

import org.testng.annotations.Test;

/**
 * Created by monwarjalil on 11/7/18.
 */
    public class HomePageTest extends AbstractTest{

         @Test(groups = {"sanity"})
         public void verifyDashboardComponent() throws InterruptedException {
             homePage = loginPage.signInUser();
             homePage.verifyDimensionLocator();
             homePage.verifyOrderSummaryLocator();
         }
}
