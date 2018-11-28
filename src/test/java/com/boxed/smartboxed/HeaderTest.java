package com.boxed.smartboxed;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created by monwarjalil on 11/6/18.
 */
public class HeaderTest extends AbstractTest{

    @Test(groups = {"sanity"})
    public void testSignOut() throws InterruptedException {
       homePage = loginPage.signInUser();
       loginPage = homePage.header.signOut();
       Thread.sleep(1000);
    }

    @Test(groups = {"sanity"})
    public void testHeaderComponent() throws InterruptedException {
        homePage = loginPage.signInUser();
        homePage = homePage.header.smartBoxedLogo();
        userTabPage = homePage.header.navigateToUserTabPage();
        Thread.sleep(1000);
        configPages = userTabPage.header.navigateToConfigPage();
        Thread.sleep(1000);
        batchPoolPage = configPages.header.navigateToBatchPoolPage();
        Thread.sleep(1000);
        userDetailsPage = batchPoolPage.header.navigateToUserDetailsPage();
        Thread.sleep(5000);
        userDetailsPage.header.hoverOnInventoryTab();
        Thread.sleep(10000);
        userDetailsPage.header.hoverOnOrderTab();
        Thread.sleep(7000);
    }


}
