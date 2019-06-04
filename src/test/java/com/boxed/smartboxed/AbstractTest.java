package com.boxed.smartboxed;


import annotations.NeedsLogout;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.sql.Driver;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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
    protected InventoryItemPage inventoryItemPage;
    protected WarehouseInventoriesPage warehouseInventoriesPage;
    protected PurchaseOrdersPage purchaseOrdersPage;
    protected DeactivateAccountModalPage deactivateAccountModalPage;
    protected CycleCountsPage cycleCountsPage;
    protected AllOrdersPage allOrdersPage;
    protected SmartBoxedShipmentPage smartBoxedShipmentPage;

    private String reportPath = "reports/"+ LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
    private String htmlReport = reportPath + "/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm")) + "/Report.html";
    private static ExtentReports reports;
    public static ExtentTest report;



    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/monwarjalil/Documents/QA-web/bin/chromedriver_mac_64");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File(htmlReport);
        file.getParentFile().mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(htmlReport);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
    }

    @BeforeMethod(alwaysRun = true)
    public void loginUser(Method method) throws InterruptedException{
        report = reports.createTest(method.getName()+ Arrays.toString(method.getAnnotation(Test.class).groups()));
        driver.navigate().to("https://vpc-staging-smartboxed.boxed.com/login");
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        loginPage = new LoginPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method, ITestResult result) throws  InterruptedException {
        if(method.isAnnotationPresent(NeedsLogout.class))
            logoutUser();
        if(result.getStatus() == ITestResult.FAILURE){
            report.fail(result.getThrowable());
        }
        reports.flush();
    }

    @AfterSuite(alwaysRun = true)
    public void cleanUp(){
        driver.quit();
    }

    private void logoutUser() {
        driver.navigate().to("https://vpc-staging-smartboxed.boxed.com/");
        homePage = new HomePage();
        loginPage = homePage.header.signOut();
    }

}
