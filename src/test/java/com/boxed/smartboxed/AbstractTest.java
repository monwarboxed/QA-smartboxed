package com.boxed.smartboxed;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

/**
 * Created by monwarjalil on 11/1/18.
 */
public class AbstractTest {
    public static WebDriver driver;

    protected Header header;
    protected HomePage homePage;
    protected InventoryTabPage inventoryTabPage;
    protected LoginPage loginPage;
    protected OrdersTabPage ordersTabPage;
    protected UserTabPage userTabPage;
    protected UserDetailsPage userDetailsPage;
    protected ConfigPages configPages;
    protected BatchPoolPage batchPoolPage;
    protected ViewOrdersPage viewOrdersPage;



    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/monwarjalil/Documents/QA-web/bin/chromedriver_mac_64");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void loginUser() throws InterruptedException{
        driver.navigate().to("https://vpc-staging-smartboxed.boxed.com/login");
        loginPage = new LoginPage();
    }

    @AfterSuite
    public void cleanUp(){
        driver.quit();
    }

}
