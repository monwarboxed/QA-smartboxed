package com.boxed.smartboxed;

import annotations.NeedsLogout;
import org.testng.annotations.Test;

/**
 * Created by monwarjalil on 3/12/19.
 */
public class BatchPoolTest extends AbstractTest {

    @NeedsLogout
    @Test(groups = {"smoke"})
    public void testVerifyPresence() throws InterruptedException{
        homePage = loginPage.signInUser();
        batchPoolPage = homePage.header.navigateToBatchPoolPage();
        batchPoolPage.verifyComponentPresence();
    }

}
