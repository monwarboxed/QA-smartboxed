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
    public void createUserAccount() throws InterruptedException{
        homePage = loginPage.signInUser();
        userTabPage = homePage.header.navigateToUserTabPage();
        userDetailsPage = userTabPage.addUser();
        Thread.sleep(5000);
        userTabPage = userDetailsPage.createUser();
    }

    @Test(groups = {"sanity"})
    public void updateUserAccount() throws InterruptedException{
        homePage = loginPage.signInUser();
        userDetailsPage = homePage.header.navigateToUserDetailsPage();
    }

    @Test(groups = {"sanity"})
    public void deactivateUserAccount() {
    }

}
