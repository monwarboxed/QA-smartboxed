package com.boxed.smartboxed;

import annotations.NeedsLogout;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by monwarjalil on 11/6/18.
 */
public class HeaderTest extends AbstractTest{

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testClickNonDropdownOptions() throws InterruptedException {
        homePage = loginPage.signInUser();
        homePage = homePage.header.smartBoxedLogo();
        userTabPage = homePage.header.navigateToUserTabPage();
        configPages = userTabPage.header.navigateToConfigPage();
        batchPoolPage = configPages.header.navigateToBatchPoolPage();
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testHoverOnDropdownOptions() throws InterruptedException {
        homePage = loginPage.signInUser();
        homePage.header.hoverOnInventoryTab();
        homePage.header.hoverOnOrderTab();
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testClickUserDetails() throws InterruptedException {
        homePage = loginPage.signInUser();
        userDetailsPage = homePage.header.navigateToUserDetailsPage();
        Thread.sleep(5000);
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testSwitchWarehouse() throws InterruptedException {
        homePage = loginPage.signInUser();
        homePage.header.SwitchToDifferentWareHouses();

    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testSignOut() throws InterruptedException {
        homePage = loginPage.signInUser();
        loginPage = homePage.header.signOut();
    }


}
