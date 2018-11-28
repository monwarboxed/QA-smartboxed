package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/7/18.
 */
public class UserDetailsPage extends AbstractPage {


    public UserDetailsPage() {verifyPresence();}

    public Header header = new Header();

    By userDetailSectionLocator = By.cssSelector("body > div.container > h3");

    public void verifyPresence() {wait.until(visibilityOfElementLocated(userDetailSectionLocator));}

    By emailFieldLocator = By.id("email");

    By passwordFieldLocator = By.id("password");

    By confirmFieldLocator = By.id("confirm-password");

    By overridePasswordFieldLocator = By.id("override-password");

    By roleSelectorLocator =  By.cssSelector("#role");

    By sourceSelectorLocator = By.cssSelector("#source");

    By warehouseSelectorLocator = By.cssSelector("#warehouse");

    By addButtonLocator = By.cssSelector("#add-user");

    By cancelButtonLocator = By.cssSelector("body > div.container > div > div > div > a.btn.btn-default");

    public UserTabPage createUser () throws  InterruptedException {
        type(emailFieldLocator, "testqa5@boxed.com");
        type(passwordFieldLocator, "Boxed123");
        type(confirmFieldLocator, "Boxed123");
        click(elementBy(addButtonLocator));
        return new UserTabPage();
    }

}
