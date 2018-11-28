package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/6/18.
 */
public class Header extends AbstractPage{
    public Header() {
        PageFactory.initElements(driver, this);
        verifyPresence();
    }

    public void verifyPresence() {wait.until(visibilityOfElementLocated(HeaderSectionLocator));}

    By HeaderSectionLocator = By.className("navbar");

    By SignOutLinkLocator = By.linkText("Sign out");

    By SmartBoxedLogoLocator = By.className("navbar-brand");

    By UsersLinkLocator = By.linkText("Users");

    By ConfigsLinkLocator = By.linkText("Configs");

    By BatchPoolsLinkLocator = By.linkText("Batch pools");

    By UserDetailsLinkLocator = By.cssSelector("body > div.header > div > div > div > ul:nth-child(3) > li > a");

    @FindBy(css = "#inventoryMenu")
    private WebElement inventory;

    @FindBy(css = "#ordersMenu")
    private WebElement orders;

    public LoginPage signOut() {
      click(wait.until(visibilityOfElementLocated(SignOutLinkLocator)));
      return new LoginPage();
    }

    public HomePage smartBoxedLogo() {
        click(wait.until(visibilityOfElementLocated(SmartBoxedLogoLocator)));
        return new HomePage();
    }

    public UserTabPage navigateToUserTabPage() {
        click(wait.until(visibilityOfElementLocated(UsersLinkLocator)));
        return new UserTabPage();
    }

    public ConfigPages navigateToConfigPage() {
        click(wait.until(visibilityOfElementLocated(ConfigsLinkLocator)));
        return new ConfigPages();
    }

    public BatchPoolPage navigateToBatchPoolPage() {
        click(wait.until(visibilityOfElementLocated(BatchPoolsLinkLocator)));
        return new BatchPoolPage();
    }

    public UserDetailsPage navigateToUserDetailsPage() {
        click(wait.until(visibilityOfElementLocated(UserDetailsLinkLocator)));
        return new UserDetailsPage();
    }

    public void hoverOnInventoryTab() throws InterruptedException {
        Actions action  = new Actions(driver);

        System.out.println("inventory " + inventory.getSize());
        action.moveToElement(inventory).perform();
    }

    public void hoverOnOrderTab() throws  InterruptedException {
        System.out.println("orders" + orders.getSize());
        actions.moveToElement(orders).perform();
    }

}
