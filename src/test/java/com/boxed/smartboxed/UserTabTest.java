package com.boxed.smartboxed;

import annotations.NeedsLogout;
import org.testng.annotations.Test;
import utilities.AccountHelper;

/**
 * Created by monwarjalil on 11/1/18.
 */
public class UserTabTest extends AbstractTest {

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testCreateNewUser() throws InterruptedException {
        homePage = loginPage.signInUser();
        userTabPage = homePage.header.navigateToUserTabPage();
        userDetailsPage = userTabPage.addUser();
        userTabPage = userDetailsPage.signUpWithValidCredentials(AccountHelper.getNewAccountEmail(6));
        Thread.sleep(2000);
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testNavigateToUserDetails() throws InterruptedException {
        homePage = loginPage.signInUser();
        userTabPage = homePage.header.navigateToUserTabPage();
        userDetailsPage = userTabPage.navigateUserDetailsPage();
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testDeactivateAndReactivate() throws InterruptedException {
        homePage = loginPage.signInUser();
        userTabPage = homePage.header.navigateToUserTabPage();
        userDetailsPage = userTabPage.navigateUserDetailsPage();
        deactivateAccountModalPage = userDetailsPage.deactivateUserAccount();
        userDetailsPage = deactivateAccountModalPage.deactivateUser();
        userDetailsPage = userDetailsPage.reactivateAccount();
    }

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testUpdateAccountDetails()throws InterruptedException {
        homePage = loginPage.signInUser();

    }
}
