package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by monwarjalil on 11/6/18.
 */
public class LoginPage extends AbstractPage {
    public LoginPage() {
        verifyPresence();
    }

    public void verifyPresence() {wait.until(visibilityOfElementLocated(bodySectionLocator));}

    By bodySectionLocator = By.className("login");

    By emailFieldLocator = By.cssSelector("[name='username']");

    By passwordFieldLocator = By.cssSelector("[name='password']");

    By signInButtonLocator = By.cssSelector("button");

    public HomePage signInUser() throws InterruptedException {
        type(emailFieldLocator, "testuser@boxed.com");
        Thread.sleep(3000);
        type(passwordFieldLocator, "Boxed123");
        Thread.sleep(3000);
        click(wait.until(elementToBeClickable(signInButtonLocator)));
        return new HomePage();
    }

    public void invalidUser() {
        type(emailFieldLocator, "sfsaa");
        type(passwordFieldLocator, "hghfg");
        click(wait.until(elementToBeClickable(signInButtonLocator)));
    }

    public void observeLoginPresence() {
        visibilityOfElementLocated(bodySectionLocator);
        visibilityOfElementLocated(emailFieldLocator);
        visibilityOfElementLocated(passwordFieldLocator);
        visibilityOfElementLocated(signInButtonLocator);
    }
}
