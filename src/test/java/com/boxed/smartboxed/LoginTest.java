package com.boxed.smartboxed;

import org.testng.annotations.Test;
import pages.HomePage;

/**
 * Created by monwarjalil on 11/7/18.
 */
public class LoginTest extends AbstractTest{


    @Test(groups = {"sanity"})
    public void testInvalidUser() {
        loginPage.invalidUser();
    }

    @Test(groups = {"sanity"})
    public void testSignInUser() throws InterruptedException {
       homePage = loginPage.signInUser();
       Thread.sleep(2000);
    }

    @Test(groups = {"sanity"})
    public void testLoginFormUser() throws InterruptedException {
        loginPage.observeLoginPresence();
        Thread.sleep(2000);
    }




}
