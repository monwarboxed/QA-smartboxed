package com.boxed.smartboxed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by monwarjalil on 11/1/18.
 */
public class UserTabTest extends AbstractTest {

    @Test(groups = {"sanity"})
    public void testCreateUserAccount() throws InterruptedException{
        homePage = loginPage.signInUser();
        userTabPage = homePage.header.navigateToUserTabPage();
        userDetailsPage = userTabPage.addUser();
        Thread.sleep(5000);
        userTabPage = userDetailsPage.createUser();
    }

    @Test(groups = {"sanity"})
    public void testUpdateUserAccount() throws InterruptedException{
        homePage = loginPage.signInUser();
        userDetailsPage = homePage.header.navigateToUserDetailsPage();
        userDetailsPage.updateUserDetails();
    }

    @Test(groups = {"sanity"})
    public void testDeactivateUserAccount() throws InterruptedException{
        homePage = loginPage.signInUser();
        userTabPage = homePage.header.navigateToUserTabPage();
        userDetailsPage = userTabPage.addUser();
        userDetailsPage.createUser();
    }

    @Test(groups = {"sanity"})
    public void testNavigateToUserDetails() throws InterruptedException{
        homePage = loginPage.signInUser();
        userTabPage = homePage.header.navigateToUserTabPage();
        userDetailsPage = userTabPage.navigateUser();
        Thread.sleep(2000);
    }
}
