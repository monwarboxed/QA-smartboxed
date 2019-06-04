package com.boxed.smartboxed;

import org.testng.annotations.Test;

/**
 * Created by monwarjalil on 11/7/18.
 */
public class LoginTest extends AbstractTest{


    @Test(groups = {"smoke"})
    public void testInvalidUser() throws InterruptedException {
        loginPage.invalidUser();
        loginPage.getErrorMessage();
        Thread.sleep(5000);
    }

    @Test(groups = {"smoke"})
    public void testSignInUser() throws InterruptedException {
       homePage = loginPage.signInUser();
    }

    @Test(groups = {"smoke"})
    public void testLoginFormUser() throws InterruptedException {
        loginPage.observeLoginPresence();
    }

}
