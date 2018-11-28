package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/5/18.
 */
public class UserTabPage extends AbstractPage {
    public UserTabPage() {verifyPresence();}

    public Header header = new Header();

    By UserSectionPageLocator = By.cssSelector("body > div.container > h3");

    public void verifyPresence() {wait.until(visibilityOfElementLocated(UserSectionPageLocator));}

    By addButtonLocator = By.linkText("Add");

    public UserDetailsPage addUser () {
        click(wait.until(elementToBeClickable(addButtonLocator)));
        return  new UserDetailsPage();

    }


}
